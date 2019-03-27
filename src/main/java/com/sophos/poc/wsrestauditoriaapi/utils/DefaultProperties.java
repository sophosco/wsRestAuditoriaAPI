package com.sophos.poc.wsrestauditoriaapi.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultProperties {
	private String queue;
	private String endpoint;
	private String user;
	private String pass;
	private String securityEndpointValidate;
	private static String file = "configuration.properties";
	private static DefaultProperties instance = null;

	private static final Logger logger = LogManager.getLogger(DefaultProperties.class);

	public DefaultProperties getInstance() {
		if (instance == null) {
			return instance = new DefaultProperties();
		}
		return instance;
	}

	public DefaultProperties() {
		Properties pr = new Properties();
		try {
			Constantes cts = new Constantes();
			InputStream inputStream = DefaultProperties.class.getClassLoader().getResourceAsStream(file);
			pr.load(inputStream);
			String envEP = System.getenv().get(cts.POC_ACTIVE_ENDPOINT);
			String envQU = System.getenv().get(cts.POC_ACTIVE_QUEUE);
			String envUS = System.getenv().get(cts.POC_ACTIVE_USR);
			String envPS = System.getenv().get(cts.POC_ACTIVE_PSS);
			String envSE = System.getenv().get(cts.POC_SERVICE_SECURITY_VALIDATE);
			setEndpoint(envEP != null && envEP != "" ? envEP : pr.getProperty(cts.PRP_FILE_ENDPOINT));
			setQueue(envQU != null && envQU != "" ? envQU : pr.getProperty(cts.PRP_FILE_QUEUE));
			setUser(envUS != null && envUS != "" ? envUS : pr.getProperty(cts.PRP_FILE_USR));
			setPass(envPS != null && envPS != "" ? envPS : pr.getProperty(cts.PRP_FILE_PSS));
			setSecurityEndpointValidate(envSE != null && envSE != "" ? envSE : pr.getProperty(cts.PRP_FILE_SECURITY_VALIDATE));
		} catch (IOException ex) {
			logger.error("Problem occurs when reading Default Properties !!!", ex);
		}

	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSecurityEndpointValidate() {
		return securityEndpointValidate;
	}

	public void setSecurityEndpointValidate(String securityEndpointValidate) {
		this.securityEndpointValidate = securityEndpointValidate;
	}
	
}
