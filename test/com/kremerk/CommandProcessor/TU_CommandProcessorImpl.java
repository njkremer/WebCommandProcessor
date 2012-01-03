package com.kremerk.commandprocessor;

import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;

import com.kremerk.commandprocessor.CommandProcessorImpl;
import com.kremerk.commandprocessor.CommandSet;
import com.kremerk.commandprocessor.exception.CommandProcessorException;

public class TU_CommandProcessorImpl {

	@Before
	public void setUp() {
		cp.addCommandSet(new CmdSetOne());
	}
	
	@Test
	public void testRunningASimpleCommand() throws CommandProcessorException {
		JSONArray array = (JSONArray) cp.processCommand("CmdSetOne", "testCommandOne", (String []) null);
		assertEquals("[1,2,3]", array.toString());
	}
	
	@Test
	public void testRunningACommandThatHasParameters() throws CommandProcessorException {
		JSONArray array = (JSONArray) cp.processCommand("CmdSetOne", "testCommandTwo", "5", "6");
		assertEquals("[\"5\",\"6\"]", array.toString());
	}
	
	class CmdSetOne implements CommandSet {
		public JSONArray testCommandOne(String... parameters) {
			JSONArray array = new JSONArray();
			array.put(1);
			array.put(2);
			array.put(3);
			return array;
		}
		
		public JSONArray testCommandTwo(String... parameters) {
			String p1 = parameters[0];
			String p2 = parameters[1];
			JSONArray array = new JSONArray();
			array.put(p1);
			array.put(p2);
			return array;
		}
	}
	
	CommandProcessorImpl cp = new CommandProcessorImpl();
}
