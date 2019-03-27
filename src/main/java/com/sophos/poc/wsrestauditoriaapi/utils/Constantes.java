package com.sophos.poc.wsrestauditoriaapi.utils;

import org.springframework.stereotype.Component;

@Component
public class Constantes {
	public final String STATUS_CODE_500 	= "500";
	public final String POC_ACTIVE_ENDPOINT = "POC_ACTIVE_ENDPOINT";
	public final String POC_ACTIVE_QUEUE 	= "POC_ACTIVE_QUEUE";
	public final String POC_ACTIVE_USR		= "POC_ACTIVE_USR";
	public final String POC_ACTIVE_PSS		= "POC_ACTIVE_PSS";
	public final String POC_SERVICE_SECURITY_VALIDATE = "POC_SERVICE_SECURITY_VALIDATE";
	
	public final String PRP_FILE_ENDPOINT	= "active.default.endpoint";
	public final String PRP_FILE_QUEUE		= "active.default.queue";
	public final String PRP_FILE_USR		= "active.default.user";
	public final String PRP_FILE_PSS		= "active.default.pass";
	public final String PRP_FILE_SECURITY_VALIDATE		= "security.endpoint.validate";
	
	public final String SECURITY_SUCCESS	= "00";
	
}
