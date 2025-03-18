# TICTACTOE# Tic-Tac-Toe Game in Java

## Overview
This is a simple console-based Tic-Tac-Toe game implemented in Java using Object-Oriented Programming (OOP) principles. The game supports two modes:
1. **Human vs. Human**
2. **Human vs. Computer**

Players take turns placing their symbols (`X` or `O`) on a 3x3 grid until there is a winner or the game ends in a draw.

## Features
- **OOP Design**: Uses classes such as `Game`, `Player`, `Human`, `Computer`, and `GameGrid` for better structure.
- **Row and Column Representation**: Rows are represented by `A, B, C`, and columns are represented by `0, 1, 2`.
- **Computer AI**: The computer player makes random valid moves.
- **Automatic Win & Draw Detection**: The game checks for winning conditions and announces the result accordingly.
- **Encapsulation of Logic**: The `Game` class manages the entire game flow, reducing the length of the `main()` method to just a few lines.

## How to Play
1. Run the program.
2. Select the game mode (Human vs. Human or Human vs. Computer).
3. Enter the player names.
4. Take turns entering row (`A, B, C`) and column (`0, 1, 2`) positions.
5. The game ends when a player wins or the grid is full.

## Class Descriptions
### 1. `Main`
- Starts the game by initializing an instance of the `Game` class.

### 2. `Game`
- Handles game setup and loop.
- Manages turns and checks for game-over conditions.

### 3. `Player` (Abstract Class)
- Defines common attributes (`username`, `symbol`).
- Implements the `play()` method, which is overridden in subclasses.

### 4. `Human` (Extends `Player`)
- Handles input from a human player.

### 5. `Computer` (Extends `Player`)
- Randomly selects moves.

### 6. `GameGrid` (Implements `Grid` Interface)
- Manages the game board.
- Provides methods for checking valid moves, wins, and draws.

## How to Run the Program
1. Ensure you have Java installed.
2. Compile the files:
   ```sh
   javac Main.java Game.java Player.java Human.java Computer.java GameGrid.java
   ```
3. Run the program:
   ```sh
   java Main
   ```

## Future Improvements
- Implement a smarter AI using the Minimax algorithm.
- Add a GUI for a better user experience.
- Implement a score-tracking system.

Enjoy playing Tic-Tac-Toe!

