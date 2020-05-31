package com.majani.mysolution.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "task", "subTasks" })
public class Task implements Comparable<Task> {

	@JsonProperty("task")
	private SubTask task;
	@JsonProperty("subTasks")
	private List<Task> tasksList;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Task() {
		if (this.tasksList == null)
			this.tasksList = new ArrayList<Task>();
	}

	@JsonProperty("task")
	public SubTask getTask() {
		return task;
	}

	@JsonProperty("task")
	public void setTask(SubTask task) {
		this.task = task;
	}

	@JsonProperty("subTasks")
	public List<Task> getTasksList() {
		return tasksList;
	}

	@JsonProperty("subTasks")
	public void setTasksList(List<Task> tasksList) {
		this.tasksList = tasksList;
	}

	public void addTaskItems(Task subTaskItem) {
		if (this.tasksList == null)
			this.tasksList = new ArrayList<Task>();
		if (this.tasksList != null && !this.tasksList.contains(subTaskItem)) {
			this.tasksList.add(subTaskItem);
			Collections.sort(this.tasksList);
		}

	}

	public int compareTo(Task task) {
		// TODO Auto-generated method stub
		return this.task.getID().compareTo(task.getTask().getID());
	}

}
