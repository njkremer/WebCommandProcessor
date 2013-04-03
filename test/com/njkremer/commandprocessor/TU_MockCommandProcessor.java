package com.njkremer.commandprocessor;

import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.junit.Test;

import com.njkremer.commandprocessor.MockCommandProcessor;
import com.njkremer.commandprocessor.exception.CommandProcessorException;

public class TU_MockCommandProcessor {
	@Test
	public void testGettingCommandWithNoParams() throws CommandProcessorException {
		JSONArray array = (JSONArray) cmdProcessor.processCommand("MockCommandSet", "MockCommand", (String[]) null);
		assertEquals("[1,2,3]", array.toString());
	}
	
	@Test
	public void testGettingCommandWithParameters() throws CommandProcessorException {
		JSONArray array = (JSONArray) cmdProcessor.processCommand("MockCommandSet", "MockCommand", "one", "two");
		assertEquals("[\"a\",\"b\",\"c\"]", array.toString());
	}
	
	MockCommandProcessor cmdProcessor = new MockCommandProcessor(System.getProperty("user.dir") + "/test/MockCommands");
}
