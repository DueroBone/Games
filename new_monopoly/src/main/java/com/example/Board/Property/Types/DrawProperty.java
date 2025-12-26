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
            case "Income Tax" -> getIncomeTaxIcon();
            case "Luxury Tax" -> getLuxuryTaxIcon();
            case "Go To Jail" -> getGoToJailIcon();
            case "Free Parking" -> getFreeParkingIcon();
            case "Go" -> getGoIcon();
            default -> new String[] { "", "", "", "", "", "" };
        };
        return StringFormating.box(
                icon[0],
                icon[1],
                icon[2],
                icon[3],
                icon[4],
                icon[5]);
    }

    // ====== Icons for different draw types ======
    private String[] getChanceIcon() {
        return new String[] {
                "Chance",
                "    ===    ",
                "  //   \\\\  ",
                "      //   ",
                "     ||    ",
                "     <>    " };
    }

    private String[] getCommunityChestIcon() {
        return new String[] {
                "Community chest",
                " ╔═════════╗ ",
                " ║  ╔═╬══  ║ ",
                " ║  ╚═╬═╗  ║ ",
                " ║  ══╬═╝  ║ ",
                " ╚═════════╝ "
        };
    }

    private String[] getIncomeTaxIcon() {
        return new String[] {
                "Income Tax",
                "          ",
                "          ",
                "     X    ",
                "          ",
                "          "
        };
    }

    private String[] getLuxuryTaxIcon() {
        return new String[] {
                "Luxury Tax",
                "         ",
                "   <X>   ",
                " ╭──╨──╮ ",
                " │     │ ",
                " ╰─────╯ "
        };
    }

    private String[] getGoToJailIcon() {
        return new String[] {
                "Go To Jail",
                "            ",
                "  ^───^───^ ",
                "  │  $$$  │ ",
                "  │  $$$  │ ",
                "   \\_____/  "
        };
    }

    private String[] getFreeParkingIcon() {
        return new String[] {
                "Free Parking",
                "         ",
                " ╭─────╮ ",
                " │ [ ] │ ",
                "╭┼──0──┼╮",
                "O       O"
        };
    }

    private String[] getGoIcon() {
        return new String[] {
                "╔═════╗   ╔════╗",
                "║     ╨   ║    ║",
                "║   ══╗   ║    ║",
                "║     ║   ║    ║",
                "╚═════╝   ╚════╝",
                "K────────"
        };
    }
}
