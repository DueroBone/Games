package com.example.Board.Cards.Move;

import com.example.Board.Cards.Card;
import com.example.Board.Cards.CardType;
import com.example.Player.PlayerBase;

public class MoveToNearestUtilityCard extends Card {
    public MoveToNearestUtilityCard(String description) {
        super(description, CardType.MoveToNearestUtility);
    }

    @Override
    public void onDraw(PlayerBase player) {
        // TODO: move player to nearest utility
    }
}
