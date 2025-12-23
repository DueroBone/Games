package com.example.Board.Cards.Move;

import com.example.Board.Cards.Card;
import com.example.Board.Cards.CardType;
import com.example.Player.PlayerBase;

public class MoveToLocationCard extends Card {
    public final int locationIndex;

    public MoveToLocationCard(String description, int locationIndex) {
        super(description, CardType.MoveToLocation);
        this.locationIndex = locationIndex;
    }

    @Override
    public void onDraw(PlayerBase player) {
        // TODO: move player to `locationIndex`
    }
}
