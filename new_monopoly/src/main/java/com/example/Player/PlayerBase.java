package com.example.Player;

import com.example.Board.Property.PropertyBase;
import com.example.Utils.Game;

public abstract class PlayerBase {
    int position;
    int money;
    String name;
    Game game;

    public PlayerBase(String name) {
        this.name = name;
        this.money = 1500;
        this.position = 0;
    }

    /**
     * Set the game instance for this player
     * Needs to be called upon initialization
     */
    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getPosition() {
        return position;
    }

    public void move(int steps) {
        position = (position + steps) % game.board.properties.length;
    }

    /**
     * Adjust player's money by amount (can be negative).
     * 
     * @return Actual amount adjusted (may be less than requested if bankruptcy
     *         occurs)
     */
    public int adjustMoney(int amount) {
        if (money + amount < 0) {
            // if player cannot pay, handle bankruptcy
            return handleBankruptcy(amount);
        }
        money += amount;
        return amount;
    }

    public void transferMoney(PlayerBase recipient, int amount) {
        int paid = this.adjustMoney(-amount);
        recipient.adjustMoney(paid);
    }

    // Handled differently by computer and human players
    public abstract void onLandUnowned(PropertyBase property);


    /**
     * Handle bankruptcy scenario
     * 
     * @param charge How much the player needs to pay (ignoring current funds)
     * @return Final amount paid, possibly less than charge if assets were
     *         liquidated
     */
    protected abstract int handleBankruptcy(int charge);
}
