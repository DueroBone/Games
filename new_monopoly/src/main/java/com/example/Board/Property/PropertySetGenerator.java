package com.example.Board.Property;

import com.example.Board.Cards.Card;
import com.example.Board.Cards.Deck;
import com.example.Board.Cards.Money.BankMoneyCard;
import com.example.Board.Cards.Money.TaxCard;
import com.example.Board.Cards.Move.GoToJailCard;

public class PropertySetGenerator {
    public static final PropertyBase[] createDefault() {
        Deck chanceDeck = new Deck(createChanceCards());
        Deck communityChestDeck = new Deck(createCommunityChestCards());
        Deck goDeck = new Deck(new BankMoneyCard("Go", 200));
        Deck incomeTax = new Deck(new TaxCard("Income Tax", -200));
        Deck freeParking = new Deck(new BankMoneyCard("Free Parking", 0));
        Deck goToJail = new Deck(new GoToJailCard("Go to jail square"));
        Deck luxuryTax = new Deck(new TaxCard("Luxury Tax", -100));

        PropertyBase[] properties = new PropertyBase[] {
                new DrawProperty("Go", goDeck),
                new StreetProperty("Mediterranean Avenue", StreetColor.Brown,
                        60, new int[] { 2, 10, 30, 90, 160, 250 }),
                new DrawProperty("Community Chest", communityChestDeck),
                new StreetProperty("Baltic Avenue", StreetColor.Brown,
                        60, new int[] { 4, 20, 60, 180, 320, 450 }),
                new DrawProperty("Income Tax", incomeTax),
                new RailroadProperty("Reading Railroad"),
                new StreetProperty("Oriental Avenue", StreetColor.LightBlue,
                        100, new int[] { 6, 30, 90, 270, 400, 550 }),
                new DrawProperty("Chance", chanceDeck),
                new StreetProperty("Vermont Avenue", StreetColor.LightBlue,
                        100, new int[] { 6, 30, 90, 270, 400, 550 }),
                new StreetProperty("Connecticut Avenue", StreetColor.LightBlue,
                        120, new int[] { 8, 40, 100, 300, 450, 600 }),

                new JailProperty(),
                new StreetProperty("St. Charles Place", StreetColor.Pink,
                        140, new int[] { 10, 50, 150, 450, 625, 750 }),
                new UtilityProperty("Electric Company"),
                new StreetProperty("States Avenue", StreetColor.Pink,
                        140, new int[] { 10, 50, 150, 450, 625, 750 }),
                new StreetProperty("Virginia Avenue", StreetColor.Pink,
                        160, new int[] { 12, 60, 180, 500, 700, 900 }),
                new RailroadProperty("Pennsylvania Railroad"),
                new StreetProperty("St. James Place", StreetColor.Orange,
                        180, new int[] { 14, 70, 200, 550, 750, 950 }),
                new DrawProperty("Community Chest", communityChestDeck),
                new StreetProperty("Tennessee Avenue", StreetColor.Orange,
                        180, new int[] { 14, 70, 200, 550, 750, 950 }),
                new StreetProperty("New York Avenue", StreetColor.Orange,
                        200, new int[] { 16, 80, 220, 600, 800, 1000 }),

                new DrawProperty("Free Parking", freeParking),
                new StreetProperty("Kentucky Avenue", StreetColor.Red,
                        220, new int[] { 18, 90, 250, 700, 875, 1050 }),
                new DrawProperty("Chance", chanceDeck),
                new StreetProperty("Indiana Avenue", StreetColor.Red,
                        220, new int[] { 18, 90, 250, 700, 875, 1050 }),
                new StreetProperty("Illinois Avenue", StreetColor.Red,
                        240, new int[] { 20, 100, 300, 750, 925, 1100 }),
                new RailroadProperty("B&O Railroad"),
                new StreetProperty("Atlantic Avenue", StreetColor.Yellow,
                        260, new int[] { 22, 110, 330, 800, 975, 1150 }),
                new StreetProperty("Ventnor Avenue", StreetColor.Yellow,
                        260, new int[] { 22, 110, 330, 800, 975, 1150 }),
                new UtilityProperty("Water Works"),
                new StreetProperty("Marvin Gardens", StreetColor.Yellow,
                        280, new int[] { 24, 120, 360, 850, 1025, 1200 }),

                new DrawProperty("Go To Jail", goToJail),
                new StreetProperty("Pacific Avenue", StreetColor.Green,
                        300, new int[] { 26, 130, 390, 900, 1100, 1275 }),
                new StreetProperty("North Carolina Avenue", StreetColor.Green,
                        300, new int[] { 26, 130, 390, 900, 1100, 1275 }),
                new DrawProperty("Community Chest", communityChestDeck),
                new StreetProperty("Pennsylvania Avenue", StreetColor.Green,
                        320, new int[] { 28, 150, 450, 1000, 1200, 1400 }),
                new RailroadProperty("Short Line Railroad"),
                new DrawProperty("Chance", chanceDeck),
                new StreetProperty("Park Place", StreetColor.DarkBlue,
                        350, new int[] { 35, 175, 500, 1100, 1300, 1500 }),
                new DrawProperty("Luxury Tax", luxuryTax),
                new StreetProperty("Boardwalk", StreetColor.DarkBlue,
                        400, new int[] { 50, 200, 600, 1400, 1700, 2000 })
        };

        return properties;
    }

    public static Card[] createChanceCards() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createChanceCards'");
    }

    public static Card[] createCommunityChestCards() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCommunityChestCards'");
    }
}
