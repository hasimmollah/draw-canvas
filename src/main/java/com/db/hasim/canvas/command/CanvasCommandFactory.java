package com.db.hasim.canvas.command;

import static com.db.hasim.canvas.CommonConstants.CREATE_CMD_REG_EXP_STR;
import static com.db.hasim.canvas.CommonConstants.CREATE_COMMAND_START_CHAR;
import static com.db.hasim.canvas.CommonConstants.DRAW_LINE_COMMAND_START_CHAR;
import static com.db.hasim.canvas.CommonConstants.DRAW_RECT_COMMAND_START_CHAR;
import static com.db.hasim.canvas.CommonConstants.LINE_CMD_REG_EXP_STR;
import static com.db.hasim.canvas.CommonConstants.MAX_CANVAS_DIMENSION;
import static com.db.hasim.canvas.CommonConstants.QUIT_COMMAND_START_CHAR;
import static com.db.hasim.canvas.CommonConstants.RECT_CMD_REG_EXP_STR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Factory class to get instance of various canvas command as per input
 * 
 * @author Hasim
 *
 */
public class CanvasCommandFactory {

	/**
	 * Method to get canvas command instance
	 * 
	 * @param cmdStr
	 * @return CanvasCommand
	 */
	public static CanvasCommand getCanvasCommandInstance(String cmdStr) {
		CanvasCommand canvasCommand = null;
		if (cmdStr.startsWith(CREATE_COMMAND_START_CHAR)) {
			canvasCommand = getCreateCommand(cmdStr);
		} else if (cmdStr.startsWith(DRAW_LINE_COMMAND_START_CHAR)) {
			canvasCommand = getDrawLineCommand(cmdStr);
		} else if (cmdStr.startsWith(DRAW_RECT_COMMAND_START_CHAR)) {
			canvasCommand = getRectangleCommand(cmdStr);
		} else if (cmdStr.startsWith(QUIT_COMMAND_START_CHAR)) {
			canvasCommand = new CanvasQuitCommand();
		} else {
			throw new RuntimeException("Invalid command");
		}

		return canvasCommand;

	}

	/**
	 * Method to generate CanvasDrawRectangleCommand
	 * 
	 * @param cmdStr
	 * @return CanvasDrawRectangleCommand
	 */
	private static CanvasDrawRectangleCommand getRectangleCommand(String cmdStr) {
		CanvasDrawRectangleCommand canvasDrawRectangleCommand = null;
		Pattern p = Pattern.compile(RECT_CMD_REG_EXP_STR);
		Matcher m = p.matcher(cmdStr);
		if (m.matches()) {
			int x1 = Integer.parseInt(m.group(1));
			int y1 = Integer.parseInt(m.group(2));
			int x2 = Integer.parseInt(m.group(3));
			int y2 = Integer.parseInt(m.group(4));

			if (x1 <= 0 || x2 <= 0 || y1 <= 0 || y2 <= 0) {
				throw new RuntimeException("All rectangle coordinates must be positive > 0 ");
			}

			canvasDrawRectangleCommand = new CanvasDrawRectangleCommand(x1, y1, x2, y2);

		} else {
			throw new RuntimeException(
					"Invalid command: please provide command in specified format e.g.  R x1 y1 x2 y2");
		}

		return canvasDrawRectangleCommand;
	}

	/**
	 * Method to generate CanvasDrawLineCommand
	 * 
	 * @param cmdStr
	 * @return CanvasDrawLineCommand
	 */
	private static CanvasDrawLineCommand getDrawLineCommand(String cmdStr) {
		CanvasDrawLineCommand canvasDrawLineCommand = null;
		Pattern p = Pattern.compile(LINE_CMD_REG_EXP_STR);
		Matcher m = p.matcher(cmdStr);
		if (m.matches()) {
			int x1 = Integer.parseInt(m.group(1));
			int y1 = Integer.parseInt(m.group(2));
			int x2 = Integer.parseInt(m.group(3));
			int y2 = Integer.parseInt(m.group(4));

			if (x1 <= 0 || x2 <= 0 || y1 <= 0 || y2 <= 0) {
				throw new RuntimeException("All rectangle coordinates must be positive > 0 ");
			} else if (x1 == x2 || y1 == y2) {
				canvasDrawLineCommand = new CanvasDrawLineCommand(x1, y1, x2, y2);
			} else {
				throw new RuntimeException("Line must be either vertical (x1=x2) or horizontal (y1=y2)");
			}
		} else {
			throw new RuntimeException(
					"Invalid command: please provide command in specified format e.g.  L x1 y1 x2 y2");
		}

		return canvasDrawLineCommand;

	}

	/**
	 * Method to generate CanvasCreateCommand
	 * 
	 * @param cmdStr
	 * @return CanvasCreateCommand
	 */

	private static CanvasCreateCommand getCreateCommand(String cmdStr) {
		CanvasCreateCommand canvasCreateCommand = null;
		Pattern p = Pattern.compile(CREATE_CMD_REG_EXP_STR);
		Matcher m = p.matcher(cmdStr);

		if (m.matches()) {

			int w = Integer.parseInt(m.group(1));
			int h = Integer.parseInt(m.group(2));

			if (w <= 0 || h <= 0) {
				throw new RuntimeException("Both canvas dimensions must be positive");
			}

			if (w > MAX_CANVAS_DIMENSION || h > MAX_CANVAS_DIMENSION) {
				throw new RuntimeException("Each canvas dimension can be no more than " + MAX_CANVAS_DIMENSION);
			}

			canvasCreateCommand = new CanvasCreateCommand(w, h);

		} else {
			throw new RuntimeException("Invalid command: please provide command in specified format e.g.  C x1 y1");
		}

		return canvasCreateCommand;

	}

}
