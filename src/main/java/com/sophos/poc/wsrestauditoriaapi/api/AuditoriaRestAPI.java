package com.sophos.poc.wsrestauditoriaapi.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sophos.poc.wsrestauditoriaapi.model.Accion;
import com.sophos.poc.wsrestauditoriaapi.model.Estado;
import com.sophos.poc.wsrestauditoriaapi.service.ActiveMqRestClientService;
import com.sophos.poc.wsrestauditoriaapi.service.SecurityService;
import com.sophos.poc.wsrestauditoriaapi.utils.AuditoriaRestAPIProcessExceptions;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("api/actividad")
public class AuditoriaRestAPI {

	@SuppressWarnings("unused")
	private final ObjectMapper objectMapper;
	private final HttpServletRequest request; 
	@Autowired
	private ActiveMqRestClientService toActive;
	@Autowired
	private AuditoriaRestAPIProcessExceptions pExceptions;
	@Autowired
	private SecurityService security;

	
	private static final Logger logger = LogManager.getLogger(AuditoriaRestAPI.class);
	
	public AuditoriaRestAPI(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}
	

	@ApiOperation(value = "Servicio de auditoria para guardar las acciones del usuario")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Transacción Exitosa"),
			@ApiResponse(code = 200, message = "Transacción Exitosa"),
			@ApiResponse(code = 206, message = "Se genero un error de negocio"),
			@ApiResponse(code = 400, message = "Error de autorizacion"),
			@ApiResponse(code = 401, message = "Error de autorizacion"),
			@ApiResponse(code = 403, message = "No esta autorizado para consultar el recurso solicitado"),
			@ApiResponse(code = 404, message = "No se ha encontrado el recurso solicitado"),
			@ApiResponse(code = 405, message = "Ha ocurrido un error en la invocación"),
			@ApiResponse(code = 500, message = "Ha ocurrido un error en la invocación"),
			@ApiResponse(code = 501, message = "Ha ocurrido un error en la invocación"),
			@ApiResponse(code = 503, message = "Ha ocurrido un error en la invocación")		
			})
	@PostMapping(path="/add" , consumes = "application/json", produces = "application/json")
    public ResponseEntity<Estado> addActividad(
    		@ApiParam(value = "Identificador Único con formato de 32 dígitos hexadecimales divididos en guiones: 550e8400-e29b-41d4-a716-446655440000" ,required=true)
    		@RequestHeader(value="X-RqUID", required=true) String xRqUID,
    		@ApiParam(value = "Nemonico de Canal Origen de la Transaccion" ,required=true) 
    		@RequestHeader(value="X-Channel", required=true) String xChannel,
    		@ApiParam(value = "IP de origen donde se realiza la invocación de servicio o api" ,required=true) 
    		@RequestHeader(value="X-IPAddr", required=true) String xIPAddr,
    		@ApiParam(value = "Sesion o token de autenticación del uso del api" ,required=true) 
    		@RequestHeader(value="X-Sesion", required=true) String xSesion,
    		@ApiParam(value = "Bandera para validacion de seguridad" ,required=true) 
    		@RequestHeader(value="X-haveToken", required=false) String xHaveToken,
    		@ApiParam(value = "Definicion de accion de usuario a registrar" ,required=true )
    		@Valid @RequestBody  Accion body) {		
    	String contentType = request.getContentType();
    	String tokenSesion = request.getHeader("X-Sesion");
    	String securityValidation = request.getHeader("X-haveToken");  
    	logger.info("AuditoriaRq:  contentType= " + contentType + " IdSesion="+body.getIdSesion());
    	String statusRs = null;
		if (contentType != null && contentType.contains("application/json") && tokenSesion != null	&& !tokenSesion.equals("")) {			
			Estado response= new Estado();
			try {				
				if ( ( securityValidation != null && securityValidation.equals("false")) ||
						 security.verifyJwtToken(tokenSesion, body.getIdSesion()).equals(HttpStatus.ACCEPTED)) {
					toActive.publishMessage(body);
					statusRs = HttpStatus.OK.toString();
					return new ResponseEntity<>(HttpStatus.OK);
				}else {
					response.setCodigo(HttpStatus.UNAUTHORIZED.toString());
					response.setMensaje(HttpStatus.UNAUTHORIZED.toString());
					statusRs = HttpStatus.UNAUTHORIZED.toString();
					return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
				}
			} catch (Exception e) {
				response = pExceptions.recordFailureResponse(e);
				logger.error("Error Auditoria: ", e);
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}finally {
				logger.info("AuditoriaRs:  " + statusRs );
			}
		}
        return new ResponseEntity<Estado>(HttpStatus.UNAUTHORIZED);
    }
	
}
