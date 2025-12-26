package com.example.Utils;

import com.example.Board.Board;
import com.example.Board.Property.Types.StreetProperty;
import com.example.Player.PlayerBase;

public class Game {
    public final Board board = new Board();
    public final PlayerBase[] players;

    public Game(PlayerBase... players) {
        this.players = players;
        board.addToGame(this);
        for (PlayerBase player : players) {
            player.setGame(this);
        }
    }

    public void upgradeProperty(PlayerBase player, int propertyIndex) {
        if (propertyIndex < 0 || propertyIndex >= board.properties.length) {
            throw new IllegalArgumentException("Invalid property index: " + propertyIndex);
        }

        var property = board.properties[propertyIndex];
        if (property instanceof StreetProperty streetProperty) {
            if (streetProperty.getOwner() != player) {
                throw new IllegalArgumentException("Player " + player.getName() + " does not own property #" + propertyIndex);
            }
            streetProperty.buildHouse();
        } else {
            throw new IllegalArgumentException("Property #" + propertyIndex + " is not a street property");
        }
    }
}
