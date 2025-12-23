package com.example.Board.Cards.Move;

import com.example.Board.Cards.Card;
import com.example.Board.Cards.CardType;
import com.example.Player.PlayerBase;

public class MoveToNearestRailroadCard extends Card {
    public MoveToNearestRailroadCard(String description) {
        super(description, CardType.MoveToNearestRailroad);
    }

    @Override
    public void onDraw(PlayerBase player) {
        // TODO: move player to nearest railroad
    }
}
