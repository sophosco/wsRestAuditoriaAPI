package com.sophos.poc.wsrestauditoriaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecurityRequestHeader {

	@JsonProperty("token")
	private String token = null;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
