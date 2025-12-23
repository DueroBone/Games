package com.example.Board.Cards.Money;

import com.example.Board.Cards.Card;
import com.example.Board.Cards.CardType;
import com.example.Player.PlayerBase;

public class AllPlayerMoneyCard extends Card {
    private final int amount;

    public AllPlayerMoneyCard(String description, int amount) {
        super(description, CardType.AllPlayerMoney);
        this.amount = amount;
    }

    @Override
    public void onDraw(PlayerBase player) {
        // TODO: implement taking money from all other players / giving to player
    }
}
