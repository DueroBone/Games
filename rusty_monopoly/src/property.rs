use crate::deck::Deck;
use crate::player::Player;
use std::cell::RefCell;
use std::rc::Rc;

pub struct Property {
    property_type: PropertyType,
    name: String,
    price: u32,
    rent: u32,
    owner: Option<Player>,
    num_houses: u8,
}

impl Property {
    pub fn new(property_type: PropertyType, name: &str, price: u32, rent: u32) -> Self {
        Property {
            property_type,
            name: name.to_string(),
            price,
            rent,
            owner: None,
            num_houses: 0,
        }
    }

    pub fn buy(&mut self, player: Player) {
        self.owner = Some(player);
    }

    pub fn get_owner(&self) -> Option<&Player> {
        self.owner.as_ref()
    }
}

pub enum ColorGroup {
    Brown,
    LightBlue,
    Pink,
    Orange,
    Red,
    Yellow,
    Green,
    DarkBlue,
}

pub enum PropertyType {
    Standard(ColorGroup),
    Railroad,
    Utility,
    Draw(Rc<RefCell<Deck>>),
    Jail,
    FreeParking,
}
