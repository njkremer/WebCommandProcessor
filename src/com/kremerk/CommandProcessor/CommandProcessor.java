package com.kremerk.CommandProcessor;


public interface CommandProcessor {
	public Object processCommand(String commandSetName, String commandName, String... parameters) throws CommandProcessorException ;
}
