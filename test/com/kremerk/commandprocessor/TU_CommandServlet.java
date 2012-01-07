package com.kremerk.commandprocessor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class TU_CommandServlet {

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        cmdProcessor.addCommandSet(new CmdSetOne());
        when(mockResponse.getWriter()).thenReturn(writer);
        when(mockRequest.getParameter("type")).thenReturn("json");
    }

    @Test
    public void testHandlingACommandWithNoParameters() throws ServletException, IOException {
        when(mockRequest.getPathInfo()).thenReturn("/CmdSetOne/testCommandOne");

        servlet.doGet(mockRequest, mockResponse);

        verify(mockResponse).setContentType("text/javascript");
        writer.flush();
        assertEquals("{\"status\":0, \"message\":\"Status OK\", \"data\":[1,2,3]}", out.toString());

    }

    @Test
    public void testHandlingACommandWithParameters() throws ServletException, IOException {
        when(mockRequest.getPathInfo()).thenReturn("/CmdSetOne/testCommandTwo");
        when(mockRequest.getParameterValues("param")).thenReturn(new String[] {"a", "b"});

        servlet.doGet(mockRequest, mockResponse);

        verify(mockResponse).setContentType("text/javascript");
        writer.flush();
        assertEquals("{\"status\":0, \"message\":\"Status OK\", \"data\":[\"a\",\"b\"]}", out.toString());
    }

    @Test
    public void testHandlingAMockCommmand() throws ServletException, IOException {
        servlet.setMockRoot("/test/MockCommands");
        servlet.setMockMode(true);
        when(mockRequest.getPathInfo()).thenReturn("/MockCommandSet/MockCommand");
        
        servlet.doGet(mockRequest, mockResponse);
        
        verify(mockResponse).setContentType("text/javascript");
        writer.flush();
        assertEquals("{\"status\":0, \"message\":\"Status OK\", \"data\":[1,2,3]}", out.toString());
    }

    @Test
    public void testHandlingACommandWithNoTypeSpecified() throws ServletException, IOException {
        when(mockRequest.getPathInfo()).thenReturn("/CmdSetOne/testCommandTwo");
        when(mockRequest.getParameter("type")).thenReturn(null);
        
        servlet.doGet(mockRequest, mockResponse);
        
        verify(mockResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Type must be supplied when calling a command");
    }

    @Test
    public void testHandlingACommandWithAnInvalidTypeSpecified() throws ServletException, IOException {
        when(mockRequest.getPathInfo()).thenReturn("/CmdSetOne/testCommandTwo");
        when(mockRequest.getParameter("type")).thenReturn("xml");
        
        servlet.doGet(mockRequest, mockResponse);
        
        verify(mockResponse).sendError(eq(HttpServletResponse.SC_INTERNAL_SERVER_ERROR), anyString());
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

    @Mock
    private HttpServletRequest mockRequest;
    @Mock
    private HttpServletResponse mockResponse;
    private CommandProcessorImpl cmdProcessor = new CommandProcessorImpl();
    private CommandServlet servlet = new CommandServlet(cmdProcessor);
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private PrintWriter writer = new PrintWriter(out);
}
