package com.sophos.poc.wsrestauditoriaapi.utils;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sophos.poc.wsrestauditoriaapi.model.Estado;

@Component
public class AuditoriaRestAPIProcessExceptions {
	
	private static final Logger logger = LogManager.getLogger(AuditoriaRestAPIProcessExceptions.class);
	@Autowired
	private Constantes cts;
	
	public Estado recordFailureResponse(Exception ex) {
		Estado response = new Estado();
		response.setCodigo(cts.STATUS_CODE_500);
		response.setMensaje(ex.getMessage());
		if (ex != null) {
			ArrayList<String> exceptionList = processException(ex);			
			response.setExcepcion(exceptionList.toString());
		}
		return response;
	}
	private static ArrayList<String> processException(Exception ex) {
		Throwable innerException = ex.getCause();
		ArrayList<String> exceptionList = new ArrayList<>();
		if (innerException != null) {
			while (innerException != null) {
				logger.error("InnerException: ",innerException);
				exceptionList.add(innerException.getMessage());
				innerException = innerException.getCause();
			}
		}else {
			exceptionList.add(ex.getMessage());
		}	
		
		return exceptionList;
	}
}
