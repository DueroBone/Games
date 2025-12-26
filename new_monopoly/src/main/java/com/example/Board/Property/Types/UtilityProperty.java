package com.example.Board.Property.Types;

import com.example.Board.Dice.RollResults;
import com.example.Board.Property.PropertyBase;
import com.example.Board.Property.PropertyType;
import com.example.Player.PlayerBase;
import com.example.Utils.StringFormating;

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

    @Override
    public String[] display() {
        String ownerName = (owner != null) ? owner.getName() : "None";
        String[] icon = switch (name) {
            case "Electric Company" -> new String[] {
                    "   ╭─────╮  ",
                    "    ╲*X*╱   ",
                    "     ╲ ╱    ",
                    "      ╳     "
            };
            case "Water Works" -> new String[] {
                    "             ",
                    "  ║   X      ",
                    "  ╠═══╧═══╗  ",
                    "  ║          "
            };
            default -> new String[] { "", "", "", "", "", "", ""
            };
        };
        return StringFormating.box(
                name,
                "Owner: " + ownerName,
                icon[0],
                icon[1],
                icon[2],
                icon[3]);
    }
}