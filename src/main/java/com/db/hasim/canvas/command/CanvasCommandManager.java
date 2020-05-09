package com.db.hasim.canvas.command;

import org.apache.log4j.Logger;

/**
 * Class to handle canvas command and draw grid
 * 
 * @author Hasim
 *
 */
public class CanvasCommandManager {
	static final Logger logger = Logger.getLogger(CanvasCommandManager.class);
	private char[][] grid = null;

	/**
	 * Method to get instance of canvas command as per input and draw grid
	 * @param cmdStr
	 */
	public void executeCommand(String cmdStr) {
		logger.debug("Started -->");
		CanvasCommand canvasCommand = CanvasCommandFactory.getCanvasCommandInstance(cmdStr);
		grid = canvasCommand.executeCommandAndDrawGrid(grid);
		logger.debug("<-- Finished");

	}

}
