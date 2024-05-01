# Tetris 2.0

Tetris 2.0, runs the vintage game tetris, on java. This project effectively encapsulates the most important parts of the original tetris game. However, it is worth noting that there are still minor bugs with the rotation method and the moving left of I-Block pieces. Besides that the game functions in every possible way identical to the original tetris game. There is no test folder for this project as much of our testing is simply visually viewing bugs and debugging errors that arise while running the program. The main method is included in the MainGame class. You should not need to do anything beyond running the main method when wanting to play our tetris game. 

The MainGame is resposnible for the craetion of the canvas window, spawning of blocks, animation loop, key handling, score/level counter and ending message.

The MatrixBlock class represents the block objects that fill the indicies of our arrays and are displayed on the canvas.

The MatrixManager class creates the game board with a 2D array and associated methods, like coloring the blocks and checking for completed rows.

The Shape class contains information about each block and its four orientations using a queue. Relelvant methods include gravity, move left / right, rotate, and can move.
