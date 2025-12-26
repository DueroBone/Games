package com.example.Utils;

import com.example.Board.Board;
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
}
