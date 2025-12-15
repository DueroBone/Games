use crate::board::Board;
use crate::player::Player;

pub struct Game<'a> {
    board: Board,
    players: Vec<Player<'a>>,
}

impl<'a> Game<'a> {
    pub fn new(player_names: Vec<&'a str>) -> Self {
        let mut game = Game {
            board: Board::new(),
            players: Vec::new(),
        };
        for name in player_names {
            game.players.push(
                Player::new(name, &game)
            );
        }
        game
    }
}