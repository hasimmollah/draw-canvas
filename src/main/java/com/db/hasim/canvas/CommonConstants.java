package com.db.hasim.canvas;

public class CommonConstants {

	public static final String DASH = "-";
	public static final String PIPE = "|";
	public static final String NEW_LINE = "\n";
	public static final char CHAR_SPACE = ' ';
	public static final char CHAR_X = 'x';
	public static final String CREATE_COMMAND_START_CHAR = "C";
	public static final String DRAW_LINE_COMMAND_START_CHAR = "L";
	public static final String DRAW_RECT_COMMAND_START_CHAR = "R";
	public static final String QUIT_COMMAND_START_CHAR = "Q";
	public static final String CREATE_CMD_REG_EXP_STR = "C (-?[0-9]+) (-?[0-9]+)";
	public static final String LINE_CMD_REG_EXP_STR = "L (-?[0-9]+) (-?[0-9]+) (-?[0-9]+) (-?[0-9]+)";
	public static final String RECT_CMD_REG_EXP_STR = "R (-?[0-9]+) (-?[0-9]+) (-?[0-9]+) (-?[0-9]+)";
	
	public static final int MAX_CANVAS_DIMENSION = 100;

}
