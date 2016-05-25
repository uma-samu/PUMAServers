package com.rackspace.test.service;

import java.util.List;

import org.junit.Test;

import com.rackspace.testpuma.exceptions.ServerNotFoundException;
import com.rackspace.testpuma.model.Server;
import com.rackspace.testpuma.model.ServerStatus;
import com.rackspace.testpuma.service.ServerService;

import static org.junit.Assert.assertEquals;

public class ServerServiceTest {

	private ServerService serverService = new ServerService();

	@Test
	public void testCreateServer(){
		Server server = new Server(0, "Test Create Server", 25, 45, 80, ServerStatus.BUILDING);
		Server createdServer = serverService.createServer(server);
		assertEquals(server.getServerName(), createdServer.getServerName());
		assertEquals(server.getServerStatus(), createdServer.getServerStatus());
		assertEquals(server.getRamSize(), createdServer.getRamSize());
		assertEquals(server.getNoOfCPUs(), createdServer.getNoOfCPUs());
		assertEquals(server.getDiskSpace(), createdServer.getDiskSpace());
	}
	
	@Test
	public void testGetServerByIdFailure() {
		boolean thrown = false;
		try {
			Server server = serverService.getServerById(1000);
		} catch (ServerNotFoundException e) {
			thrown = true;
		}
		assertEquals(thrown, true);
	}
	
	@Test
	public void testGetServerById() {
		Server server = serverService.getServerById(1001);
		assertEquals(server.getServerName(), "Test Server1");
		assertEquals(server.getServerStatus(), ServerStatus.RUNNING);
		assertEquals(server.getRamSize(), 30);
		assertEquals(server.getNoOfCPUs(), 5);
		assertEquals(server.getDiskSpace(), 30);
	}

	@Test
	public void testGetAllServers() {
		System.out.println("@testGetAllServers: onceExecutedBeforeAll");
		List<Server> servers = serverService.getAllServers();
		assertEquals(servers.size(), 5);
	}
	
	@Test
	public void testDestroyServer(){
		Server server = serverService.deleteServer(1002);
		assertEquals(server.getServerStatus(), ServerStatus.DESTROYED);
	}
	
}
