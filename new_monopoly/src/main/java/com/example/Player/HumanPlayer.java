package com.example.Player;

import java.util.concurrent.CancellationException;

import com.example.Board.Property.PropertyBase;
import com.example.Board.Property.Types.RailroadProperty;
import com.example.Board.Property.Types.StreetProperty;
import com.example.Board.Property.Types.UtilityProperty;
import com.example.Utils.DisplayManager;

public class HumanPlayer extends PlayerBase {
    DisplayManager DM;

    public HumanPlayer(String name, DisplayManager DM) {
        super(name);
        this.DM = DM;
    }

    public void handleTurn() {
        boolean turnEnded = false;
        while (!turnEnded) {
            getInput();
        }
    }

    private void getInput() {
        DisplayManager.clearScreen();
        DM.printBoard();
        System.out.println("Player " + getName() + "'s turn. Enter command: ");
        String input = System.console().readLine();
        parseInput(input);
    }

    private void parseInput(String input) {
        for (char c : input.toCharArray()) {
            try {
                switch (c) {
                    case 'w' -> DM.moveCursorUp();
                    case 's' -> DM.moveCursorDown();
                    case 'a' -> DM.moveCursorLeft();
                    case 'd' -> DM.moveCursorRight();

                    case 'r' -> { // roll
                        // TODO: implement rolling logic
                        // TODO: move cursor to current position?
                    }

                    case 'u' -> { // upgrade
                        upgrade();
                    }
                    case 'U' -> { // downgrade
                        downgrade();
                    }
                    case 'b' -> { // buy
                        buy();
                    }

                    case 'B' -> { // sell
                        sell();
                    }

                    case '\n' -> { // enter
                    }
                    default -> {
                        System.out.println("Unknown command: " + c);
                    }
                }

            } catch (CancellationException e) {
                System.out.println("Action cancelled.");
            } catch (Exception e) {
                System.out.println("Error processing \'" + c + "\'': " + e.getMessage());
            }
        }
    }

    private void buy() {
        if (DM.getSelectedProperty() == game.board.properties[position]) {
            PropertyBase property = DM.getSelectedProperty();
            if (property instanceof StreetProperty streetProperty
                    && streetProperty.getOwner() == null) {
                if (money >= streetProperty.buyPrice) {
                    streetProperty.setOwner(this);
                    adjustMoney(-streetProperty.buyPrice);
                    System.out.println(
                            "Purchased " + streetProperty.name + " for $" + streetProperty.buyPrice);
                } else {
                    System.out.println("Insufficient funds to purchase this property.");
                }
            } else if (property instanceof RailroadProperty railroadProperty
                    && railroadProperty.getOwner() == null) {
                if (money >= railroadProperty.buyPrice) {
                    railroadProperty.setOwner(this);
                    adjustMoney(-railroadProperty.buyPrice);
                    System.out.println("Purchased " + railroadProperty.name + " for $"
                            + railroadProperty.buyPrice);
                } else {
                    System.out.println("Insufficient funds to purchase this property.");
                }
            } else if (property instanceof UtilityProperty utilityProperty
                    && utilityProperty.getOwner() == null) {
                if (money >= utilityProperty.buyPrice) {
                    utilityProperty.setOwner(this);
                    adjustMoney(-utilityProperty.buyPrice);
                    System.out.println(
                            "Purchased " + utilityProperty.name + " for $" + utilityProperty.buyPrice);
                } else {
                    System.out.println("Insufficient funds to purchase this property.");
                }
            } else {
                System.out.println("Selected property cannot be purchased.");
            }
        } else {
            System.out.println("No property selected for purchase.");
        }
    }

    private void downgrade() {
        PropertyBase property = DM.getSelectedProperty();
        if (property != null) {
            if (property instanceof StreetProperty streetProperty
                    && streetProperty.getOwner() == this) {
                streetProperty.sellHouse();
            } else {
                System.out.println("Selected property is not downgradable.");
            }
        } else {
            System.out.println("No property selected for downgrade.");
        }
    }

    private void upgrade() {
        PropertyBase property = DM.getSelectedProperty();
        if (property != null) {
            if (property instanceof StreetProperty streetProperty
                    && streetProperty.getOwner() == this) {
                streetProperty.buildHouse();
            } else {
                System.out.println("Selected property is not upgradable.");
            }
        } else {
            System.out.println("No property selected for upgrade.");
        }
    }

    private void sell() {
        PropertyBase property = DM.getSelectedProperty();
        if (property == null) {
            System.out.println("No property selected for sale.");
        }

        if (property instanceof StreetProperty streetProperty
                && streetProperty.getOwner() == null) {
            int value = streetProperty.buyPrice / 2;
            streetProperty.setOwner(this);
            adjustMoney(value);
            System.out.println("Sold " + streetProperty.name + " for $" + value);
        } else if (property instanceof RailroadProperty railroadProperty
                && railroadProperty.getOwner() == null) {
            int value = railroadProperty.buyPrice / 2;
            railroadProperty.setOwner(this);
            adjustMoney(value);
            System.out.println("Sold " + railroadProperty.name + " for $" + value);
        } else if (property instanceof UtilityProperty utilityProperty
                && utilityProperty.getOwner() == null) {
            int value = utilityProperty.buyPrice / 2;
            utilityProperty.setOwner(this);
            adjustMoney(value);
            System.out.println("Sold " + utilityProperty.name + " for $" + value);
        } else {
            System.out.println("Selected property cannot be sold.");
        }
    }

    @Override
    public void onLandUnowned(PropertyBase property) {
    }

    @Override
    protected int handleBankruptcy(int charge) {
        while (money < charge) {
            if (numPropertiesOwned() == 0) {
                System.out.println("You have no properties left to sell. You are bankrupt!");
                int temp = money;
                money = -1;
                return temp; // Pay whatever is left
            }

            System.out.println("You need to raise $" + (charge - money) + " to pay your debts.");
            System.out.println("Select a property to sell houses or morgatge");
            getInput();
        }
        return charge;
    }

    private int numPropertiesOwned() {
        int count = 0;
        for (PropertyBase property : game.board.properties) {
            if (property.getOwner() == this) {
                count++;
            }
        }
        return count;
    }
}
