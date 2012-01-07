package com.kremerk.commandprocessor.response;

public class BinaryResponse implements Response {

	public BinaryResponse(byte[] data) {
		this.data = data;
	}

	@Override
	public byte[] getResponse() {
		return data;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private byte[] data;

}
