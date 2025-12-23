package com.example.Board.Cards.Move;

import com.example.Board.Cards.Card;
import com.example.Board.Cards.CardType;
import com.example.Player.PlayerBase;

public class MoveSpacesCard extends Card {
    public final int spaces;

    public MoveSpacesCard(String description, int spaces) {
        super(description, CardType.MoveSpaces);
        this.spaces = spaces;
    }

    @Override
    public void onDraw(PlayerBase player) {
        // TODO: move player by `spaces`
    }
}
