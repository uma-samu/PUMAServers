package com.rackspace.test.servers;

import org.junit.Test;

import com.rackspace.testpuma.servers.MockServers;

import static org.junit.Assert.assertEquals;

public class MockServersTest {

	@Test
	public void testGetServers(){
		assertEquals(MockServers.getServers().size(), 5);
	}
}
