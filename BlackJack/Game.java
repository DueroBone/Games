package BlackJack;

import java.util.ArrayList;

public class Game {
  public ArrayList<Player> players = new ArrayList<Player>();
  public Deck deck = new Deck();
  public int turn = 0;
  public boolean gameOver = false;
  java.util.Scanner scanner = new java.util.Scanner(System.in);

  public Game() {
    System.out.print("How many players? ");
    int numPlayers = scanner.nextInt();
    for (int i = 1; i <= numPlayers; players.add(new Player("Player " + (i++), this))) {
    }
    System.out.print("How many bots? ");
    int numBots = scanner.nextInt();
    for (int i = 1; i <= numBots; players.add(new Player("Bot " + (i++), this, (int) (Math.random() * 3 + 18)))) {
    }
    if (players.size() == 0) {
      System.out.println("You need at least one player.");
      System.exit(0);
    } else if (players.size() >= 12) {
      System.out.println("The deck will likely run out of cards.");
    }
    System.out.println("\n====================\n");
  }

  public void play() {
    while (!gameOver) {
      Player player = players.get(turn);
      System.out.println(player);
      player.getMove();
      if (turn >= players.size()) {
        gameOver = true;
      }
      System.out.println("\n-------------------\n");
    }
    int bestScore = 0;
    Player bestPlayer = null;
    for (Player player : players) {
      if (player.getHandValue() > bestScore && player.getHandValue() <= 21) {
        bestScore = player.getHandValue();
        bestPlayer = player;
      }
    }
    if (bestPlayer == null) {
      System.out.print("Nobody");
    } else {
      System.out.print(bestPlayer.getName());
    }
    System.out.println(" wins.");
  }
}
