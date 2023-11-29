import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {
  public static final boolean SilentMode = false;
  public static final boolean ShowEngine = true;
  public static final boolean multiThreaded = false;

  public static void main(String[] args) {
    if (!SilentMode) {
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
      // int mode = scanner.nextInt();
      int mode = 4;
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
    } else { 
      ArrayList<GameThread> threads = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
        GameThread thread = new GameThread(100);
        threads.add(thread);
      }
      ThreadManager manager = new ThreadManager();
      manager.addThreads(threads.toArray(new GameThread[threads.size()] ));
      manager.setMaxThreads(4);
      manager.startAll();
      manager.joinAll(true); // TODO
      int draws = 0; /*
      for (int i = 0; i < 10000; i++) {
        Game game = new Game();
        game.setPlayer(0, new ComputerPlayer(1, game));
        game.setPlayer(1, new ComputerPlayer(2, game));
        game.play();
        if (game.board.checkForWin() == -1) {
          draws++;
        } 
      } */
      for (GameThread thread : threads) {
        draws += thread.draws;
      }
      System.out.println("Draws: " + draws);
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
