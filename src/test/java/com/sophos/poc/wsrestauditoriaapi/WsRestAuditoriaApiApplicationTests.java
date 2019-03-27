package com.sophos.poc.wsrestauditoriaapi;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sophos.poc.wsrestauditoriaapi.api.AuditoriaRestAPI;
import com.sophos.poc.wsrestauditoriaapi.model.Accion;

public class WsRestAuditoriaApiApplicationTests {

	private MockMvc mockMvc;
	@InjectMocks
	AuditoriaRestAPI controller;
	
	@Mock
	MockHttpServletRequest request;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).addPlaceholderValue("X-Session", "123132").build();
	}

	@Test
	public void test_addAuditAction_badRequest() throws Exception {

	    mockMvc.perform(
	    		MockMvcRequestBuilders.post("/api/actividad/add")
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .header("X-RqUID", "123456")
	                    .header("X-Channel", "POC"))
	            		.andExpect(MockMvcResultMatchers.status().is4xxClientError());	   
	    
	    
	}
	
	@Test
	public void test_addAuditAction_non_autorizaed() throws Exception {
		Accion accion = new Accion();
		accion.setDescripcionAccion("Desc");
		accion.setIdSesion("123456789");
		accion.setIdProducto("1");
		accion.setIdCategoria("1");
		accion.setFechaCreacion(null);
		accion.setTipoAccion("COnsulta");
		String srequest = asJsonString(accion);
		request = new MockHttpServletRequest();
		request.setContentType("application/json");
	    mockMvc.perform(
	    		MockMvcRequestBuilders.post("/api/actividad/add")
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .header("X-RqUID", "123456")
	                    .header("X-Channel", "POC")
	                    .header("X-IPAddr", "10.10.10.1")
	                    .header("X-Sesion", "1234564654")
	                    .content(srequest)
	                    .sessionAttr("X-Sesion", "1231321")
	                    .requestAttr("X-Sesion", "value")
	                    .flashAttr("X-Sesion", "111111"))
	            		.andExpect(MockMvcResultMatchers.status().is4xxClientError());  	    
	 }
	
    /*
     * converts a Java object into JSON representation
     */
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
