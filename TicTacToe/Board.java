public class Board {
  private int[][] board = new int[3][3];

  void printBoard() {
    System.out.println(" --------- ");
    for (int[] row : board) {
      System.out.print("|");
      for (int cell : row) {
        if (cell == 0) {
          System.out.print(" • ");
          continue;
        }
        System.out.print(cell == 1 ? " X " : " O ");
      }
      System.out.println("|");
    }
    System.out.println(" --------- ");
  }

  void updateBoard(int[] location, int symbol) {
    board[location[0]][location[1]] = symbol;
  }

  int checkForWin() {
    // check horizontal
    int xCount = 0;
    int oCount = 0;
    for (int[] row : board) {
      xCount = 0;
      oCount = 0;
      for (int cell : row) {
        if (cell == 0) {
          break;
        }
        if (cell==1) {
          xCount++;
        } else {
          oCount++;
        }
      }
      if (xCount == 3) {
        return 1;
      } else if (oCount == 3) {
        return 2;
      }
    }

    // check vertical
    for (int i = 0; i < 3; i++) {
      xCount = 0;
      oCount = 0;
      for (int j = 0; j < 3; j++) {
        if (board[j][i] == 0) {
          break;
        }
        if (board[j][i] == 1) {
          xCount++;
        } else {
          oCount++;
        }
      }
      if (xCount == 3) {
        return 1;
      } else if (oCount == 3) {
        return 2;
      }
    }

    // check diagonal left to right
    xCount = 0;
    oCount = 0;
    for (int i = 0; i < 3; i++) {
      if (board[i][i] == 0) {
        break;
      }
      if (board[i][i] == 1) {
        xCount++;
      } else {
        oCount++;
      }
    }
    if (xCount == 3) {
      return 1;
    } else if (oCount == 3) {
      return 2;
    }

    // check diagonal right to left
    xCount = 0;
    oCount = 0;
    for (int i = 0; i < 3; i++) {
      if (board[i][2 - i] == 0) {
        break;
      }
      if (board[i][2 - i] == 1) {
        xCount++;
      } else {
        oCount++;
      }
    }
    if (xCount == 3) {
      return 1;
    } else if (oCount == 3) {
      return 2;
    }

    if (checkForDraw()) {
      return -1;
    }
    return 0;
  }

  private boolean checkForDraw() {
    for (int[] row : board) {
      for (int cell : row) {
        if (cell == 0) {
          return false;
        }
      }
    }
    return true;
  }

  int getCell(int[] location) {
    return board[location[0]][location[1]];
  }

  int[][] getBoard() {
    return board;
  }
}