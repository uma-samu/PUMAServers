package com.rackspace.testpuma.exceptions;

/**
* Exception class for ServerNotFound
*
* @author  Umadevi Samudrala
* @version 1.0
* @since   2016-05-25 
*/
public class ServerNotFoundException extends RuntimeException{

	/**
	 * Constructor for the class
	 * @param message
	 */
	public ServerNotFoundException(String message){
		super(message);
	}

}
