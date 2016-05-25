package com.rackspace.test.resources;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;

public class ServersResourceTest {

	@Test
	public void testGetServerById() {
		expect().statusCode(200)
				.body("serverStatus", equalTo("RUNNING"), 
						"serverName", equalTo("Test Server1"), 
						"serverId", equalTo("1001"), 
						"ramSize", equalTo("30")).when()
				.get("/PUMAServers/webapi/servers/1001");
	}
	
	@Test
	public void testGetServers() {
		expect().statusCode(200)
				.when().get("/PUMAServers/webapi/servers");
	}
	
	@Test
	public void testGetServersCheckServer() {
	  String json = get("/PUMAServers/webapi/servers").asString();
	  JsonPath jp = new JsonPath(json);
	  jp.setRoot("server");
	  Map server = jp.get("find {e -> e.serverId =~ 1001}");
	  assertEquals("RUNNING", server.get("serverStatus"));
	  assertEquals("Test Server1", server.get("serverName"));
	  assertEquals("30", server.get("ramSize"));
	  assertEquals("5", server.get("noOfCPUs"));
	  assertEquals("30", server.get("diskSpace"));
	}
	
	@Test
	public void testDeleteServer() {
		expect().statusCode(204)
				.delete("/PUMAServers/webapi/servers/1004");
	}
	
	@Test
	public void testCreateServer() {
		given().contentType("application/json")
			.body("{\"diskSpace\":\"30\" , \"noOfCPUs\":\"5\", \"ramSize\":\"50\", \"serverName\":\"TEST SERVER POST\"	}")
			.expect().statusCode(201)
			.body("serverStatus", equalTo("BUILDING"))
			.when()
			.post("/PUMAServers/webapi/servers");
	}
}
