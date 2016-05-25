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

###Deployment
Deploy on the web service like tomcat



