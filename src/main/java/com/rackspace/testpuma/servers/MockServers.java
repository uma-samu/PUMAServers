package com.rackspace.testpuma.servers;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.rackspace.testpuma.model.Server;

/**
* This is the class to store the mock servers
* Practically we will have the list of servers maintained
* But this class maintains the server details in the form of a map
*
* @author  Umadevi Samudrala
* @version 1.0
* @since   2016-05-25 
*/
public class MockServers {
	
	final static Logger logger = Logger.getLogger(MockServers.class);

	private static Map<Integer, Server> servers = new HashMap<>();
	
	/**
	 * Method to retrieve the details of all the available servers
	 * @return The list of serverse
	 */
	public static Map<Integer, Server> getServers() {
		logger.info("Getting the servers - mocking the server details");
		return servers;
	}

}
