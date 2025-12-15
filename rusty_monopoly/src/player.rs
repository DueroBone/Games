use crate::dice::{RollResult, roll_dice};
use std::{io, ptr::null};
use crate::game::Game;

pub struct Player<'a> {
    name: String,
    position: i32,
    money: i32,
    jail_counter: u8,
    parent_game: &'a Game<'a>,
}

impl<'a> Player<'a> {
    pub fn new(name: &str, parent_game: &'a Game<'a>) -> Self {
        Player {
            name: name.to_string(),
            position: 0,
            money: 1500,
            jail_counter: 0,
            parent_game,
        }
    }

    fn move_position(&mut self, steps: i32) {
        self.position = (self.position + steps) % 40;
    }

    pub fn roll(&mut self) -> RollResult {
        let result = roll_dice();
        let steps = result.total as i32;
        self.move_position(steps);
        return result;
    }

    fn adjust_money(&mut self, amount: i32) {
        self.money += amount;
    }

    pub fn get_position(&self) -> i32 {
        self.position
    }

    pub fn get_money(&self) -> i32 {
        self.money
    }

    pub fn get_name(&self) -> &str {
        &self.name
    }

    fn imprison(&mut self) {
        self.position = 10; // Jail position
        self.jail_counter = 3;
    }

    pub fn human_turn(&mut self) {
        let mut num_doubles = 0;
        while num_doubles < 3 {
            let result = self.roll();
            println!("{} rolled a {}", self.name, result.total);

            println!("{} moved to position {}", self.name, self.position);
            println!("Do you want to buy this property? (y/n)");
            let mut input = String::new();

            let stdin = io::stdin();
            stdin.read_line(&mut input).expect("Failed to read line");
            if input.trim().to_lowercase() == "y" {
                // TODO: Implement property purchase logic
                println!("{} bought the property!", self.name);
            } else {
                println!("{} chose not to buy the property.", self.name);
            }

            if result.is_double {
                num_doubles += 1;
                if num_doubles == 3 {
                    println!("{} rolled three doubles and is sent to jail!", self.name);
                    self.imprison();
                    break;
                } else {
                    println!("{} rolled a double and gets another turn!", self.name);
                }
            } else {
                break;
            }
        }
    }
}
