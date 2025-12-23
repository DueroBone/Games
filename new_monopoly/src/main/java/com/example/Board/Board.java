package com.example.Board;

import com.example.Game;
import com.example.Board.Property.PropertyBase;
import com.example.Board.Property.PropertySetGenerator;
import com.example.Utils.StringFormating;

public class Board {
    public final PropertyBase[] properties = new PropertyBase[40];

    public Board(PropertyBase[] properties) {
        for (int i = 0; i < properties.length; i++) {
            this.properties[i] = properties[i];
        }
    }

    public Board() {
        this(PropertySetGenerator.createDefault());
    }

    public void addToGame(Game game) {
        for (PropertyBase property : properties) {
            property.setGame(game);
        }
    }

    public String toString() {
        String[][] propertyDisplays = new String[properties.length][];
        for (int i = 0; i < properties.length; i++) {
            propertyDisplays[i] = properties[i].display();
        }
        return StringFormating.circleBoxes(10, 10, propertyDisplays);
    }
}
