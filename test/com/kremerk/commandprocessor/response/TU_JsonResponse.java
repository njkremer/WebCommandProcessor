package com.kremerk.commandprocessor.response;

import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.junit.Test;

import com.kremerk.commandprocessor.response.JsonResponse;

public class TU_JsonResponse {
	@Test
	public void testGettingDefaultResponse() {
		JSONArray array = new JSONArray();
		array.put(1);
		array.put(2);
		array.put(3);
		JsonResponse resp = new JsonResponse(array);

		assertEquals("{\"status\":0, \"message\":\"Status OK\", \"data\":[1,2,3]}", resp.getResponse());
	}
	
	@Test
	public void testGettingCustomResponse() {
		JSONArray array = new JSONArray();
		array.put(1);
		array.put(2);
		array.put(3);
		JsonResponse resp = new JsonResponse(5, "No Good", array);
		
		
		assertEquals("{\"status\":5, \"message\":\"No Good\", \"data\":[1,2,3]}", resp.getResponse());
	}
}
