import java.util.Scanner;

public class TicTacToe {
  public static void main(String[] args) {
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
    int mode = scanner.nextInt();
    // int mode = 4;
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
}
