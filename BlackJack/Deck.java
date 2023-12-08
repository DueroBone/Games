package BlackJack;

import java.util.ArrayList;

public class Deck {
  private ArrayList<Card> cards = new ArrayList<Card>();

  public Deck() {
    String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
    String[] ranks = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Jack", "Queen", "King" };
    int[] values = { 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };
    for (int i = 0; i < suits.length; i++) {
      for (int j = 0; j < ranks.length; j++) {
        cards.add(new Card(suits[i], ranks[j], values[j]));
      }
    }
  }

  public Card draw() {
    if (cards.size() == 0) {
      throw new IllegalStateException("Deck is empty.");
    }
    int index = (int) (Math.random() * cards.size());
    Card card = cards.get(index);
    cards.remove(index);
    return card;
  }

  public int size() {
    return cards.size();
  }
}
