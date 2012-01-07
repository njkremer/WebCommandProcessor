package com.kremerk.commandprocessor;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ContextHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server server = new Server(8080);
		
		ContextHandler handler = new ContextHandler();
		handler.setContextPath("/Test");
		server.setHandler(handler);

		Context root = new Context(server,"/Test",Context.SESSIONS);
		
		root.addServlet(new ServletHolder(new CommandServlet(null)), "/cmd/*");
		
			
		try {
			server.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
