package com.example.Board.Cards;

public class Deck {
    final Card[] cards;
    int topCardIndex;

    public Deck(Card[] cards) {
        this.cards = cards;
        this.topCardIndex = 0;
    }

    public Deck(Card card) {
        this.cards = new Card[] { card };
        this.topCardIndex = 0;
    }

    public Card drawCard() {
        Card card = cards[topCardIndex];
        topCardIndex = (topCardIndex + 1) % cards.length;
        return card;
    }
}
