package com.db.hasim.canvas.command;

/**
 * Class to handle create command functionality
 * @author Hasim
 *
 */
public  class CanvasCreateCommand extends CanvasCommand{
	private int width;
	private int height;
	
	public CanvasCreateCommand(int width , int height){
		this. width = width;
		this.height=height;
	}

	@Override
	public char[][] executeCommand(char[][] grid) {
		grid = new char[height][width];
		return grid;
	}
	

}
