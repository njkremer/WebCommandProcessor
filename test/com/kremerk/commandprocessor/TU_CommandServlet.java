package com.kremerk.commandprocessor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TU_CommandServlet {

	/*
	 * With a servlet mapping of root.addServlet(new ServletHolder(new CommandServlet()), "/cmd/*");
	 * 
	 * request.getRequestURI: /Test/cmd/MyCommandSet/MyCommand/
	 * request.getContextPath: /Test
     * request.getServletPath: /cmd
	 */
	@Before
	public void setUp() throws Exception {

	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testHandlingACommandWithNoParameters() {
		
	}
	
	@Test
	public void testHandlingACommandWithParameters() {
		
	}
	
	@Test
	public void testHandlingAMockCommmand() {
		
	}
	
	@Test
	public void testHandlingACommandWithNoTypeSpecified() {
		
	}
	
	@Test
	public void testHandlingACommandWithAnInvalidTypeSpecified() {
		
	}
	
}
