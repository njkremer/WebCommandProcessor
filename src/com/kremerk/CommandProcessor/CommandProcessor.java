package com.kremerk.commandprocessor;

import com.kremerk.commandprocessor.exception.CommandProcessorException;


public interface CommandProcessor {
	public Object processCommand(String commandSetName, String commandName, String... parameters) throws CommandProcessorException ;
}
