package com.rackspace.testpuma.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.rackspace.testpuma.exceptions.ServerNotFoundException;
import com.rackspace.testpuma.model.Server;
import com.rackspace.testpuma.model.ServerStatus;
import com.rackspace.testpuma.servers.MockServers;
import com.rackspace.testpuma.servers.ServerBuilder;

/**
* This is Service layer class for doing the operations for the
* server creation, building, running and destroying
* 
* @author  Umadevi Samudrala
* @version 1.0
* @since   2016-05-25 
*/
@Component
public class ServerService {
	
	final static Logger logger = Logger.getLogger(ServerService.class);
	
	private Map<Integer, Server> servers = MockServers.getServers();


	/**
	 * Constructor. Initially defines few servers with initial configurations
	 */
	public ServerService(){
		logger.info("Initilizing the ServerService");
		servers.put(1001, new Server(1001, "Test Server1", 5, 30, 30, ServerStatus.RUNNING));
		servers.put(1002, new Server(1002, "Test Server2", 5, 30, 30, ServerStatus.RUNNING));
		servers.put(1003, new Server(1003, "Test Server3", 5, 30, 30, ServerStatus.RUNNING));
		servers.put(1004, new Server(1004, "Test Server4", 5, 30, 30, ServerStatus.RUNNING));
		logger.info("Initilizing the ServerService Done");
	}
	
	/**
	 * Method to get all the server details
	 * @return The list of servers
	 */
	public List<Server> getAllServers(){
		logger.info("Getting the all server details");
		return new ArrayList<Server>(servers.values());
	}
	
	/**
	 * Method to retrieve the server by given server id
	 * @param id
	 * @return Server configuration
	 */
	public Server getServerById(int id){
		logger.info("Getting the server details by id");
		Server server = servers.get(id);
		if(server==null){
			System.out.println("Server is not there");
			throw new ServerNotFoundException("Server not found with id "+id);
		}
		return server;
	}

	/**
	 * Method to create a server by taking the server configuration
	 * @param server
	 * @return Server Configuration of newly created server
	 */
	public Server createServer(Server server){
		logger.info("Creating the Server with the given details");
		int id = servers.size()+1+1000;
		logger.info("The Server id is "+id);
		server.setServerId(id);
		server.setServerStatus(ServerStatus.BUILDING);
		ServerBuilder serverBuilder = new ServerBuilder(""+id, server);
		serverBuilder.start();
		servers.put(id, server);
		return server;
	}
	
	/**
	 * Delete a server by giving the server id
	 * @param serverId
	 * @return Server configuration
	 */
	public Server deleteServer(int serverId){
		logger.info("Destroying the server");
		Server server = getServerById(serverId);
		server.setServerStatus(ServerStatus.DESTROYED);
		return server;
	}
}
