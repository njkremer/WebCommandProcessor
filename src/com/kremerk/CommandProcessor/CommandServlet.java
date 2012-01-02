package com.kremerk.CommandProcessor;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

public class CommandServlet extends HttpServlet {
	private static final long serialVersionUID = 8946402369349157361L;

	/**
	 * The CRUDServlet expects to take a command and a series of parameters.
	 * 
	 * <p>
	 * The url format is as follows:
	 * 
	 * <P>
	 * http://server:port/cmd=MyCoolCommand&param=1&param=2&param=blah
	 * http://server:port/CommandServletMapping/CommandSetName/CommandName/?param=1&param=2&param=blah
	 * 
	 * <p>
	 * The implementation of the MyCoolCommand class will need to appropriately
	 * handle the params passed in in the given order.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] contextPath = request.getContextPath().split("/");
		String commandSetName = contextPath[0];
		String commandName = contextPath[1];
		String[] parameters = request.getParameterValues("param");

		JsonResponse jsonResponse = null;
		JSONArray data = null;

		try {
			if (mockMode) {
				cmdProcessor = new MockCommandProcessor(mockCommandRoot);
			} else {
				cmdProcessor = new CommandProcessorImpl();
			}
			data = cmdProcessor.processCommand(commandSetName, commandName, parameters);
			jsonResponse = new JsonResponse(data);
		} catch (CommandProcessorException e) {
			jsonResponse = new JsonResponse(1, e.getMessage(), null);
		}
		String retValue = jsonResponse.toString();

		response.setContentType("text/javascript");
		response.getWriter().write(retValue);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void setMockMode(boolean mockMode) {
		this.mockMode = mockMode;
	}
	
	public boolean isMockMode() {
		return mockMode;
	}
	
	public void setMockRoot(String rootDirectory, String commandRoot) {
		mockCommandRoot = rootDirectory + File.separator + commandRoot;
	}
	
	public void setMockRoot(String commandRoot) {
		setMockRoot(System.getProperty("user.dir"), commandRoot);
	}
	
	private boolean mockMode = false;
	private String mockCommandRoot;
	private CommandProcessor cmdProcessor;
}
