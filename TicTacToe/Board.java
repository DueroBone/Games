package TicTacToe;

public class Board {
  private int[][] board = new int[3][3];
  private final int neededToWin = 3;
  private final boolean Verbose = !TicTacToe.SilentMode;

  void printBoard() {
    if (Verbose) {
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
        if (cell == 1) {
          xCount++;
        } else {
          oCount++;
        }
      }
      if (xCount == neededToWin) {
        return 1;
      } else if (oCount == neededToWin) {
        return 2;
      }
    }

    // check vertical
    for (int i = 0; i < board.length; i++) {
      xCount = 0;
      oCount = 0;
      for (int j = 0; j < board[i].length; j++) {
        if (board[j][i] == 0) {
          break;
        }
        if (board[j][i] == 1) {
          xCount++;
        } else {
          oCount++;
        }
      }
      if (xCount == neededToWin) {
        return 1;
      } else if (oCount == neededToWin) {
        return 2;
      }
    }

    // check diagonal left to right
    xCount = 0;
    oCount = 0;
    for (int i = 0; i < board.length; i++) {
      if (board[i][i] == 0) {
        break;
      }
      if (board[i][i] == 1) {
        xCount++;
      } else {
        oCount++;
      }
    }
    if (xCount == neededToWin) {
      return 1;
    } else if (oCount == neededToWin) {
      return 2;
    }

    // check diagonal right to left
    xCount = 0;
    oCount = 0;
    for (int i = 0; i < board.length; i++) {
      if (board[i][board.length - 1 - i] == 0) {
        break;
      }
      if (board[i][board.length - 1 - i] == 1) {
        xCount++;
      } else {
        oCount++;
      }
    }
    if (xCount == neededToWin) {
      return 1;
    } else if (oCount == neededToWin) {
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