package com.majani.mysolution.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "description", "ID", "previousID", "nextID", "parentID", "subtasks" })
public class SubTask implements Comparable<SubTask> {

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
	@JsonProperty("subtasks")
	private List<SubTask> subTasks;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public SubTask() {
		if (this.subTasks == null)
			this.subTasks = new ArrayList<SubTask>();
	}

	public SubTask(String description, int iD, Integer nextID, Integer parentID, Integer previousID,
			List<SubTask> subtasks) {
		super();
		this.description = description;
		this.iD = iD;
		this.nextID = nextID;
		this.parentID = parentID;
		this.previousID = previousID;
		this.subTasks = subtasks;
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

	public List<SubTask> getSubtasks() {
		return subTasks;
	}

	public void setSubtasks(List<SubTask> subtasks) {
		this.subTasks = subtasks;
	}

	public void addSubTaskItems(SubTask subTaskItem) {
		if (this.subTasks != null && !this.subTasks.contains(subTaskItem)) {
			this.subTasks.add(subTaskItem);
			Collections.sort(this.subTasks);
		}

	}

	public int compareTo(SubTask subTask) {
		return this.getID().compareTo(subTask.getID());
	}
}
