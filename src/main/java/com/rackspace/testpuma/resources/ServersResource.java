package com.rackspace.testpuma.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rackspace.testpuma.model.Link;
import com.rackspace.testpuma.model.Server;
import com.rackspace.testpuma.service.ServerService;

/**
* This is the resources class for the application
* All the requests containing /servers in the URI will be redirected to this class
*
* @author  Umadevi Samudrala
* @version 1.0
* @since   2016-05-25 
*/
@Component
@Path("/servers")
public class ServersResource {
	
	final static Logger logger = Logger.getLogger(ServersResource.class);
	
	public ServersResource(){
		
	}
	
	public ServersResource(ServerService serverService){
		this.serverService = serverService;
	}

	/**
	 * Services layer class
	 */
	@Autowired
	private ServerService serverService;

	/**
	 * Method to get all the server details
	 * @return the list of Servers in the form of JSON
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Server> getServers() {
		logger.info("@GET /PUMAServers/webapi/servers Invoked");
		return serverService.getAllServers();
	}

	/**
	 * Method to retrieve the server information by id
	 * @param serverId
	 * @param uriInfo
	 * @return Server details
	 */
	@GET
	@Path("/{serverId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Server getServerById(@PathParam("serverId") int serverId,
			@Context UriInfo uriInfo) {
		logger.info("@GET /PUMAServers/webapi/servers/"+serverId+" Invoked");
		Server server = serverService.getServerById(serverId);
		Server outServer = new Server(server.getServerId(),
				server.getServerName(), server.getNoOfCPUs(),
				server.getRamSize(), server.getDiskSpace(), server.getServerStatus());
		String uriPath = getURISelf(uriInfo, server);
		Link link = new Link();
		link.setHref(uriPath);
		link.setRelation("self");
		outServer.setLink(link);
		return outServer;
	}

	/**
	 * Method to get the URI for the self 
	 * @param uriInfo
	 * @param server
	 * @return String containing the URI
	 */
	private String getURISelf(UriInfo uriInfo, Server server) {
		String uriPath = uriInfo.getBaseUriBuilder()
				.path(ServersResource.class)
				.path(Integer.toString(server.getServerId())).build()
				.toString();
		return uriPath;
	}

	/**
	 * Method to create the server
	 * @param server
	 * @param uriInfo
	 * @return The webservice response
	 * @throws URISyntaxException
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createServer(Server server, @Context UriInfo uriInfo)
			throws URISyntaxException {
		logger.info("@POST /PUMAServers/webapi/servers Invoked");
		Server newServer = serverService.createServer(server);
		String id = String.valueOf(newServer.getServerId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
		return Response.created(uri).entity(newServer).build();
	}

	/**
	 * Method to destroy the server
	 * @param serverId
	 */
	@DELETE
	@Path("/{serverId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteServer(@PathParam("serverId") int serverId) {
		logger.info("@DELETE /PUMAServers/webapi/servers Invoked");
		serverService.deleteServer(serverId);
	}

}
