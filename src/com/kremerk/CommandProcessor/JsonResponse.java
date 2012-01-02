package com.kremerk.CommandProcessor;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonResponse extends JSONObject {
	public JsonResponse(JSONArray data) throws CommandProcessorException {
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
	
	private JSONArray data;
	private String message = "Status OK";
	private int status = 0;
	private final static String template = "{\"status\":%s, \"message\":\"%s\", \"data\":%s}";
}
