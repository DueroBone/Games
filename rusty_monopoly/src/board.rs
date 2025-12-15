use crate::deck::{Deck, create_chance_deck, create_community_chest_deck};
use crate::property::Property;

pub struct Board {
    properties: [Property; 40],
    chance_deck: Deck,
    community_chest_deck: Deck,
}

impl Board {
    pub fn new() -> Self {
        Board {
            properties: create_properties(),
            chance_deck: create_chance_deck(),
            community_chest_deck: create_community_chest_deck(),
        }
    }

    pub fn get_property(&self, position: usize) -> &Property {
        &self.properties[position]
    }

    pub fn print_board(&self) {
        // TODO: Implement a method to print the board layout
    }
}
fn create_properties() -> [Property; 40] {
    let properties = std::array::from_fn(|i| Property::new(i));
    return properties;
}
