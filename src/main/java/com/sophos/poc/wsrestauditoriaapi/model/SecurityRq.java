package com.sophos.poc.wsrestauditoriaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecurityRq {

	@JsonProperty("requestHeader")
	private SecurityRequestHeader requestHeader = null;
	
	@JsonProperty("requestPayload")
	private SecurityRequestPayload requestPayload = null;
	
	
	public SecurityRequestHeader getRequestHeader() {
		return requestHeader;
	}

	public void setRequestHeader(SecurityRequestHeader requestHeader) {
		this.requestHeader = requestHeader;
	}

	public SecurityRequestPayload getRequestPayload() {
		return requestPayload;
	}

	public void setRequestPayload(SecurityRequestPayload requestPayload) {
		this.requestPayload = requestPayload;
	}

	

	
}
