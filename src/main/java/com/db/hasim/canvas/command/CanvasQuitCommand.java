package com.db.hasim.canvas.command;

import org.apache.log4j.Logger;

/**
 * Class to handle Quit command in canvas drawing.
 * 
 * @author hasim
 *
 */

public  class CanvasQuitCommand extends CanvasCommand{
	static final Logger logger = Logger.getLogger(CanvasQuitCommand.class);

	@Override
	public char[][] executeCommand(char[][] grid) {
		logger.debug(" Executing Quit command");
		System.exit(0);
		return null;
	}
	

}
