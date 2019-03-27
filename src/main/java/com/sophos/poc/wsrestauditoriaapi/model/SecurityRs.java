package com.sophos.poc.wsrestauditoriaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecurityRs {

	@JsonProperty("responseHeader")
	private SecurityResponseHeader responseHeader = null;
	
	@JsonProperty("responsePayload")
	private SecurityResponsePayload responsePayload = null;

	public SecurityResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(SecurityResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public SecurityResponsePayload getResponsePayload() {
		return responsePayload;
	}

	public void setResponsePayload(SecurityResponsePayload responsePayload) {
		this.responsePayload = responsePayload;
	}
	
	
}
