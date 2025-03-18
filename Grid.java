interface Grid {
    public boolean isEmpty(char row, char column);
    public boolean isDraw();
 }
 
 class GameGrid implements Grid {
     private char[][] grid;
 
     public GameGrid() {
         grid = new char[3][3]; // Automatically initializes with '\0' (null character)
     }
 
     @Override
     public boolean isEmpty(char row, char col) {
         int r = row - 'A';  // Convert row from 'A', 'B', 'C' to 0, 1, 2
         int c = col - '0';  // Convert col from '0', '1', '2' to 0, 1, 2
         return grid[r][c] == '\0';
     }
 
     public void setMove(char row, char col, char symbol) {
         int r = row - 'A';  // Convert row to 0, 1, 2
         int c = col - '0';  // Convert column to 0, 1, 2
         grid[r][c] = symbol;
     }
 
     @Override
     public boolean isDraw() {
         for (char[] row : grid) {
             for (char cell : row) {
                 if (cell == '\0') {
                     return false;
                 }
             }
         }
         return true;
     }
 
     public void printGrid() {
         System.out.println("Current Grid:");
         for (char[] row : grid) {
             for (char cell : row) {
                 System.out.print((cell == '\0' ? '-' : cell) + " ");
             }
             System.out.println();
         }
         System.out.println();
     }
 
     public boolean checkWin() {
         return checkRows() || checkColumns() || checkDiagonals();
     }
 
     private boolean checkRows() {
         for (char[] row : grid) {
             if (row[0] != '\0' && row[0] == row[1] && row[1] == row[2]) {
                 return true;
             }
         }
         return false;
     }
 
     private boolean checkColumns() {
         for (int col = 0; col < 3; col++) {
             if (grid[0][col] != '\0' && grid[0][col] == grid[1][col] && grid[1][col] == grid[2][col]) {
                 return true;
             }
         }
         return false;
     }
 
     private boolean checkDiagonals() {
         return (grid[0][0] != '\0' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) ||
                (grid[0][2] != '\0' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]);
     }
 }
 