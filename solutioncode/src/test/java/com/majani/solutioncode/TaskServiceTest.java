package com.majani.solutioncode;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.majani.solutioncode.model.SubTask;
import com.majani.solutioncode.service.TaskService;

import junit.framework.Assert;

public class TaskServiceTest {
	TaskService service = new TaskService();

	@Test
	public void testReadFile_ForEmptyFile() {
		SubTask[] subtask = service.readFile(new File(""));
		Assert.assertNull(subtask);
	}
	
	@Test
	public void testReadFile_ForNonJson() {				
		SubTask[] subtask = service.readFile(new File("/FileWithNonJSONData.json"));
		Assert.assertNull(subtask);
	}

	
	@Test
	public void testRetrieveAllTasks() {
		List<SubTask> list = service.retrieveAllTasks(new File("/InputFile.json"));
		assertEquals(3, list.size());
	}

}

