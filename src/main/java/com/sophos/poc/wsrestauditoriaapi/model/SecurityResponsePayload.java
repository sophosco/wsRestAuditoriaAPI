package com.sophos.poc.wsrestauditoriaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecurityResponsePayload {

	@JsonProperty("verify")
	private String verify = null;

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}
	
}
