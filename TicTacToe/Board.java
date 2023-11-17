public class Board {
  // false is X, true is O
  Boolean[][] board;

  void printBoard() {
    for (Boolean[] row : board) {
      for (Boolean cell : row) {
        if (cell == null) {
          System.out.print(" ");
          continue;
        }
        System.out.print(cell ? "O" : "X");
      }
      System.out.println();
    }
  }

  void updateBoard(int[] location, String symbol) {
    board[location[0]][location[1]] = symbol.equals("X") ? false : true;
  }

  boolean checkForWin() {
    // check horizontal
    int xCount = 0;
    int oCount = 0;
    for (Boolean[] row : board) {
      for (Boolean cell : row) {
        if (cell) {
          oCount++;
        } else if (cell == false) {
          xCount++;
        }
      }
      if (xCount == 3 || oCount == 3) {
        return true;
      }
    }

    // check vertical
    // i is the column, j is the row
    for (int i = 0; i < 3; i++) {
      xCount = 0;
      oCount = 0;
      for (int j = 0; j < 3; j++) {
        if (board[j][i] == null) {
          break;
        }
        if (board[j][i]) {
          oCount++;
        } else if (board[j][i] == false) {
          xCount++;
        }
      }
      if (xCount == 3 || oCount == 3) {
        return true;
      }
    }
    return false;
  }

  boolean checkForDraw() {
    for (Boolean[] row : board) {
      for (Boolean cell : row) {
        if (cell == null) {
          return false;
        }
      }
    }
    return true;
  }
}