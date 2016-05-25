# PUMAServers
Demo for REST API Project

#Purpose
###Introduction
This Application is used for managing the servers on the Cloud. On the Cloud, a Server can be created, the created server can be used for some activity and when the server is no longer required the server can be destroyed.

###Scope
The scope of this project is to create the REST API for doing the below operations

1. Create a Server
2. Get the Server Information
3. Destroy the Server

###Assumptions

1. This REST API does not include the authentication and authorization
2. The Create Server API will mock the functionality of server creation for the demo purpose. It will not actually create a server in the cloud.
3. The Destroy Server API will not remove the server from the list. It will update the status of the server as DESTROYED.
4. We have 3 types of Server Status - RUNNING, DESTROYED, BUILDING
5. Test results are done on the local machine. Server running on 8080 port

###How to build
mvn clean install

###Deployment
Deploy on the web server like Apache Tomcat

---

#REST API Design

| Operation        | URI           | Method  | Success/Failure | Status Code|
| ---------------- |:-------------:| -------:|----------------:|-----------:|
| Get Servers      | /webapi/servers | GET |Success|200|
||||Not Found|404|
||||Failure|500|
| Get Server By Id      | /webapi/servers/{serverId} | GET |Success|200|
||||Not Found|404|
||||Failure|500|
| Create Server      | /webapi/servers | POST |Success|201|
||||Wrong Data|400 or 415|
||||Failure|500|
| Destroy Server      | /webapi/servers/{serverId} | DELETE |Success|200 or 204|
||||Not Found|404|
||||Failure|500|

##Get Servers

This webservice request is used to get all the server details that are available. The Output will be a JSON with the list of all the servers. 

1. URL = http://localhost:8080/PUMAServers/webapi/servers
2. HTTP Method = GET
3. Send the request and get the response.

---

##Get Server By Id
The input to this service will be the server id. Output will be the server configuration of the requested server. 

1. URL = http://localhost:8080/PUMAServers/webapi/servers/1001
2. HTTP Method = GET
3. Send the request and get the response.

---

##Create Server
This webservice is used to create the server with the help of the configuration provided. The input will be a JSON request containing the server configuration. Output will be JSON object containing the server configuration of the server that is created, along with the current status.

1. URL = http://localhost:8080/PUMAServers/webapi/servers
2. HTTP Method = POST
3. Set the headers as follows - > Content-Type:application/json
4. In the body, select the type as raw and paste the json request
5. Invoke the service to get the response

After 35 sec, if the get request is done on the same server, we get the status as RUNNING, if the server is built correctly.

---

##Delete Server
This API is used to destroy the server when the server is no longer needed. Input will be the server id.

1. URL = http://localhost:8080/PUMAServers/webapi/servers/1001
2. HTTP Method = DELETE
3. Send the request and get the response.

---


