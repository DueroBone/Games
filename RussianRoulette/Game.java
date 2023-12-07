package RussianRoulette;

import java.util.ArrayList;

public class Game {
  Wheel wheel = new Wheel();
  ArrayList<Player> players = new ArrayList<Player>();
  int currentPlayer = 0;
  java.util.Scanner scanner = new java.util.Scanner(System.in);

  public void play() {
    System.out.print("How many players? ");
    int numPlayers = scanner.nextInt();
    for (int i = 0; i < numPlayers; i++) {
      players.add(new Player(i + 1, this));
    }
    while (true) {
      if (getLivingPlayers() <= 1) {
        break;
      }

      Player player = getLivePlayer();
      System.out.println("\nPlayer " + player + "'s turn.");
      player.getMove();
      currentPlayer = (currentPlayer + 1) % players.size();
      if (player.isDead()) {
        System.out.println("==== Player " + player + " is dead ====\n");
      } else {
        System.out.println("Player " + player + " is alive.\n");
      }
    }
    System.out.println("Player " + getLivePlayer() + " survived.");
  }

  private int getLivingPlayers() {
    int livingPlayers = 0;
    for (Player player : players) {
      if (!player.isDead()) {
        livingPlayers++;
      }
    }
    return livingPlayers;
  }

  private Player getLivePlayer() {
    Player player = players.get(currentPlayer);
    while (player.isDead()) {
      currentPlayer = (currentPlayer + 1) % players.size();
      player = players.get(currentPlayer);
    }
    return player;
  }
}
