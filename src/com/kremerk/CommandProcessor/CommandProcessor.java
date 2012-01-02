package com.kremerk.CommandProcessor;

import org.json.JSONArray;

public interface CommandProcessor {
	public JSONArray processCommand(String commandSetName, String commandName, String... parameters) throws CommandProcessorException ;
}
