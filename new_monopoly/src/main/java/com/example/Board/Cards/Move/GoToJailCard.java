package com.example.Board.Cards.Move;

import com.example.Board.Cards.Card;
import com.example.Board.Cards.CardType;
import com.example.Player.PlayerBase;

public class GoToJailCard extends Card {
    public GoToJailCard(String description) {
        super(description, CardType.GoToJail);
    }

    @Override
    public void onDraw(PlayerBase player) {
        // TODO: send player to jail
    }
}
