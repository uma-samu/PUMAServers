package com.rackspace.testpuma.servers;

import org.apache.log4j.Logger;

import com.rackspace.testpuma.model.Server;
import com.rackspace.testpuma.model.ServerStatus;

/**
* This is the class to Build the server
* Generally the scripts will be invoked to build the servers in real
* This class mocks up that building activity of the server
* 
* @author  Umadevi Samudrala
* @version 1.0
* @since   2016-05-25 
*/
public class ServerBuilder extends Thread {

	final static Logger logger = Logger.getLogger(ServerBuilder.class);
	
	private Thread builder;
	private String builderName;
	private Server server;

	/**
	 * Constructor for creating the thread object
	 * @param name
	 * @param server
	 */
	public ServerBuilder(String name, Server server) {
		this.builderName = name;
		this.server = server;
		logger.info("Creating the server with serverId " + builderName);
	}

	/**
	 * Run method for the thread object
	 * This method makes the server sleeps for 35sec to give the user the feel of the server build
	 */
	public void run() {
		logger.debug("Run method ... Creating the server with serverId " + builderName);
		try {
			logger.info("Server is building, ServerId : "+builderName);
			Thread.sleep(35000);
			server.setServerStatus(ServerStatus.RUNNING);
			logger.info("Server Built is completed. Server is now running. ServerId : "+builderName);
		} catch (InterruptedException e) {
			logger.error("ServerBuilder Thread " + builderName + " interrupted.");
		}
		logger.debug("ServerBuilder Thread " + builderName + " exiting.");
	}

	/**
	 * Start method to invoke a thread
	 */
	public void start() {
		logger.debug("Starting ServerBuilder Thread" + builderName);
		if (builder == null) {
			builder = new Thread(this, builderName);
			builder.start();
		}
	}
}
