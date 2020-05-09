package com.db.hasim.canvas;

import static com.db.hasim.canvas.CommonConstants.CHAR_X;

import java.util.Arrays;

import org.apache.log4j.Logger;
/**
 * Util class to help drawing canvas
 * @author Hasim
 *
 */
public class CommonUtil {
	static final Logger logger = Logger.getLogger(CommonUtil.class);

	/**
	 * Method to update grid position to draw line
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param grid
	 * @return char[][]
	 */
	public static char[][] drawLine(int x1, int y1, int x2, int y2, char[][] grid) {
		logger.debug("Started -->  x1 : " + x1 + " y1 :"+y1+" x2:"+x2+" y2:"+y2+" grid:"+Arrays.deepToString(grid));
		// Horizontal line
		if (y1 == y2) {
			for (int ii = Math.min(x1, x2); ii <= Math.max(x1, x2); ii++) {
				grid[y1 - 1][ii - 1] = CHAR_X;
			}
		}

		// Vertical line
		if (x1 == x2) {
			for (int ii = Math.min(y1, y2); ii <= Math.max(y1, y2); ii++) {
				grid[ii - 1][x1 - 1] = CHAR_X;
			}
		}
		logger.debug("<-- Finished");
		return grid;
	}

	/**
	 * Method to validate inputs are valid to draw in canvas
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param width
	 * @param height
	 * @return boolean
	 */
	public static boolean coordinatesFitInCanvas(int x1, int y1, int x2, int y2, int width, int height) {
		logger.debug("Started -->  x1 : " + x1 + " y1 :"+y1+" x2:"+x2+" y2:"+y2 +" width:"+width + " height:"+height);
		if (x1 > width)
			return false;

		if (x2 > width)
			return false;

		if (y1 > height)
			return false;

		if (y2 > height)
			return false;
		logger.debug("<-- Finished");
		return true;
	}

}
