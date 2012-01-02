package com.kremerk.CommandProcessor;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.json.JSONArray;

public class CommandProcessorImpl implements CommandProcessor {

	
	public void addCommandSet(CommandSet commandSet) {
		commands.put(commandSet.getClass().getSimpleName(), commandSet);
	}
	
	public Object processCommand(String commandSetName, String commandName, String... parameters) throws CommandProcessorException {
		CommandSet commandSet = commands.get(commandSetName);
		try {
			Method command = commandSet.getClass().getDeclaredMethod(commandName, String[].class);
			Object[] o = new Object[1];
			o[0] = parameters;
			JSONArray response = (JSONArray) command.invoke(commandSet, o);
			return response;
		} catch (Exception e) {
			throw new CommandProcessorException("There was an error getting the command to run.", e);
		}
	}
	
	private HashMap<String, CommandSet> commands = new HashMap<String, CommandSet>();
	
}
