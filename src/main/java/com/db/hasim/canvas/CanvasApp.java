package com.db.hasim.canvas;

import java.util.Scanner;

import com.db.hasim.canvas.command.CanvasCommandManager;

/**
 * Main class to run the application for drawing canvas
 * 
 * @author Hasim
 *
 */
public class CanvasApp {

	public static void main(String[] args) {
		System.out.println("Please enter the command");

		Scanner in = new Scanner(System.in);
		CanvasCommandManager canvasCommandManager = new CanvasCommandManager();

		while (true) {

			String cmdStr = in.nextLine().trim();
			try {
				canvasCommandManager.executeCommand(cmdStr);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				continue;
			}

		}
	}

}
