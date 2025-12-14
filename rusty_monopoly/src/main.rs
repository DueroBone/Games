mod action_card;
mod board;
mod deck;
mod dice;
mod player;
mod property;

use crate::board::Board;

fn main() {
    println!("Hello, world!");
    let board = Board::new();
    board.get_property(1);
}
