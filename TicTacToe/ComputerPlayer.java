import java.util.ArrayList;

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
    ArrayList<int[]> bestMoves = new ArrayList<int[]>();
    int bestScore = Integer.MIN_VALUE;
    int[][] board = thisGame.board.getBoard();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == 0) {
          board[i][j] = symbol;
          int score = minimax(board, false, 0);
          board[i][j] = 0;
          if (score > bestScore) {
            bestScore = score;
            bestMoves.clear();
            bestMoves.add(new int[] { i, j });
          } else if (score == bestScore) {
            bestMoves.add(new int[] { i, j });
          }
        }
      }
    }
    return bestMoves.get((int) (Math.random() * bestMoves.size()));
  }

  private int minimax(int[][] board, boolean selfTurn, int currentDepth) {
    int result = thisGame.board.checkForWin();
    if (result == -1) {
      return -10;
    } else if (result == symbol) {
      return 1000;
    } else if (result == (symbol == 1 ? 2 : 1)) {
      return  -1000;
    }

    if (selfTurn) {
      int bestScore = Integer.MIN_VALUE;
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board.length; j++) {
          if (board[i][j] == 0) {
            board[i][j] = symbol;
            int score = minimax(board, !selfTurn, currentDepth + 1);
            board[i][j] = 0;
            bestScore = Math.max(score, bestScore);
          }
        }
      }
      return bestScore;
    } else {
      int bestScore = Integer.MAX_VALUE;
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board.length; j++) {
          if (board[i][j] == 0) {
            board[i][j] = symbol == 1 ? 2 : 1;
            int score = minimax(board, !selfTurn, currentDepth + 1);
            board[i][j] = 0;
            bestScore = Math.min(score, bestScore);
          }
        }
      }
      return bestScore;
    }
  }
}
