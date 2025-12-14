use crate::action_card::ActionCard;

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