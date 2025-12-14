use crate::action_card::ActionCard;
use crate::action_card::ActionCardType;
use crate::deck::Deck;
use crate::property::*;
use std::cell::RefCell;
use std::rc::Rc;

pub struct Board {
    properties: [Property; 40],
}

impl Board {
    pub fn new() -> Self {
        Board {
            properties: create_properties(),
        }
    }

    pub fn get_property(&self, position: usize) -> &Property {
        &self.properties[position]
    }

    pub fn print_board(&self) {
        // TODO: Implement a method to print the board layout
    }
}

// Generator function to create the standard Monopoly board properties
fn create_properties() -> [Property; 40] {
    let chance_deck = create_chance_deck();
    let community_chest_deck = create_community_chest_deck();
    [
        //  ========== Bottom Row ==========
        Property::new(
            PropertyType::Draw(create_go_deck()),
            "Go",
            0,
            0,
        ),
        Property::new(
            PropertyType::Standard(ColorGroup::Brown),
            "Mediterranean Avenue",
            60,
            2,
        ),
        Property::new(
            PropertyType::Draw(community_chest_deck.clone()),
            "Community Chest",
            0,
            0,
        ),
        Property::new(
            PropertyType::Standard(ColorGroup::Brown),
            "Baltic Avenue",
            60,
            4,
        ),
        Property::new(
            PropertyType::Draw(create_tax_deck("Income Tax", 200)),
            "Income Tax",
            0,
            0,
        ),
        Property::new(PropertyType::Railroad, "Reading Railroad", 200, 25),
        Property::new(
            PropertyType::Standard(ColorGroup::LightBlue),
            "Oriental Avenue",
            100,
            6,
        ),
        Property::new(PropertyType::Draw(chance_deck.clone()), "Chance", 0, 0),
        Property::new(
            PropertyType::Standard(ColorGroup::LightBlue),
            "Vermont Avenue",
            100,
            6,
        ),
        Property::new(
            PropertyType::Standard(ColorGroup::LightBlue),
            "Connecticut Avenue",
            120,
            8,
        ),
        //  ========== Left Column ==========
        Property::new(PropertyType::Jail, "Jail", 0, 0), // Just Visiting
        Property::new(
            PropertyType::Standard(ColorGroup::Pink),
            "St. Charles Place",
            140,
            10,
        ),
        Property::new(PropertyType::Utility, "Electric Company", 150, 0),
        Property::new(
            PropertyType::Standard(ColorGroup::Pink),
            "States Avenue",
            140,
            10,
        ),
        Property::new(
            PropertyType::Standard(ColorGroup::Pink),
            "Virginia Avenue",
            160,
            12,
        ),
        Property::new(PropertyType::Railroad, "Pennsylvania Railroad", 200, 25),
        Property::new(
            PropertyType::Standard(ColorGroup::Orange),
            "St. James Place",
            180,
            14,
        ),
        Property::new(
            PropertyType::Draw(community_chest_deck.clone()),
            "Community Chest",
            0,
            0,
        ),
        Property::new(
            PropertyType::Standard(ColorGroup::Orange),
            "Tennessee Avenue",
            180,
            14,
        ),
        Property::new(
            PropertyType::Standard(ColorGroup::Orange),
            "New York Avenue",
            200,
            16,
        ),
        //  ========== Top Row ==========
        Property::new(PropertyType::FreeParking, "Free Parking", 0, 0),
        Property::new(
            PropertyType::Standard(ColorGroup::Red),
            "Kentucky Avenue",
            220,
            18,
        ),
        Property::new(PropertyType::Draw(chance_deck.clone()), "Chance", 0, 0),
        Property::new(
            PropertyType::Standard(ColorGroup::Red),
            "Indiana Avenue",
            220,
            18,
        ),
        Property::new(
            PropertyType::Standard(ColorGroup::Red),
            "Illinois Avenue",
            240,
            20,
        ),
        Property::new(PropertyType::Railroad, "B&O Railroad", 200, 25),
        Property::new(
            PropertyType::Standard(ColorGroup::Yellow),
            "Atlantic Avenue",
            260,
            22,
        ),
        Property::new(
            PropertyType::Standard(ColorGroup::Yellow),
            "Ventnor Avenue",
            260,
            22,
        ),
        Property::new(PropertyType::Utility, "Water Works", 150, 0),
        Property::new(
            PropertyType::Standard(ColorGroup::Yellow),
            "Marvin Gardens",
            280,
            24,
        ),
        //  ========== Right Column ==========
        Property::new(
            PropertyType::Draw(create_go_to_jail_deck()),
            "Go To Jail",
            0,
            0,
        ),
        Property::new(
            PropertyType::Standard(ColorGroup::Green),
            "Pacific Avenue",
            300,
            26,
        ),
        Property::new(
            PropertyType::Standard(ColorGroup::Green),
            "North Carolina Avenue",
            300,
            26,
        ),
        Property::new(
            PropertyType::Draw(community_chest_deck.clone()),
            "Community Chest",
            0,
            0,
        ),
        Property::new(
            PropertyType::Standard(ColorGroup::Green),
            "Pennsylvania Avenue",
            320,
            28,
        ),
        Property::new(PropertyType::Railroad, "Short Line", 200, 25),
        Property::new(PropertyType::Draw(chance_deck.clone()), "Chance", 0, 0),
        Property::new(
            PropertyType::Standard(ColorGroup::DarkBlue),
            "Park Place",
            350,
            35,
        ),
        Property::new(
            PropertyType::Draw(create_tax_deck("Luxury Tax", 75)),
            "Luxury Tax",
            0,
            0,
        ),
        Property::new(
            PropertyType::Standard(ColorGroup::DarkBlue),
            "Boardwalk",
            400,
            50,
        ),
    ]
}

fn create_chance_deck() -> Rc<RefCell<Deck>> {
    let cards = vec![
        ActionCard::new("Advance to Go", "Collect $200", ActionCardType::Move, 0),
        ActionCard::new(
            "Bank pays you dividend",
            "Collect $50",
            ActionCardType::BankMoney,
            50,
        ),
        // TODO: Add rest of Chance cards here
    ];
    Rc::new(RefCell::new(Deck::new(cards)))
}

fn create_community_chest_deck() -> Rc<RefCell<Deck>> {
    let cards = vec![
        ActionCard::new("Doctor's fees", "Pay $50", ActionCardType::TaxMoney, -50),
        ActionCard::new(
            "From sale of stock",
            "Collect $50",
            ActionCardType::BankMoney,
            50,
        ),
        // TODO: Add rest of Community Chest cards here
    ];
    Rc::new(RefCell::new(Deck::new(cards)))
}

fn create_go_deck() -> Rc<RefCell<Deck>> {
    let cards = vec![ActionCard::new(
        "Collect $200 as you pass Go",
        "You receive $200",
        ActionCardType::BankMoney,
        200,
    )];
    Rc::new(RefCell::new(Deck::new(cards)))
}

fn create_tax_deck(title: &str, amount: i32) -> Rc<RefCell<Deck>> {
    let cards = vec![ActionCard::new(
        title,
        &format!("Pay ${}", amount),
        ActionCardType::TaxMoney,
        -amount,
    )];
    Rc::new(RefCell::new(Deck::new(cards)))
}

fn create_go_to_jail_deck() -> Rc<RefCell<Deck>> {
    let cards = vec![ActionCard::new(
        "Go to Jail",
        "Go directly to Jail. Do not pass Go, do not collect $200",
        ActionCardType::GoToJail,
        0,
    )];
    Rc::new(RefCell::new(Deck::new(cards)))
}
