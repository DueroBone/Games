package com.example.Board.Cards.Money;

import com.example.Board.Cards.Card;
import com.example.Board.Cards.CardType;
import com.example.Player.PlayerBase;

public class RepairsCard extends Card {
    public RepairsCard(String description) {
        super(description, CardType.Repairs);
    }

    @Override
    public void onDraw(PlayerBase player) {
        // TODO: implement repairs cost calculation and payment
    }
}
