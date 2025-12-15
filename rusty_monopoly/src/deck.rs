use crate::action_card::ActionCard;
use crate::action_card::ActionCardType;

pub struct Deck {
    cards: Vec<ActionCard>,
}

impl Deck {
    pub fn new(cards: Vec<ActionCard>) -> Self {
        Deck { cards }
    }

    pub fn draw(&mut self) -> ActionCard {
        let card = self.cards.pop().expect("Deck is empty");
        self.cards.insert(0, card.clone());
        return card;
    }
}

pub fn create_chance_deck() -> Deck {
    let cards = vec![
        ActionCard::new("Advance to Go", "Collect $200", ActionCardType::Move, 0),
        ActionCard::new(
            "Advance to Illinois Ave",
            "Move to Illinois Ave",
            ActionCardType::Move,
            24,
        ),
        ActionCard::new(
            "Advance to St. Charles Place",
            "Move to St. Charles Place",
            ActionCardType::Move,
            11,
        ),
        ActionCard::new(
            "Advance token to nearest Utility",
            "If unowned, you may buy it. If owned, throw dice and pay owner a total ten times amount thrown.",
            ActionCardType::MoveNearestUtility,
            0,
        ),
        ActionCard::new(
            "Advance token to the nearest Railroad",
            "Pay owner twice the rental to which they are otherwise entitled. If Railroad is unowned, you may buy it.",
            ActionCardType::MoveNearestRailroad,
            0,
        ),
        ActionCard::new(
            "Bank pays you dividend",
            "Collect $50",
            ActionCardType::BankMoney,
            50,
        ),
        ActionCard::new(
            "Get Out of Jail Free",
            "This card may be kept until needed, or traded/sold.",
            ActionCardType::GetOutOfJailFree,
            0,
        ),
        ActionCard::new(
            "Go Back 3 Spaces",
            "Move your token back 3 spaces.",
            ActionCardType::Move,
            -3,
        ),
        ActionCard::new(
            "Go to Jail",
            "Go directly to Jail. Do not pass Go, do not collect $200",
            ActionCardType::GoToJail,
            0,
        ),
        ActionCard::new(
            "Make general repairs on all your property",
            "For each house pay $25, for each hotel $100",
            ActionCardType::Repairs,
            0,
        ),
        ActionCard::new(
            "Pay poor tax of $15",
            "Pay $15",
            ActionCardType::TaxMoney,
            -15,
        ),
        ActionCard::new(
            "Take a trip to Reading Railroad",
            "Advance token to Reading Railroad",
            ActionCardType::Move,
            5,
        ),
        ActionCard::new(
            "Take a walk on the Boardwalk",
            "Advance token to Boardwalk",
            ActionCardType::Move,
            39,
        ),
        ActionCard::new(
            "You have been elected Chairman of the Board",
            "Pay each player $50",
            ActionCardType::AllPlayersMoney,
            -50,
        ),
        ActionCard::new(
            "Your building loan matures",
            "Collect $150",
            ActionCardType::BankMoney,
            150,
        ),
    ];
    Deck::new(cards)
}

pub fn create_community_chest_deck() -> Deck {
    let cards = vec![
        ActionCard::new("Advance to Go", "Collect $200", ActionCardType::Move, 0),
        ActionCard::new(
            "Bank error in your favor",
            "Collect $200",
            ActionCardType::BankMoney,
            200,
        ),
        ActionCard::new("Doctor's fees", "Pay $50", ActionCardType::TaxMoney, -50),
        ActionCard::new(
            "From sale of stock you get $50",
            "Collect $50",
            ActionCardType::BankMoney,
            50,
        ),
        ActionCard::new(
            "Get Out of Jail Free",
            "This card may be kept until needed, or traded/sold.",
            ActionCardType::GetOutOfJailFree,
            0,
        ),
        ActionCard::new(
            "Go to Jail",
            "Go directly to Jail. Do not pass Go, do not collect $200",
            ActionCardType::GoToJail,
            0,
        ),
        ActionCard::new(
            "Grand Opera Night",
            "Collect $50 from every player for opening night seats",
            ActionCardType::AllPlayersMoney,
            50,
        ),
        ActionCard::new(
            "Holiday Fund matures",
            "Collect $100",
            ActionCardType::BankMoney,
            100,
        ),
        ActionCard::new(
            "Income tax refund",
            "Collect $20",
            ActionCardType::BankMoney,
            20,
        ),
        ActionCard::new(
            "It is your birthday",
            "Collect $10 from every player",
            ActionCardType::AllPlayersMoney,
            10,
        ),
        ActionCard::new(
            "Life insurance matures",
            "Collect $100",
            ActionCardType::BankMoney,
            100,
        ),
        ActionCard::new("Hospital Fees", "Pay $100", ActionCardType::TaxMoney, -100),
        ActionCard::new("School fees", "Pay $50", ActionCardType::TaxMoney, -50),
        ActionCard::new(
            "Receive $25 consultancy fee",
            "Collect $25",
            ActionCardType::BankMoney,
            25,
        ),
        ActionCard::new(
            "You are assessed for street repairs",
            "$40 per house. $115 per hotel",
            ActionCardType::Repairs,
            0,
        ),
        ActionCard::new(
            "You have won second prize in a beauty contest",
            "Collect $10",
            ActionCardType::BankMoney,
            10,
        ),
        ActionCard::new(
            "You inherit $100",
            "Collect $100",
            ActionCardType::BankMoney,
            100,
        ),
    ];
    Deck::new(cards)
}

pub fn create_go_deck() -> Deck {
    let cards = vec![ActionCard::new(
        "Collect $200 as you pass Go",
        "You receive $200",
        ActionCardType::BankMoney,
        200,
    )];
    Deck::new(cards)
}

pub fn create_tax_deck(title: &str, amount: i32) -> Deck {
    let cards = vec![ActionCard::new(
        title,
        &format!("Pay ${}", amount),
        ActionCardType::TaxMoney,
        -amount,
    )];
    Deck::new(cards)
}

pub fn create_go_to_jail_deck() -> Deck {
    let cards = vec![ActionCard::new(
        "Go to Jail",
        "Go directly to Jail. Do not pass Go, do not collect $200",
        ActionCardType::GoToJail,
        0,
    )];
    Deck::new(cards)
}
