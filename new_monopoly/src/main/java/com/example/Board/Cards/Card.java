package com.example.Board.Cards;

import com.example.Player.PlayerBase;

public abstract class Card {
    public final String description;
    public final CardType type;

    public Card(String description, CardType type) {
        this.description = description;
        this.type = type;
    }

    public abstract void onDraw(PlayerBase player);
}
