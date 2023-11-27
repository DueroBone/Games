public class ComputerPlayer extends Player {
  private int symbol;
  private Game thisGame;

  public ComputerPlayer(int symbol, Game game) {
    super(symbol, game);
    this.symbol = symbol;
    this.thisGame = game;
  }

  @Override
  public int[] getMove() {
    return getBestMove(thisGame.board.getBoard());
  }

  private int[] getBestMove(int[][] board) {
    int[] bestMove = { 4, 4 };
    int bestScore = Integer.MIN_VALUE;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == 0) {
          board[i][j] = symbol;
          int score = minimax(board, false);
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

  private int minimax(int[][] board, boolean selfTurn) {
    int result = thisGame.board.checkForWin();
    if (result == -1) {
      return 0;
    } else if (result == symbol) {
      return 1000;
    } else if (result == (symbol == 1 ? 2 : 1)) {
      return -1000;
    }

    if (selfTurn) {
      int bestScore = Integer.MIN_VALUE;
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (board[i][j] == 0) {
            board[i][j] = symbol;
            int score = minimax(board, !selfTurn);
            board[i][j] = 0;
            bestScore = Math.max(score, bestScore);
          }
        }
      }
      return bestScore;
    } else {
      int bestScore = Integer.MAX_VALUE;
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (board[i][j] == 0) {
            board[i][j] = symbol == 1 ? 2 : 1;
            int score = minimax(board, !selfTurn);
            board[i][j] = 0;
            bestScore = Math.min(score, bestScore);
          }
        }
      }
      return bestScore;
    }
  }
}
