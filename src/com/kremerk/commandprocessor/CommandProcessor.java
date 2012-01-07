package com.kremerk.commandprocessor;

import org.json.JSONArray;

import com.kremerk.commandprocessor.exception.CommandProcessorException;


public interface CommandProcessor {
	public JSONArray processCommand(String commandSetName, String commandName, String... parameters) throws CommandProcessorException;
	public byte[] processBinaryCommand(String commandSetName, String commandName, String... parameters) throws CommandProcessorException;
}
