import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {
  // =========================================================== //
  /** Print board */
  public static final boolean SilentMode = false;

  /** Print engine TAKES PRECEDENT OVER SilentMode */
  public static final boolean ShowEngine = false;

  public static final boolean multiThreaded = false; // Broken
  /** computer vs computer */
  private static final boolean autoPlay = false;

  /** computer vs computer many times, prints draws and time */
  private static final boolean runTests = false;
  // =========================================================== //

  public static void main(String[] args) {
    if (!runTests) {
      Game game = new Game();
      Scanner scanner = new Scanner(System.in);
      System.out.println("-----------------------------------");
      System.out.println("Welcome to Tic Tac Toe!");
      System.out.println("Enter a number to select a game mode:");
      System.out.println(" |  1. Human vs Human");
      System.out.println(" |  2. Human vs Computer");
      System.out.println(" |  3. Computer vs Human");
      System.out.println(" |  4. Computer vs Computer");
      System.out.print(" | >>> ");
      int mode;
      if (autoPlay) {
        mode = 4;
      } else {
        mode = scanner.nextInt();
      }

      if (mode == 1) {
        game.setPlayer(0, new Player(1, game));
        game.setPlayer(1, new Player(2, game));
      } else if (mode == 2) {
        game.setPlayer(0, new Player(1, game));
        game.setPlayer(1, new ComputerPlayer(2, game));
      } else if (mode == 3) {
        game.setPlayer(0, new ComputerPlayer(1, game));
        game.setPlayer(1, new Player(2, game));
      } else if (mode == 4) {
        game.setPlayer(0, new ComputerPlayer(1, game));
        game.setPlayer(1, new ComputerPlayer(2, game));
      } else {
        System.out.println("Invalid input. Restarting...\n\n");
        main(args);
        System.exit(0);
      }
      game.play();
      scanner.close();
    }
    else
    {
      System.out.println((multiThreaded ? "Multi-Threaded" : "Single-Threaded"));
      ArrayList<GameThread> threads = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
        GameThread thread = new GameThread(100);
        threads.add(thread);
      }
      ThreadManager manager = new ThreadManager();
      manager.addThreads(threads.toArray(new GameThread[threads.size()]));
      manager.setMaxThreads(4);
      // manager.startAll();
      // manager.joinAll(true); // TODO
      int draws = 0;
      // start timer
      long startTime = System.currentTimeMillis();

      for (int i = 0; i < 1000; i++) {
        Game game = new Game();
        game.setPlayer(0, new ComputerPlayer(1, game));
        game.setPlayer(1, new ComputerPlayer(2, game));
        game.play();
        if (game.board.checkForWin() == -1) {
          draws++;
        }
      }

      for (GameThread thread : threads) {
        draws += thread.draws;
      }
      System.out.println("Draws: " + draws);
      System.out.println("Time: " + ((double) (System.currentTimeMillis() - startTime) / 1000) + "s");
    }
  }

  private static class GameThread extends Thread {
    public int draws = 0;
    private int iterations;

    public GameThread(int iterations) {
      this.iterations = iterations;
    }

    @Override
    public void run() {
      for (int i = 0; i < iterations; i++) {
        Game game = new Game();
        game.setPlayer(0, new ComputerPlayer(1, game));
        game.setPlayer(1, new ComputerPlayer(2, game));
        game.play();
        if (game.board.checkForWin() == -1) {
          draws++;
        }
      }
    }
  }
}
