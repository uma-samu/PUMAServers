package com.rackspace.testpuma.model;

/**
* This is the model class for Link
*
* @author  Umadevi Samudrala
* @version 1.0
* @since   2016-05-25 
*/
public class Link {

	private String href;
	
	private String relation;
	
	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
	
}
