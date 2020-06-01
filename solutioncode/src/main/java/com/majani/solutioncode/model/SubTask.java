package com.majani.mysolution.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "description", "ID", "previousID", "nextID", "parentID" })
public class SubTask {

	@JsonProperty("description")
	private String description;
	@JsonProperty("ID")
	private String iD;
	@JsonProperty("nextID")
	private String nextID;
	@JsonProperty("parentID")
	private String parentID;
	@JsonProperty("previousID")
	private String previousID;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public SubTask() {
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("ID")
	public String getID() {
		return iD;
	}

	@JsonProperty("ID")
	public void setID(String iD) {
		this.iD = iD;
	}

	@JsonProperty("nextID")
	public String getNextID() {
		return nextID;
	}

	@JsonProperty("nextID")
	public void setNextID(String nextID) {
		this.nextID = nextID;
	}

	@JsonProperty("parentID")
	public String getParentID() {
		return parentID;
	}

	@JsonProperty("parentID")
	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	@JsonProperty("previousID")
	public String getPreviousID() {
		return previousID;
	}

	@JsonProperty("previousID")
	public void setPreviousID(String previousID) {
		this.previousID = previousID;
	}

}
