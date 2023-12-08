package BlackJack;

import java.util.ArrayList;

public class Player {
  private String name;
  private Hand hand = new Hand();
  private Game game;
  private boolean isBot = false;
  int target = 21;

  public Player(String name, Game game) {
    this.name = name;
    this.game = game;
    pickUp(game.deck.draw());
    pickUp(game.deck.draw());
  }

  public Player(String name, Game game, int target) {
    this(name, game);
    this.isBot = true;
    this.target = target;
  }

  public String getName() {
    return name;
  }

  public void pickUp(Card card) {
    hand.add(card);
  }

  public int getHandValue() {
    return hand.getValue();
  }

  public boolean isBot() {
    return isBot;
  }

  public String toString() {
    return name + ": " + hand + " (" + getHandValue() + ")";
  }

  private boolean isBust() {
    return getHandValue() > 21;
  }

  public void getMove() {
    boolean keepGoing = true;
    while (keepGoing) {
      if (isBot) {
        if (getHandValue() < target) {
          pickUp(game.deck.draw());
          System.out.println(this);
        } else {
          System.out.println(getName() + " stays at " + getHandValue() + ".");
          sleep();
          keepGoing = false;
          game.turn++;
          break;
        }
      } else {
        System.out.print(name + ": Hit or stay? ");
        String move = game.scanner.next();
        if (move.strip().equalsIgnoreCase("hit")) {
          pickUp(game.deck.draw());
          System.out.println(this);
        } else if (move.strip().equalsIgnoreCase("stay")) {
          System.out.println(getName() + " stays at " + getHandValue() + ".");
          keepGoing = false;
          game.turn++;
          break;
        }
      }
      if (isBust()) {
        System.out.println(name + " is bust.");
        sleep();
        keepGoing = false;
        game.turn++;
      }
    }
  }

  private void sleep() {
    try {
      if (isBot) {
        Thread.sleep(250);
      } else {
        Thread.sleep(1500);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private class Hand {
    private ArrayList<Card> cards = new ArrayList<Card>();

    public void add(Card card) {
      cards.add(card);
    }

    public int getValue() {
      int value = 0;
      for (Card card : cards) {
        value += card.getValue();
      }
      for (Card card : cards) {
        if (card.getRank().equals("Ace") && value > 21) {
          value -= 10;
        }
      }
      return value;
    }

    public String toString() {
      if (cards.size() == 0) {
        return "None";
      }
      String string = "";
      for (Card card : cards) {
        string += ", " + card;
      }
      return string.substring(2);
    }
  }
}
