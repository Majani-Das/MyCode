package com.majani.solutioncode.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.majani.solutioncode.model.SubTask;
import com.majani.solutioncode.model.Task;

public class TaskService {
	
	Logger logger = Logger.getLogger(TaskService.class.getName());
	ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * Generate output file
	 * 
	 * @param input
	 * @param output
	 */
	public void generateFile(String input, String output) {
		if (new File(input).length() != 0) {
			List<SubTask> tasks = retrieveAllTasks(new File(input));
			List<Task> tasksList = prepareJsonData(tasks);
			writeFile(new File(output), tasksList);
		} else
			logger.log(Level.WARNING, "File is empty or missing!!!");
	}

	/**
	 * Adding subtask to Parent subtasks list
	 * 
	 * @param tasks
	 * @param parent
	 */
	public void getSubTasks(SubTask[] tasks, SubTask parent) {
		for (SubTask subTask : tasks) {
			if (subTask.getParentID() != null && 
					subTask.getParentID() == parent.getID()) {
				parent.addSubTaskItems(subTask);
				getSubTasks(tasks, subTask);
			}
		}
	}

	/**
	 * Generate Json string for output file
	 * 
	 * @param parentTaskList
	 * @return
	 */
	public List<Task> prepareJsonData(List<SubTask> parentTaskList) {
		
		List<Task> toDoTaskList = new ArrayList<Task>();
		
		for (SubTask task : parentTaskList) {
			Task toDoTask = new Task();
			toDoTask.setTask(task);
			toDoTask.setSubTasks(task.getSubtasks());
			task.setSubtasks(null);
			toDoTaskList.add(toDoTask);
		}

		return toDoTaskList;
	}

	/**
	 * Reads json file and convert to tasks object.
	 * 
	 * @param file
	 * @return tasks object
	 */
	public SubTask[] readFile(File file) {		
		SubTask[] tasks = null;		
		try {
			tasks = objectMapper.readValue(file, SubTask[].class);
		} catch (IOException e) {
			logger.log(Level.WARNING, "Exception occured while reading "
					+ "the input file. Put proper data in Input File.");	
		}
		return tasks;
	}

	/**
	 * Retrieve all tasks list
	 * 
	 * @param file
	 * @return
	 */
	public List<SubTask> retrieveAllTasks(File file) {
		
		List<SubTask> parentTaskList = new ArrayList<SubTask>();
		// Read the input json file to task object
		SubTask[] task = readFile(file);
		if (task != null) {
			for (int i = 0; i < task.length; i++) {
				if (task[i].getParentID() == null) {
					// Generate Subtasks list for parentTask
					getSubTasks(task, task[i]);
					parentTaskList.add(task[i]);

				}
			}
		}
		Collections.sort(parentTaskList);
		return parentTaskList;
	}

	/**
	 * Write json file from the task object
	 * 
	 * @param file
	 * @param tasks
	 * @return output file
	 */

	public File writeFile(File file, List<Task> tasks) {
		if(!tasks.isEmpty()) {
			try {
				ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
				writer.writeValue(file, tasks);

			} catch (IOException e) {
				logger.log(Level.WARNING, "Error occured while writing the output file" + e);
				
			}
		}
		return file;
	}

}
