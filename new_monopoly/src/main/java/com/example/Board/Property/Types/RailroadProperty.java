package com.example.Board.Property.Types;

import com.example.Board.Dice.RollResults;
import com.example.Board.Property.PropertyBase;
import com.example.Board.Property.PropertyType;
import com.example.Player.PlayerBase;
import com.example.Utils.StringFormating;

public class RailroadProperty extends PropertyBase {
    private static final int[] rentPrices = { 0, 25, 50, 100, 200 };

    public RailroadProperty(String name) {
        super(PropertyType.Railroad, name);
    }

    @Override
    public void onLand(PlayerBase player, RollResults rollResults) {
        if (owner == null) {
            // Property is unowned, player may buy it
            player.attemptPurchase(this);
        } else if (owner != player) {
            // Property is owned by another player, pay rent

            int ownedCount = 0;
            for (PropertyBase property : game.board.properties) {
                if (property instanceof RailroadProperty &&
                        property.getOwner() == owner) {
                    ownedCount++;
                }
            }
            int rent = rentPrices[ownedCount]; // Rent is based on number of railroads owned
            player.transferMoney(owner, rent);
        }
    }

    @Override
    public String[] display() {
        String ownerName = (owner != null) ? owner.getName() : "None";
        return StringFormating.box(
                name,
                "Owner: " + ownerName,
                " ___   *.   ",
                "|{ }|___Y_  ",
                "|===|=====| ",
                " @-@-@--oo \\ ");
    }
}
