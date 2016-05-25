package com.rackspace.test.resources;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.UriInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.rackspace.testpuma.model.Server;
import com.rackspace.testpuma.model.ServerStatus;
import com.rackspace.testpuma.resources.ServersResource;
import com.rackspace.testpuma.service.ServerService;

@RunWith(MockitoJUnitRunner.class)
public class ServerResourcesInTest {
	ServerService serverService = new ServerService();

	@Mock
	ServersResource serversResource;
	
	@Before
	public void setUp() {
		System.out.println("Setting up inTEST");
		serversResource = new ServersResource(serverService);
	}

	@Test
	public void testGetServers() {
		List<Server> servers = serversResource.getServers();
		assertEquals(servers.size(), 5);
	}
	
	@Test
	public void testDeleteServer() {
		serversResource.deleteServer(1002);
	}

	/*@Test
	public void testGetServerById() {
    	UriInfo uriInfo = Mockito.mock(UriInfo.class);
    	Mockito.when(uriInfo.getBaseUriBuilder().path(ServersResource.class))
    	        .thenReturn(URI.create("http://localhost:8080/PUMAServers"));
		Server server = serversResource.getServerById(1001, uriInfo);
		assertEquals(server.getServerName(), "Test Server1");
		assertEquals(server.getServerStatus(), ServerStatus.RUNNING);
		assertEquals(server.getRamSize(), 30);
		assertEquals(server.getNoOfCPUs(), 5);
		assertEquals(server.getDiskSpace(), 30);
	}*/
}
