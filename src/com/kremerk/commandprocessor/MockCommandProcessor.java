package com.kremerk.commandprocessor;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;

import com.kremerk.commandprocessor.exception.CommandProcessorException;

public class MockCommandProcessor implements CommandProcessor {

	public MockCommandProcessor(String commandDir) {
		mockCommandDir = commandDir;
	}
	@Override
	public JSONArray processCommand(String commandSetName, String commandName, String... parameters) throws CommandProcessorException {
		StringBuilder sb = new StringBuilder();
		sb.append(mockCommandDir);
		sb.append(File.separator);
		sb.append(commandSetName);
		sb.append(File.separator);
		sb.append(commandName);
		if (parameters != null) {
			for (String s : parameters) {
				sb.append("_");
				sb.append(s);
			}
		}
		sb.append(".txt");
		File file = new File(sb.toString());
		String dataArray = "[]";
		if (file.exists()) {
			try {
				dataArray = FileUtils.readFileToString(file);
			} catch (IOException e) {
				throw new CommandProcessorException("Error reading mock command file.", e);
			}
		}
		try {
			return new JSONArray(dataArray);
		} catch (JSONException e) {
			throw new CommandProcessorException("Error creating JSON array from the command file data.", e);
		}
	}
	

    @Override
    public byte[] processBinaryCommand(String commandSetName, String commandName, String... parameters) throws CommandProcessorException {
        throw new UnsupportedOperationException();
    }
    
    private String mockCommandDir;

}
