package com.db.hasim.canvas.command;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.powermock.reflect.Whitebox;

public class CanvasCommandManagerTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	CanvasCommandManager canvasCommandManager = new CanvasCommandManager();
	
	@Test
	public void whenValidCreateCommandProvidedThenGridIsCreated() {
		String cmdStr = "C 1 20";
		canvasCommandManager.executeCommand(cmdStr);
		char[][] grid = Whitebox.getInternalState(canvasCommandManager, "grid");
		assertEquals(grid.length, grid.length);
	}
	
	@Test
	public void whenValidCreateCommandWithInvalidHeightProvidedThenGridIsCreated() {
		String cmdStr = "C 1 -1";
		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage("Both canvas dimensions must be positive");
		
		canvasCommandManager.executeCommand(cmdStr);
		
	}
	
	@Test
	public void whenValidCreateCommandWithInvalidWidthGreaterThan100ProvidedThenGridIsCreated() {
		String cmdStr = "C 1 200";
		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage("Each canvas dimension can be no more than 100");
		
		canvasCommandManager.executeCommand(cmdStr);
		
	}
	
	@Test
	public void whenInValidCreateCommandProvidedThenExcepionThrown() {
		String cmdStr = "C 1";
		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage("Invalid command: please provide command in specified format e.g.  C x1 y1");
		canvasCommandManager.executeCommand(cmdStr);
		
	}
	
	@Test
	public void whenInValidDrawLineCommandProvidedThenExcepionThrown() {
		char[][] grid = new char[10][20];
		
		Whitebox.setInternalState(canvasCommandManager, "grid",grid);


		String cmdStr = "L 1";
		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage("Invalid command: please provide command in specified format e.g.  L x1 y1 x2 y2");
		canvasCommandManager.executeCommand(cmdStr);
		
	}
	@Test
	public void whenInValidDrawLineCommandWithNegativeValueProvidedThenExcepionThrown() {
		char[][] grid = new char[10][20];
		
		Whitebox.setInternalState(canvasCommandManager, "grid",grid);


		String cmdStr = "L 1 3 1 -8";
		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage("All rectangle coordinates must be positive > 0");
		canvasCommandManager.executeCommand(cmdStr);
		
	}
	
	 
	@Test
	public void whenInValidDrawLineCommandWithDiagonalValueProvidedThenExcepionThrown() {
		char[][] grid = new char[10][20];
		
		Whitebox.setInternalState(canvasCommandManager, "grid",grid);


		String cmdStr = "L 1 3 4 6";
		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage("Line must be either vertical (x1=x2) or horizontal (y1=y2)");
		canvasCommandManager.executeCommand(cmdStr);
		
	}
	
	@Test
	public void whenInValidDrawRectangleCommandProvidedThenExcepionThrown() {
		char[][] grid = new char[10][20];
		
		Whitebox.setInternalState(canvasCommandManager, "grid",grid);


		String cmdStr = "R 1";
		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage("Invalid command: please provide command in specified format e.g.  R x1 y1 x2 y2");
		canvasCommandManager.executeCommand(cmdStr);
		
	}
	
	@Test
	public void whenInValidDrawRectangleCommandWithNegativeValueProvidedThenExcepionThrown() {
		char[][] grid = new char[10][20];
		
		Whitebox.setInternalState(canvasCommandManager, "grid",grid);


		String cmdStr = "R 1 2 3 -4";
		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage("All rectangle coordinates must be positive > 0 ");
		canvasCommandManager.executeCommand(cmdStr);
		
	}
	
	@Test
	public void whenValidDrawLineCommandAndNoCreateCommandProvidedThenExeptionThrown() {
		String cmdStr = "L 1 2 1 3";
		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage("No active grid. Please create grid using the CREATE (C) command");
		canvasCommandManager.executeCommand(cmdStr);
		
	}
	
	@Test
	public void whenInvalidCommandProvidedThenExeptionThrown() {
		String cmdStr = "Z 2 3";
		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage("Invalid command");
		canvasCommandManager.executeCommand(cmdStr);
		
	}
	
	@Test
	public void whenValidDrawLineCommandAndCreateCommandProvidedThenGridIscreated() {
		
		char[][] grid = new char[10][20];
				
				Whitebox.setInternalState(canvasCommandManager, "grid",grid);
		
		
		String cmdStr = "L 1 2 1 3";
		canvasCommandManager.executeCommand(cmdStr);
		char[][] gridAcual = Whitebox.getInternalState(canvasCommandManager, "grid");
		char gridCharX = 'x';
		assertEquals(gridCharX, gridAcual[1][0]);
		assertEquals(gridCharX, gridAcual[2][0]);
	}
	
	@Test
	public void whenValidDrawRectangleCommandAndCreateCommandProvidedThenGridIscreated() {
		
		char[][] grid = new char[10][20];
				
				Whitebox.setInternalState(canvasCommandManager, "grid",grid);
		
		
		String cmdStr = "R 1 2 3 3";
		canvasCommandManager.executeCommand(cmdStr);
		char[][] gridAcual = Whitebox.getInternalState(canvasCommandManager, "grid");
		char gridCharX = 'x';
		assertEquals(gridCharX, gridAcual[1][0]);
		assertEquals(gridCharX, gridAcual[2][2]);
	}
	
	@Test
	public void whenValidDrawRectangleCommandAndNoCreateCommandProvidedThenExeptionThrown() {
		String cmdStr = "R 1 2 3 3";
		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage("No active grid. Please create grid using the CREATE (C) command");
		canvasCommandManager.executeCommand(cmdStr);
		
	}
	
}
