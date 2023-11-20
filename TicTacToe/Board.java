public class Board {
  // false is X, true is O
  Boolean[][] board = new Boolean[3][3];

  void printBoard() {
    System.out.println(" --------- ");
    for (Boolean[] row : board) {
      System.out.print("|");
      for (Boolean cell : row) {
        if (cell == null) {
          System.out.print(" • ");
          continue;
        }
        System.out.print(cell ? " O " : " X ");
      }
      System.out.println("|");
    }
    System.out.println(" --------- ");
  }

  void updateBoard(int[] location, String symbol) {
    board[location[0]][location[1]] = symbol.equals("X") ? false : true;
  }

  boolean checkForWin() {
    // check horizontal
    int xCount = 0;
    int oCount = 0;
    for (Boolean[] row : board) {
      xCount = 0;
      oCount = 0;
      for (Boolean cell : row) {
        if (cell == null) {
          break;
        }
        if (cell) {
          oCount++;
        } else {
          xCount++;
        }
      }
      if (xCount == 3 || oCount == 3) {
        return true;
      }
    }

    // check vertical
    for (int i = 0; i < 3; i++) {
      xCount = 0;
      oCount = 0;
      for (int j = 0; j < 3; j++) {
        if (board[j][i] == null) {
          break;
        }
        if (board[j][i]) {
          oCount++;
        } else {
          xCount++;
        }
      }
      if (xCount == 3 || oCount == 3) {
        return true;
      }
    }

    // check diagonal
    xCount = 0;
    oCount = 0;
    for (int i = 0; i < 3; i++) {
      if (board[i][i] == null) {
        break;
      }
      if (board[i][i]) {
        oCount++;
      } else {
        xCount++;
      }
    }
    if (xCount == 3 || oCount == 3) {
      return true;
    }

    xCount = 0;
    oCount = 0;
    for (int i = 0; i < 3; i++) {
      if (board[i][2 - i] == null) {
        break;
      }
      if (board[i][2 - i]) {
        oCount++;
      } else {
        xCount++;
      }
    }
    if (xCount == 3 || oCount == 3) {
      return true;
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

  Boolean getCell(int[] location) {
    return board[location[0]][location[1]];
  }
}