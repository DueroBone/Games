package com.example.Board.Cards.Money;

import com.example.Board.Cards.Card;
import com.example.Board.Cards.CardType;
import com.example.Player.PlayerBase;

public class TaxCard extends Card {
    private final int amount;

    public TaxCard(String description, int amount) {
        super(description, CardType.Tax);
        this.amount = amount;
    }

    @Override
    public void onDraw(PlayerBase player) {
        // TODO: implement tax payment behavior
    }
}
