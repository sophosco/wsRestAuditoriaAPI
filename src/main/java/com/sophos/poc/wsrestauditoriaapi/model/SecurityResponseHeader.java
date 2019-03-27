package com.sophos.poc.wsrestauditoriaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecurityResponseHeader {

	@JsonProperty("responseInfo")
	private ResponseInfo responseInfo = null;
	
	@JsonProperty("status")
	private ResponseEstatus status = null;

	public ResponseInfo getResponseInfo() {
		return responseInfo;
	}

	public void setResponseInfo(ResponseInfo responseInfo) {
		this.responseInfo = responseInfo;
	}

	public ResponseEstatus getStatus() {
		return status;
	}

	public void setStatus(ResponseEstatus status) {
		this.status = status;
	}
	
	
}
