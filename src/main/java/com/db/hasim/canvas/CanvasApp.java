package com.db.hasim.canvas;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.db.hasim.canvas.command.CanvasCommandManager;

/**
 * Main class to run the application for drawing canvas
 * 
 * @author Hasim
 *
 */
public class CanvasApp {
	static final Logger logger = Logger.getLogger(CanvasApp.class);
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CanvasCommandManager canvasCommandManager = new CanvasCommandManager();

		while (true) {
			logger.info("Please enter the command");
			String cmdStr = in.nextLine().trim();
			try {
				canvasCommandManager.executeCommand(cmdStr);
			} catch (Exception e) {
				logger.error("Exception occurred due to following, please provide your next command to continue",e);
				continue;
			}

		}
	}

}
