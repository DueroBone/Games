package com.example.Board.Property.Types;

import com.example.Board.Dice.RollResults;
import com.example.Board.Cards.Card;
import com.example.Board.Cards.Deck;
import com.example.Board.Property.PropertyBase;
import com.example.Board.Property.PropertyType;
import com.example.Player.PlayerBase;
import com.example.Utils.StringFormating;

public class DrawProperty extends PropertyBase {
    private final Deck deck;

    public DrawProperty(String name, Deck deck) {
        super(PropertyType.Draw, name);
        this.deck = deck;
    }

    @Override
    public void onLand(PlayerBase player, RollResults rollResults) {
        Card card = deck.drawCard();
        card.onDraw(player);
    }

    @Override
    public String[] display() {
        String[] icon = switch (name) {
            case "Chance" -> getChanceIcon();
            case "Community Chest" -> getCommunityChestIcon();
            default -> new String[] { "", "", "", "", "" };
        };
        return StringFormating.box(name,
                icon[0],
                icon[1],
                icon[2],
                icon[3],
                icon[4]);
    }

    // ====== Icons for different draw types ======
    private String[] getChanceIcon() {
        return new String[] {
                "   ===    ",
                " //   \\\\   ",
                "     //   ",
                "    ||    ",
                "    OO    " };
    }

    private String[] getCommunityChestIcon() {
        return new String[] {
                " ╔═════════╗ ",
                " ║  ╔═╬══  ║ ",
                " ║  ╚═╬═╗  ║ ",
                " ║  ══╬═╝  ║ ",
                " ╚═════════╝ "
        };
    }

    private String[] getIncomeTaxIcon() {
        return new String[] {
                "",
                "",
                "",
                "",
                ""
        };
    }

    private String[] getLuxuryTaxIcon() {
        return new String[] {
                "",
                "",
                "",
                "",
                ""
        };
    }

    private String[] getGoToJailIcon() {
        return new String[] {
                "",
                "",
                "",
                "",
                ""
        };
    }

    private String[] getFreeParkingIcon() {
        return new String[] {
                "",
                "",
                "",
                "",
                ""
        };
    }

    private String[] getGoIcon() {
        return new String[] {
                "",
                "",
                "",
                "",
                ""
        };
    }
}
