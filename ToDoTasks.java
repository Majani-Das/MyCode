package com.majani.mysolution.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "task", "subTasks" })
public class ToDoTasks {

	@JsonProperty("task")
	private SubTask task;
	@JsonProperty("subTasks")
	private List<SubTask> subTasks = null;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public ToDoTasks() {
		if (this.subTasks == null)
			this.subTasks = new ArrayList<SubTask>();
	}

	/**
	 * 
	 * @param task
	 * @param subTasks
	 */
	public ToDoTasks(SubTask task, List<SubTask> subTasks) {
		super();
		this.task = task;
		this.subTasks = subTasks;
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
	public List<SubTask> getSubTasks() {
		return subTasks;
	}

	@JsonProperty("subTasks")
	public void setSubTasks(List<SubTask> subTasks) {
		this.subTasks = subTasks;
	}

}
