package com.kremerk.commandprocessor.response;

import org.json.JSONArray;

public class JsonResponse implements Response {
	public JsonResponse(JSONArray data) {
		this.data = data;
	}
	
	public JsonResponse(int status, String message, JSONArray data) {
		this.message = message;
		this.status = status;
		this.data = data;
	}
	
	public String getResponse() {
		return String.format(template, status, message, data.toString());
	}
	
	public String getContentType() {
		return "text/javascript";
	}
	
	private JSONArray data;
	private String message = "Status OK";
	private int status = 0;
	private final static String template = "{\"status\":%s, \"message\":\"%s\", \"data\":%s}";
}
