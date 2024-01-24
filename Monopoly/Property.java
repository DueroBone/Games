public class Property {
  String name;
  int price;
  int rent;
  int mortgageValue;
  boolean isMortgaged = false;
  Player owner = null;

  public Property(String name, int price, int rent, int mortgageValue) {
    this.name = name;
    this.price = price;
    this.rent = rent;
    this.mortgageValue = mortgageValue;
  }

  public void payRent(Player player) {
    if (owner != null && owner != player) {
      player.money -= rent;
      owner.money += rent;
    }
  }

  public void mortgage() {
    isMortgaged = true;
    owner.money += mortgageValue;
  }

  public void unmortgage() {
    isMortgaged = false;
    owner.money -= mortgageValue;
  }

  public void transferOwnership(Player newOwner) {
    owner = newOwner;
  }
}
