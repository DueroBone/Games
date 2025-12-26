package com.example.Board.Property;

import com.example.Board.Dice.RollResults;
import com.example.Player.PlayerBase;
import com.example.Utils.Game;

public abstract class PropertyBase {
    public final PropertyType type;
    public final String name;
    protected PlayerBase owner;
    protected Game game;

    public PropertyBase(PropertyType type, String name) {
        this.type = type;
        this.name = name;
        this.owner = null;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public PlayerBase getOwner() {
        return owner;
    }

    public void setOwner(PlayerBase newOwner) {
        this.owner = newOwner;
    }

    public abstract void onLand(PlayerBase player, RollResults rollResults);

    public abstract String[] display();
}
