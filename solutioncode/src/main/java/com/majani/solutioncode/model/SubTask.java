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
	private Integer iD;
	@JsonProperty("nextID")
	private Integer nextID;
	@JsonProperty("parentID")
	private Integer parentID;
	@JsonProperty("previousID")
	private Integer previousID;

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
	public Integer getID() {
		return iD;
	}

	@JsonProperty("ID")
	public void setID(Integer iD) {
		this.iD = iD;
	}

	@JsonProperty("nextID")
	public Integer getNextID() {
		return nextID;
	}

	@JsonProperty("nextID")
	public void setNextID(Integer nextID) {
		this.nextID = nextID;
	}

	@JsonProperty("parentID")
	public Integer getParentID() {
		return parentID;
	}

	@JsonProperty("parentID")
	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	@JsonProperty("previousID")
	public Integer getPreviousID() {
		return previousID;
	}

	@JsonProperty("previousID")
	public void setPreviousID(Integer previousID) {
		this.previousID = previousID;
	}

}
