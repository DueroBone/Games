public class Player {
  String name;
  int position = 0;
  int money = 1500;
  boolean inJail;
  boolean getOutOfJailCard;

  public Player(String name) {
    this.name = name;
  }

  public void move(int spaces) {
    position += spaces;
    if (position >= 40) {
      position -= 40;
      money += 200;
    }
  }

  public void buyProperty(Property property) {
    if (money >= property.price && property.owner == Property.nullPlayer && property instanceof SpecialProperty == false
        && property.owner != this) {
      money -= property.price;
      property.transferOwnership(this);
    } else if (money < property.price) {
      System.out.println(name + " don't have enough money to buy " + property.name);
    } else {
      System.out.println(property.name + " is already owned by " + property.owner.name);
    }
  }
}
