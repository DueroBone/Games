package com.example.Board.Property.Types;

import com.example.Board.Dice.RollResults;
import com.example.Board.Property.PropertyBase;
import com.example.Board.Property.PropertyType;
import com.example.Board.Property.StreetColor;
import com.example.Player.PlayerBase;
import com.example.Utils.StringFormating;

public class StreetProperty extends PropertyBase {
    public final StreetColor color;
    public final int buyPrice;
    final int houseCost;
    final int[] rentPrices;
    int housesBuilt = 0;

    public StreetProperty(String name, StreetColor color, int buyPrice, int[] rentPrices) {
        super(PropertyType.Street, name);
        this.color = color;
        this.buyPrice = buyPrice;
        this.rentPrices = rentPrices;

        this.houseCost = switch (color) {
            case Brown, LightBlue -> 50;
            case Pink, Orange -> 100;
            case Red, Yellow -> 150;
            case Green, DarkBlue -> 200;
        };
    }

    @Override
    public void onLand(PlayerBase player, RollResults rollResults) {
        if (owner == null) {
            // Property is unowned, player may buy it
            player.attemptPurchase(this);
        } else if (owner != player) {
            // Property is owned by another player, pay rent
            int rent = rentPrices[housesBuilt];

            player.transferMoney(owner, rent);
        }
    }

    public boolean canBuildHouse() {
        return housesBuilt < rentPrices.length - 1;
    }

    public void buildHouse() {
        if (canBuildHouse()) {
            housesBuilt++;
            owner.adjustMoney(-houseCost);
        }
    }

    @Override
    public String[] display() {
        String ownerName = (owner != null) ? owner.getName() : "None";
        return StringFormating.box(
                name,
                "Color: " + color.toString(),
                "Owner: " + ownerName,
                "Houses: " + housesBuilt);
    }
}