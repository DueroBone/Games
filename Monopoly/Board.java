public class Board {
  Property[] props = new Property[40];
  MonopolyGame game;
  ActionsDeck chance = new ActionsDeck("Chance");
  ActionsDeck communityChest = new ActionsDeck("Community Chest");

  public Board() {
    props[0] = new SpecialProperty("Go", this);
    props[1] = new Property("Mediterranean Avenue", 60, 2, 30, this);
    props[2] = new SpecialProperty("Community Chest", this);
    props[3] = new Property("Baltic Avenue", 60, 4, 30, this);
    props[4] = new Property("Income Tax", 0, 0, 0, this);
    props[5] = new Property("Reading Railroad", 200, 25, 100, this);
    props[6] = new Property("Oriental Avenue", 100, 6, 50, this);
    props[7] = new SpecialProperty("Chance", this);
    props[8] = new Property("Vermont Avenue", 100, 6, 50, this);
    props[9] = new Property("Connecticut Avenue", 120, 8, 60, this);
    props[10] = new SpecialProperty("Jail", this);
    props[11] = new Property("St. Charles Place", 140, 10, 70, this);
    props[12] = new Property("Electric Company", 150, 0, 75, this);
    props[13] = new Property("States Avenue", 140, 10, 70, this);
    props[14] = new Property("Virginia Avenue", 160, 12, 80, this);
    props[15] = new Property("Pennsylvania Railroad", 200, 25, 100, this);
    props[16] = new Property("St. James Place", 180, 14, 90, this);
    props[17] = new SpecialProperty("Community Chest", this);
    props[18] = new Property("Tennessee Avenue", 180, 14, 90, this);
    props[19] = new Property("New York Avenue", 200, 16, 100, this);
    props[20] = new SpecialProperty("Free Parking", this);
    props[21] = new Property("Kentucky Avenue", 220, 18, 110, this);
    props[22] = new SpecialProperty("Chance", this);
    props[23] = new Property("Indiana Avenue", 220, 18, 110, this);
    props[24] = new Property("Illinois Avenue", 240, 20, 120, this);
    props[25] = new Property("B. & O. Railroad", 200, 25, 100, this);
    props[26] = new Property("Atlantic Avenue", 260, 22, 130, this);
    props[27] = new Property("Ventnor Avenue", 260, 22, 130, this);
    props[28] = new Property("Water Works", 150, 0, 75, this);
    props[29] = new Property("Marvin Gardens", 280, 24, 140, this);
    props[30] = new SpecialProperty("Go To Jail", this);
    props[31] = new Property("Pacific Avenue", 300, 26, 150, this);
    props[32] = new Property("North Carolina Avenue", 300, 26, 150, this);
    props[33] = new SpecialProperty("Community Chest", this);
    props[34] = new Property("Pennsylvania Avenue", 320, 28, 160, this);
    props[35] = new Property("Short Line", 200, 25, 100, this);
    props[36] = new SpecialProperty("Chance", this);
    props[37] = new Property("Park Place", 350, 35, 175, this);
    props[38] = new Property("Luxury Tax", 0, 0, 0, this);
    props[39] = new Property("Boardwalk", 400, 50, 200, this);
  }

  public void printBoard() {
    for (Property prop : props) {
      if (prop.owner == null) {
        System.out.print(" ");
      } else {
        System.out.print(prop.owner.name.charAt(0));
      }
      System.out.print(" ");
    }
    System.out.println();
  }
}
