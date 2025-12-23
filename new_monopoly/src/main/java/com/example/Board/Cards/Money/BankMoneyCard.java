package com.example.Board.Cards.Money;

import com.example.Board.Cards.Card;
import com.example.Board.Cards.CardType;
import com.example.Player.PlayerBase;

public class BankMoneyCard extends Card {
    private final int amount;

    public BankMoneyCard(String description, int amount) {
        super(description, CardType.BankMoney);
        this.amount = amount;
    }

    @Override
    public void onDraw(PlayerBase player) {
        // TODO: implement bank-money behavior (pay/receive from bank)
    }
}
