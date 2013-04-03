package com.njkremer.commandprocessor.response;

public enum ResponseType {
	JSON("json"),
	BINARY("binary"),
	UNSUPPORTED("");
	
	ResponseType(String type) {
		this.type = type;
	}
	
	public static ResponseType getResponseTypeFromString(String type) {
	    if(type == null || type.isEmpty()) {
	        return null;
	    }
	    else if(type.equals(ResponseType.JSON.getType())) {
	        return ResponseType.JSON;
	    }
	    else if(type.equals(ResponseType.BINARY.getType())){
	        return ResponseType.BINARY;
	    }
	    else {
	        return ResponseType.UNSUPPORTED;
	    }
	}
	
	public String getType() {
		return type;
	}
	private String type;
}
