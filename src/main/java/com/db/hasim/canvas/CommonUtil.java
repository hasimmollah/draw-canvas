package com.db.hasim.canvas;

import static com.db.hasim.canvas.CommonConstants.CHAR_X;
/**
 * Util class to help drawing canvas
 * @author Hasim
 *
 */
public class CommonUtil {

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

		if (x1 > width)
			return false;

		if (x2 > width)
			return false;

		if (y1 > height)
			return false;

		if (y2 > height)
			return false;

		return true;
	}

}
