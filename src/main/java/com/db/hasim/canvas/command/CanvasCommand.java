package com.db.hasim.canvas.command;

import static com.db.hasim.canvas.CommonConstants.CHAR_SPACE;
import static com.db.hasim.canvas.CommonConstants.DASH;
import static com.db.hasim.canvas.CommonConstants.NEW_LINE;
import static com.db.hasim.canvas.CommonConstants.PIPE;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Abstract Class to handle command in canvas drawing.
 * 
 * @author hasim
 *
 */

public abstract class CanvasCommand {
	static final Logger logger = Logger.getLogger(CanvasCommand.class);
	
	public abstract char[][] executeCommand(char[][] grid);

	/**
	 * method to execute command and draw grid
	 * @param grid
	 * @return char[][]
	 */
	public char[][] executeCommandAndDrawGrid(char[][] grid) {
		logger.debug("Started --> Grid : " + Arrays.deepToString(grid));
		
		grid = executeCommand(grid);

		draw(grid);
		logger.debug("Finished");
		return grid;
	}

	/**
	 * method to draw grid
	 * @param grid
	 */
	public void draw(char[][] grid) {
		logger.debug("Started -->");
		if (grid == null)
			return;
		int height = grid.length;
		int width = grid[0].length;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(NEW_LINE);

		drawCanvasVerticalBorder(width,sb);

		for (int rowNum = 0; rowNum < height; rowNum++) {
			drawCanvasRow(rowNum, width, grid,sb);
		}

		drawCanvasVerticalBorder(width,sb);
		
		logger.info(sb.toString());
		
		logger.debug("<--Finished");
		
	}

	private void drawCanvasVerticalBorder(int width, StringBuilder sb) {
		logger.debug("Started -->");

		//System.out.print(DASH);
		sb.append(DASH);

		for (int ii = 0; ii < width; ii++) {
			//System.out.print(DASH);
			sb.append(DASH);
		}

		//System.out.println(DASH);
		
		sb.append(DASH);
		sb.append(NEW_LINE);
		
		logger.debug("<--Finished");

	}

	private void drawCanvasRow(int rowNum, int width, char[][] grid, StringBuilder sb) {
		logger.debug("Started -->");
		//System.out.print(PIPE);

		sb.append(PIPE);
		
		for (int ii = 0; ii < width; ii++) {
			char printChar = grid[rowNum][ii];

			if (printChar == 0)
				printChar = CHAR_SPACE;

			//System.out.print(printChar);
			sb.append(printChar);
		}

		//System.out.print(PIPE+NEW_LINE);
		sb.append(PIPE+NEW_LINE);
		logger.debug("<--Finished");
	}

}
