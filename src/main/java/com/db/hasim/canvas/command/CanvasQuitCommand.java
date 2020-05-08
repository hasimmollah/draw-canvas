package com.db.hasim.canvas.command;

/**
 * Class to handle Quit command in canvas drawing.
 * 
 * @author hasim
 *
 */

public  class CanvasQuitCommand extends CanvasCommand{

	@Override
	public char[][] executeCommand(char[][] grid) {
		System.exit(0);
		return null;
	}
	

}
