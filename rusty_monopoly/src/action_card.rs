pub struct ActionCard {
    name: String,
    description: String,
    card_type: ActionCardType,
    amount: i32, // Not used for GetOutOfJailFree cards
}

impl ActionCard {
    pub fn new(name: &str, description: &str, card_type: ActionCardType, amount: i32) -> Self {
        ActionCard {
            name: name.to_string(),
            description: description.to_string(),
            card_type,
            amount,
        }
    }

    pub fn clone(&self) -> Self {
        ActionCard {
            name: self.name.clone(),
            description: self.description.clone(),
            card_type: self.card_type.clone(),
            amount: self.amount,
        }
    }
}

#[derive(Clone)]
pub enum ActionCardType {
    BankMoney,
    TaxMoney,
    AllPlayersMoney,
    Move,
    GetOutOfJailFree,
    GoToJail,
}
