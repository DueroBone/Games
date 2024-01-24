public class Player {
  String name;
  int position = 0;
  int money = 1500;

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
    if (money >= property.price) {
      money -= property.price;
      property.transferOwnership(this);
    }
  }
}
