package RussianRoulette;

public class Player {
  private int name;
  private Game game;
  private boolean dead = false;
  private java.util.Scanner scanner = new java.util.Scanner(System.in);

  public Player(int name, Game game) {
    this.name = name;
    this.game = game;
  }

  public void getMove() {
    System.out.println("What do you want to do?");
    System.out.println("1. Pull the trigger");
    System.out.println("2. Spin the chamber");
    System.out.print(" >> ");
    
    int input = scanner.nextInt();
    if (input == 2) {
      game.wheel.spin();
      getMove();
    } else if (input != 1) {
      System.out.println("Invalid input.");
      getMove();
    }
    if (game.wheel.fire()) {
      dead = true;
    } else {
      // System.out.println("You live to see another day.\n");
    }
  }

  public boolean isDead() {
    return dead;
  }

  public String toString() {
    return "" + name;
  }
}
