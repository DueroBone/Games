package com.example.Board.Property;

import com.example.Board.Dice.RollResults;
import com.example.Board.Cards.Card;
import com.example.Board.Cards.Deck;
import com.example.Player.PlayerBase;

public class DrawProperty extends PropertyBase {
    private final Deck deck;

    public DrawProperty(String name, Deck deck) {
        super(PropertyType.Draw, name);
        this.deck = deck;
    }

    @Override
    public void onLand(PlayerBase player, RollResults rollResults) {
        Card card = deck.drawCard();
        card.onDraw(player);
    }
}
