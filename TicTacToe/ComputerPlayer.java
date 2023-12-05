import java.util.ArrayList;

public class ComputerPlayer extends Player {
  private int symbol;
  public Game thisGame;
  private final boolean multiThreaded = TicTacToe.multiThreaded;
  private final boolean showEngine = TicTacToe.ShowEngine;

  public ComputerPlayer(int symbol, Game game) {
    super(symbol, game);
    this.symbol = symbol;
    this.thisGame = game;
  }

  @Override
  public int[] getMove() {
    return getBestMove();
  }

  private int[] getBestMove() {
    ArrayList<int[]> bestMoves = new ArrayList<int[]>();
    int bestScore = Integer.MIN_VALUE;
    int[][] board = thisGame.board.getBoard();
    if (!multiThreaded) {
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (board[i][j] == 0) {
            board[i][j] = symbol;
            int score = minimax(board, false);
            if (showEngine) {
              System.out.println((symbol == 1 ? "\'X\' " : "\'O\' ") + i + ":" + j + " " + score);
            }
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
    } else {
      ThreadManager manager = new ThreadManager();
      manager.setMaxThreads(100); // TODO
      ArrayList<Thread> threads = new ArrayList<>();
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (board[i][j] == 0) {
            board[i][j] = symbol;
            ComputeThread thread = new ComputeThread(board, false, i, j);
            thread.setName("Thread " + (i + 1) + ":" + (j + 1));
            threads.add(thread);
            board[i][j] = 0;
          }
        }
      }

      manager.addThreads(threads);
      manager.startAll();
      manager.joinAll();

      for (Thread thread : manager.getThreads()) {
        ComputeThread cThread = (ComputeThread) thread;
        int score = cThread.FinalResult;
        if (showEngine) {
          System.out.println((symbol == 1 ? "\'X\' " : "\'O\' ") + cThread.i + ":" + cThread.j + " " + score);
        }
        if (score > bestScore) {
          bestScore = score;
          bestMoves.clear();
          bestMoves.add(new int[] { cThread.i, cThread.j });
        } else if (score == bestScore) {
          bestMoves.add(new int[] { cThread.i, cThread.j });
        }
      }
    }
    return bestMoves.get((int) (Math.random() * bestMoves.size()));
  }

  private int minimax(int[][] board, boolean selfTurn) {
    int result = thisGame.board.checkForWin();
    if (result == -1) {
      return 0; // Tie
    } else if (result == symbol) {
      return 1; // Win
    } else if (result == (symbol == 1 ? 2 : 1)) {
      return -1; // Loss
    }

    if (selfTurn) {
      int bestScore = Integer.MIN_VALUE;
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board.length; j++) {
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
        for (int j = 0; j < board.length; j++) {
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

  private class ComputeThread extends Thread {
    private int[][] board;
    private boolean selfTurn;
    public int FinalResult = 0;
    private int i, j;

    public ComputeThread(final int[][] board, final boolean selfTurn, final int i, final int j) {
      this.board = board.clone();
      this.selfTurn = selfTurn;
      this.i = i;
      this.j = j;
    }

    @Override
    public void run() {
      FinalResult = minimax(board, selfTurn);
      // if (showEngine) {
      //   System.out.println((symbol == 1 ? "X" : "O") + ": " + getName() + " = " + FinalResult);
      // }
      Thread.currentThread().interrupt();
    }
  }
}
