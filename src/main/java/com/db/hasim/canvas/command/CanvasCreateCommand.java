package com.db.hasim.canvas.command;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Class to handle create command functionality
 * @author Hasim
 *
 */
public  class CanvasCreateCommand extends CanvasCommand{
	static final Logger logger = Logger.getLogger(CanvasCreateCommand.class);
	private int width;
	private int height;
	
	public CanvasCreateCommand(int width , int height){
		this. width = width;
		this.height=height;
	}

	@Override
	public char[][] executeCommand(char[][] grid) {
		logger.debug("Started --> Grid : "+Arrays.deepToString(grid));
		grid = new char[height][width];
		logger.debug("<-- Finished");
		return grid;
	}
	

}
