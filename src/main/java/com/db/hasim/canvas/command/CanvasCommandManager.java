package com.db.hasim.canvas.command;

/**
 * Class to handle canvas command and draw grid
 * 
 * @author Hasim
 *
 */
public class CanvasCommandManager {

	private char[][] grid = null;

	/**
	 * Method to get instance of canvas command as per input and draw grid
	 * @param cmdStr
	 */
	public void executeCommand(String cmdStr) {
		CanvasCommand canvasCommand = CanvasCommandFactory.getCanvasCommandInstance(cmdStr);
		grid = canvasCommand.executeCommandAndDrawGrid(grid);

	}

}
