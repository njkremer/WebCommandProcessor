package com.kremerk.commandprocessor;

/**
 * <p>A command set is a set of commands that will be run on a server.
 * 
 * The way this works is you make your class that implements CommandSet. The only resonse this exists
 * is for a little bit of type safety. This will work in tandem with the CommandProcessorImpl which
 * will actually run the command.
 * 
 * the class name of the class that implements the CommandSet will be the name of the CommandSet. Each
 * method inside the class that implements can be a command. The method name will be the command name.
 * Using reflection the CommandProcessorImpl will get the CommandSet that is registered to it and
 * will run the command function and return the data from it. <b>The expected return type of the methods in
 * the CommandSet is Object</b> The request to the CommandSevlet needs to have a type parameter passed to it
 * which will determent what it will cast the value from the CommandSet to.
 * 
 * <p>For a type of "json" or ResponseType.JSON, it will cast the result to a JSONArray
 * <p>For a type of "binary" or ResponseType.BINARY, it will cast the result to a byte[]
 * 
 * <p>Future response types could be supported, such as XML.
 *  
 * @author Nick
 *
 */
public interface CommandSet {

}
