public class ComputerPlayer extends Player{
  int symbol;
  Game thisGame;

  public ComputerPlayer(int symbol, Game game) {
    super(symbol, game);
    this.symbol = symbol;
    this.thisGame = game;
  }

  @Override
  public int[] getMove() {
    return getBestMove(thisGame.board.getBoard());
    /*
    int[] move = new int[2];
    int[][] board = thisGame.board.getBoard();
    int[] bestMove = {0, 0};
    int bestScore = -1000;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == 0) {
          board[i][j] = 2;
          int score = minimax_old(board, 9, false);
          board[i][j] = 0;
          if (score > bestScore) {
            bestScore = score;
            bestMove[0] = i;
            bestMove[1] = j;
          }
        }
      }
    }
    return bestMove;
    */
  }

  private int[] getBestMove(int[][] board) {
    int[] bestMove = {0, 0};
    int bestScore = -1000;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        // Is the spot available?
        if (board[i][j] == 0) {
          board[i][j] = 2;
          int score = minimax(board, 9, false);
          board[i][j] = 0;
          if (score > bestScore) {
            bestScore = score;
            bestMove[0] = i;
            bestMove[1] = j;
          }
        }
      }
    }
    return bestMove;
  }

  private int minimax(int[][] board, int depth, boolean isMaximizing) {
    int result = thisGame.board.checkForWin();
    if (result == 0) {
      return 0;
    } else if (result == symbol) {
      return 10;
    } else if (result != symbol) {
      return -10;
    }

    if (isMaximizing) {
      int bestScore = -1000;
      for (int[] row : board) {
        for (int cell : row) {
          if (cell == 0) {
            cell = 2;
            int score = minimax(board, depth - 1, false);
            cell = 0;
            if (score > bestScore) {
              bestScore = score;
            }
          }
        }
      }
      return bestScore;
    } else {
      int bestScore = 1000;
      for (int[] row : board) {
        for (int cell : row) {
          if (cell == 0) {
            cell = 1;
            int score = minimax(board, depth - 1, true);
            cell = 0;
            if (score < bestScore) {
              bestScore = score;
            }
          }
        }
      }
      return bestScore;
    }
  }

  public int minimax_old(int[][] board, int depth, boolean isMaximizing) {
    int result = thisGame.board.checkForWin();
    if (result == 0) {
      return 0;
    } else if (result == symbol) {
      return 10;
    } else if (result != symbol) {
      return -10;
    }

    if (isMaximizing) {
      int bestScore = -1000;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          if (board[i][j] == 0) {
            board[i][j] = 2;
            int score = minimax_old(board, depth - 1, false);
            board[i][j] = 0;
            if (score > bestScore) {
              bestScore = score;
            }
          }
        }
      }
      return bestScore;
    } else {
      int bestScore = 1000;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          if (board[i][j] == 0) {
            board[i][j] = 1;
            int score = minimax_old(board, depth - 1, true);
            board[i][j] = 0;
            if (score < bestScore) {
              bestScore = score;
            }
          }
        }
      }
      return bestScore;
    }
  }
}
