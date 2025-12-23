package com.example.Board.Property;

import com.example.Board.Dice.RollResults;
import com.example.Player.PlayerBase;

public class JailProperty extends PropertyBase {
    public JailProperty() {
        super(PropertyType.Jail, "Jail");
    }

    @Override
    public void onLand(PlayerBase player, RollResults rollResults) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onLand'");
    }
}
