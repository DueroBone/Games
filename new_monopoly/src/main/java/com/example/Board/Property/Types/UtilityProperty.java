package com.example.Board.Property.Types;

import com.example.Board.Dice.RollResults;
import com.example.Board.Property.PropertyBase;
import com.example.Board.Property.PropertyType;
import com.example.Player.PlayerBase;

public class UtilityProperty extends PropertyBase {
    private final int[] rentMultipliers = { 0, 4, 10 };

    public UtilityProperty(String name) {
        super(PropertyType.Utility, name);
    }

    @Override
    public void onLand(PlayerBase player, RollResults rollResults) {
        if (owner == null) {
            // Property is unowned, player may buy it
            player.attemptPurchase(this);
        } else if (owner != player) {
            // Property is owned by another player, pay rent
            int diceTotal = rollResults.getTotal();
            int rent = diceTotal * getPriceMult();
            player.transferMoney(owner, rent);
        }
    }

    private int getPriceMult() {
        int ownedCount = 0;
        for (PropertyBase property : game.board.properties) {
            if (property instanceof UtilityProperty &&
                    property.getOwner() == owner) {
                ownedCount++;
            }
        }
        return rentMultipliers[ownedCount];
    }
}