package com.njkremer.commandprocessor;

import org.json.JSONArray;

import com.njkremer.commandprocessor.exception.CommandProcessorException;


public interface CommandProcessor {
	public JSONArray processCommand(String commandSetName, String commandName, String... parameters) throws CommandProcessorException;
	public byte[] processBinaryCommand(String commandSetName, String commandName, String... parameters) throws CommandProcessorException;
}
