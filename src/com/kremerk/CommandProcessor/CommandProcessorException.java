package com.kremerk.CommandProcessor;

public class CommandProcessorException extends Exception {
	private static final long serialVersionUID = 3593905317475772937L;

	public CommandProcessorException(String message) {
		super(message);
	}
	
	public CommandProcessorException(String message, Throwable t) {
		super(message, t);
	}
}
