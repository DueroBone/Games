mod action_card;
mod board;
mod deck;
mod dice;
mod player;
mod property;
mod game;

use crate::board::Board;

fn main() {
    println!("Hello, world!");
    let board = Board::new();
    board.get_property(1);
    println!("Hello, world!"); 
    let mut player = player::Player::new("Alice");
    player.roll();
    println!("Player {} is at position {}", player.get_name(), player.get_position());
}
