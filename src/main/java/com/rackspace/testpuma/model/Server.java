package com.rackspace.testpuma.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
* This is the model class for Server Details
*
* @author  Umadevi Samudrala
* @version 1.0
* @since   2016-05-25 
*/
@XmlRootElement(name="server")
public class Server {

	private int serverId;

	private String serverName;

	private int noOfCPUs;

	private int ramSize;

	private int diskSpace;
	
	private ServerStatus serverStatus;
	
	private Link link;
	
	public Server() {

	}

	public Server(int serverId, String serverName, int noOfCPUs, int ramSize,
			int diskSpace, ServerStatus serverStatus) {
		this.serverId = serverId;
		this.serverName = serverName;
		this.noOfCPUs = noOfCPUs;
		this.ramSize = ramSize;
		this.diskSpace = diskSpace;
		this.serverStatus = serverStatus;
	}

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public int getNoOfCPUs() {
		return noOfCPUs;
	}

	public void setNoOfCPUs(int noOfCPUs) {
		this.noOfCPUs = noOfCPUs;
	}

	public int getRamSize() {
		return ramSize;
	}

	public void setRamSize(int ramSize) {
		this.ramSize = ramSize;
	}

	public int getDiskSpace() {
		return diskSpace;
	}

	public void setDiskSpace(int diskSpace) {
		this.diskSpace = diskSpace;
	}

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}

	public ServerStatus getServerStatus() {
		return serverStatus;
	}

	public void setServerStatus(ServerStatus serverStatus) {
		this.serverStatus = serverStatus;
	}

}
