package com.kremerk.commandprocessor.response;

public enum ResponseType {
	JSON("json"),
	BINARY("binary");
	
	ResponseType(String type) {
		this.type = type;
	}
	
	public static ResponseType getResponseTypeFromString(String type) {
		return ResponseType.valueOf(type.toUpperCase());
	}
	
	public String getType() {
		return type;
	}
	private String type;
}
