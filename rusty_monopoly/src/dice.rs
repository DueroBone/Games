use rand::{self, Rng};

pub struct RollResult {
    total: u8,
    is_double: bool,
    is_snake_eyes: bool,
}

pub fn roll_dice() -> RollResult {
    let mut generator = rand::rng();
    let die1 = generator.random_range(1..=6);
    let die2 = generator.random_range(1..=6);

    let total = die1 + die2;
    let is_double = die1 == die2;
    let is_snake_eyes = die1 == 1 && die2 == 1;

    RollResult {
        total,
        is_double,
        is_snake_eyes,
    }
}