package com.db.hasim.canvas.command;

import java.util.Arrays;

import org.apache.log4j.Logger;

import com.db.hasim.canvas.CommonUtil;
/**
 * Class to handle draw line command functionality
 * @author Hasim
 *
 */
public class CanvasDrawLineCommand extends CanvasCommand {
	static final Logger logger = Logger.getLogger(CanvasDrawLineCommand.class);
	private int x1;
	private int x2;
	private int y1;
	private int y2;

	public CanvasDrawLineCommand(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public char[][] executeCommand(char[][] grid) {
		logger.debug("Started --> Grid " + Arrays.deepToString(grid));

		if (grid == null) {
			throw new RuntimeException("No active grid. Please create grid using the CREATE (C) command");
		}
		int width = grid[0].length;
		int height = grid.length;

		if (!CommonUtil.coordinatesFitInCanvas(x1, y1, x2, y2, width, height)) {
			throw new RuntimeException("Line coordinates do not fit into the canvas");
		}

		char[][] gridToReturn  = CommonUtil.drawLine(x1, y1, x2, y2, grid);
		logger.debug("<-- Finished");
		return gridToReturn;
	}

}
