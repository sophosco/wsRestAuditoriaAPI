package com.sophos.poc.wsrestauditoriaapi.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sophos.poc.wsrestauditoriaapi.model.SecurityRequestHeader;
import com.sophos.poc.wsrestauditoriaapi.model.SecurityRequestPayload;
import com.sophos.poc.wsrestauditoriaapi.model.SecurityRq;
import com.sophos.poc.wsrestauditoriaapi.model.SecurityRs;
import com.sophos.poc.wsrestauditoriaapi.utils.Constantes;
import com.sophos.poc.wsrestauditoriaapi.utils.DefaultProperties;


@Service
public class SecurityService {

	@Autowired
	DefaultProperties pr;
	@Autowired
	Constantes cts;
	
	public HttpStatus verifyJwtToken(String token, String payload) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		SecurityRq inRequest = new SecurityRq();
		SecurityRequestHeader requestHeader = new SecurityRequestHeader();
		SecurityRequestPayload requestPayload = new SecurityRequestPayload(); 
		requestHeader.setToken(token);
		requestPayload.setId(payload);
		inRequest.setRequestHeader(requestHeader );
		inRequest.setRequestPayload(requestPayload );
		
		HttpEntity<SecurityRq> request = new HttpEntity<SecurityRq>(inRequest ,headers);
		RestTemplate restTemplate = new RestTemplate();
		SecurityRs response = restTemplate.exchange(pr.getSecurityEndpointValidate(),HttpMethod.POST,request , SecurityRs.class).getBody();
		
		if (response.getResponseHeader().getStatus().getCode().equals(cts.SECURITY_SUCCESS)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.UNAUTHORIZED;
	}
}
