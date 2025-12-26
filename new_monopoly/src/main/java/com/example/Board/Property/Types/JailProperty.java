package com.example.Board.Property.Types;

import com.example.Board.Dice.RollResults;
import com.example.Board.Property.PropertyBase;
import com.example.Board.Property.PropertyType;
import com.example.Player.PlayerBase;
import com.example.Utils.StringFormating;

public class JailProperty extends PropertyBase {
    public JailProperty() {
        super(PropertyType.Jail, "Jail");
    }

    @Override
    public void onLand(PlayerBase player, RollResults rollResults) {
        // Just visiting, no action needed
    }

    @Override
    public String[] display() {
        return StringFormating.box(
                "Jail",
                "╶╥─╥─╥─╥╴", 
                " ║ ║ ║ ║ ", 
                " ║ ║ ║ ║ ", 
                "╶╨─╨─╨─╨╴",
                "Just Visiting");
    }
}
