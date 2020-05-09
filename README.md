# draw-canvas
The URL of the repository is the following : git@github.com:hasimmollah/draw-canvas.git

when reading the code please be aware that for the user the canvas cell addressing 
starts with 1 and is done in the (x,y) form, however, the backing data structure 
a 2D char array called grid is addressed starting 
from 0 and is done in the grid[y-1][x-1] form for a (x,y) coordinate provided by the user.



=== 1. How to RUN the project === 
1. Import it into your IDE ( such as Eclipse ) from Git
2. Run the "CanvasApp.java" class under package com.db.hasim.canvas 
3. The main method of this class will start the drawing program. 

Another way of running the application using maven
On terminal run 
mvn clean install
Java -jar target/draw-canvas-0.0.1-SNAPSHOT.jar

Application will start running.

=== 2. Logical Flow ===

The main method of the application is the main method in "CanvasApp.java" class from 
the package "com.db.hasim.canvas". 
When it starts it create instance of CanvasCommandManager and starts drawing the canvas.

First command this program expect is a canvas creation command, for e.g. C 10 20

User input is validated and parsed based on the input command it gets the CanvasCommand (an abstract class) instance from canvascommandfactory. 
Currently program support following canvas command 
CanvasCreateCommand : Responsible for creating blank canvas
CanvasDrawRectangleCommand: Responsible for creating rectangle in the canvas
CanvasDrawLineCommand: Responsible for Drawing a line in the canvas
CanvasQuitCommand: Responsible for quit the program

Upon getting the canvas command CanvasCommandManager calls executeCommandAndDrawGrid of CanvasCommand.  it updates the grid (a 2D char array) with char 'x' and then draw the grid.

                               CanvasApp
                                    |
                                    |
                                    |  <<use>>
                                    V
                              CanvasCommandManager
                                    |
                                    |
            ________________________|_______________
               |                                | <<use>> 
               |<<use>>                         |
               |                                |
               V                                V
           CanvasCommand              CanvasCommandFactory
                 ^ 
                 |
                 |<<extends>>                 
   ______________|______________________________________________________________
   |                              |                      |                     |
   |                              |                      |                     |
CanvasCreateCommand   CanvasDrawLineCommand CanvasDrawRectangleCommand   CanvasQuitCommand
                                  |                     |
                                  |                     |
                                  |_____________________|
                                              |         
                                              | <<use>> 
                                              V
                                           CommonUtil




