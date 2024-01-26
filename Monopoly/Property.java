public class Property {
  String name;
  int price;
  int rent;
  int mortgageValue;
  boolean isMortgaged = false;
  Player owner = null;
  Board board;
  int numHotels = 0;
  int numHouses = 0;

  public Property(String name, int price, int rent, int mortgageValue, Board board) {
    this.name = name;
    this.price = price;
    this.rent = rent;
    this.mortgageValue = mortgageValue;
    this.board = board;
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
