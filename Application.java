package com.majani.mysolution;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.majani.mysolution.service.TaskService;

/**
 *
 * Main Class
 *
 */
public class Application {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Application.class.getName());
		TaskService service = new TaskService();
		// Takes two command line arguments as parameters
		service.generateFile(args[0], args[1]);
		logger.log(Level.INFO, "Done!");		
	}
}
