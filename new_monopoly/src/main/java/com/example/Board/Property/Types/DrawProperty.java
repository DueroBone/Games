package com.example.Board.Property.Types;

import com.example.Board.Dice.RollResults;
import com.example.Board.Cards.Card;
import com.example.Board.Cards.Deck;
import com.example.Board.Property.PropertyBase;
import com.example.Board.Property.PropertyType;
import com.example.Player.PlayerBase;
import com.example.Utils.StringFormating;

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

    @Override
    public String[] display() {
        return StringFormating.box(name);
    }
}
