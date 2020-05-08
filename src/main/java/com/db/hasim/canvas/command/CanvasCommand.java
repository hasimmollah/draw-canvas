package com.db.hasim.canvas.command;

import static com.db.hasim.canvas.CommonConstants.CHAR_SPACE;
import static com.db.hasim.canvas.CommonConstants.DASH;
import static com.db.hasim.canvas.CommonConstants.NEW_LINE;
import static com.db.hasim.canvas.CommonConstants.PIPE;

/**
 * Abstract Class to handle command in canvas drawing.
 * 
 * @author hasim
 *
 */

public abstract class CanvasCommand {
	
	public abstract char[][] executeCommand(char[][] grid);

	/**
	 * method to execute command and draw grid
	 * @param grid
	 * @return char[][]
	 */
	public char[][] executeCommandAndDrawGrid(char[][] grid) {
		
		grid = executeCommand(grid);

		draw(grid);
		return grid;
	}

	/**
	 * method to draw grid
	 * @param grid
	 */
	public void draw(char[][] grid) {
		if (grid == null)
			return;
		int height = grid.length;
		int width = grid[0].length;

		drawCanvasVerticalBorder(width);

		for (int rowNum = 0; rowNum < height; rowNum++) {
			drawCanvasRow(rowNum, width, grid);
		}

		drawCanvasVerticalBorder(width);
	}

	private void drawCanvasVerticalBorder(int width) {

		System.out.print(DASH);

		for (int ii = 0; ii < width; ii++) {
			System.out.print(DASH);
		}

		System.out.println(DASH);

	}

	private void drawCanvasRow(int rowNum, int width, char[][] grid) {
		System.out.print(PIPE);

		for (int ii = 0; ii < width; ii++) {
			char printChar = grid[rowNum][ii];

			if (printChar == 0)
				printChar = CHAR_SPACE;

			System.out.print(printChar);
		}

		System.out.print(PIPE+NEW_LINE);
	}

}
