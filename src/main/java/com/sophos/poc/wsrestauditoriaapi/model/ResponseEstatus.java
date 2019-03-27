package com.sophos.poc.wsrestauditoriaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseEstatus {

	@JsonProperty("code")
	private String code = null;
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
}
