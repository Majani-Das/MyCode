package com.majani.mysolution.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.majani.mysolution.model.SubTask;
import com.majani.mysolution.model.Task;

public class TaskService {

	Logger logger = Logger.getLogger(TaskService.class.getName());
	ObjectMapper objectMapper = new ObjectMapper();
	List<Task> taskList = new ArrayList<Task>();

	/**
	 * Generate output file
	 * 
	 * @param input
	 * @param output
	 */
	public void generateFile(String input, String output) {
		if (new File(input).length() != 0) {
			prepareJsonData(readFile(new File(input)));
			writeFile(new File(output), taskList);
		} else
			logger.log(Level.WARNING, "File is empty or missing!!!");
	}

	/**
	 * Generate Json string for output file
	 * 
	 * @param parentTaskList
	 * @return
	 */
	public List<Task> prepareJsonData(SubTask[] task) {

		List<Task> toDoTaskList = new ArrayList<Task>();
		if (task != null) {
			for (SubTask subtask : task) {
				Task toDoTask = new Task();
				toDoTask.setTask(subtask);
				toDoTask.setTasksList(new ArrayList<Task>());
				toDoTaskList.add(toDoTask);
			}
			Collections.sort(toDoTaskList);
			for (int i = 0; i < toDoTaskList.size(); i++) {
				if (toDoTaskList.get(i).getTask().getParentID() == null) {
					getTasks(toDoTaskList, toDoTaskList.get(i));
					taskList.add(toDoTaskList.get(i));
				}

			}
		}else
			logger.log(Level.WARNING,"File does not contain proper data.");
		Collections.sort(taskList);
		return taskList;
	}

	/**
	 * Adding child tasks to Parent task
	 * 
	 * @param toDoTaskList
	 * @param parent
	 */
	public void getTasks(List<Task> toDoTaskList, Task parent) {
		for (Task subTask : toDoTaskList) {
			if (subTask.getTask().getParentID() != null
					&& subTask.getTask().getParentID().equals(parent.getTask().getID())) {
				
				parent.addTaskItems(subTask);

				getTasks(toDoTaskList, subTask);
			}
		}
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
			logger.log(Level.WARNING,
					"Exception occured while reading " + "the input file. Put proper data in Input File.");
		}
		return tasks;
	}

	/**
	 * Write json file from the task object
	 * 
	 * @param file
	 * @param tasks
	 * @return output file
	 */

	public File writeFile(File file, List<Task> tasks) {
		if (!tasks.isEmpty()) {
			try {				
				ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
				writer.writeValue(file, tasks);

			} catch (IOException e) {
				logger.log(Level.WARNING, "Error occured while writing the output file" + e);

			}
		}
		return file;
	}

}
