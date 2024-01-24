public class Board {
  Property[] props = new Property[40];

  public Board() {
    props[0] = new Property("Go", 0, 0, 0);
    props[1] = new Property("Mediterranean Avenue", 60, 2, 30);
    props[2] = new Property("Community Chest", 0, 0, 0); // TODO
    props[3] = new Property("Baltic Avenue", 60, 4, 30);
    props[4] = new Property("Income Tax", 0, 0, 0);
    props[5] = new Property("Reading Railroad", 200, 25, 100);
    props[6] = new Property("Oriental Avenue", 100, 6, 50);
    props[7] = new Property("Chance", 0, 0, 0); // TODO
    props[8] = new Property("Vermont Avenue", 100, 6, 50);
    props[9] = new Property("Connecticut Avenue", 120, 8, 60);
    props[10] = new Property("Jail", 0, 0, 0);
    props[11] = new Property("St. Charles Place", 140, 10, 70);
    props[12] = new Property("Electric Company", 150, 0, 75);
    props[13] = new Property("States Avenue", 140, 10, 70);
    props[14] = new Property("Virginia Avenue", 160, 12, 80);
    props[15] = new Property("Pennsylvania Railroad", 200, 25, 100);
    props[16] = new Property("St. James Place", 180, 14, 90);
    props[17] = new Property("Community Chest", 0, 0,  0); // TODO
    props[18] = new Property("Tennessee Avenue", 180, 14, 90);
    props[19] = new Property("New York Avenue", 200, 16, 100);
    props[20] = new Property("Free Parking", 0, 0, 0); // TODO
    props[21] = new Property("Kentucky Avenue", 220, 18, 110);
    props[22] = new Property("Chance", 0, 0, 0); // TODO
    props[23] = new Property("Indiana Avenue", 220, 18, 110);
    props[24] = new Property("Illinois Avenue", 240, 20, 120);
    props[25] = new Property("B. & O. Railroad", 200, 25, 100);
    props[26] = new Property("Atlantic Avenue", 260, 22, 130);
    props[27] = new Property("Ventnor Avenue", 260, 22, 130);
    props[28] = new Property("Water Works", 150, 0, 75);
    props[29] = new Property("Marvin Gardens", 280, 24, 140);
    props[30] = new Property("Go to Jail", 0, 0, 0);
    props[31] = new Property("Pacific Avenue", 300, 26, 150);
    props[32] = new Property("North Carolina Avenue", 300, 26, 150);
    props[33] = new Property("Community Chest", 0, 0, 0); //
    props[34] = new Property("Pennsylvania Avenue", 320, 28, 160);
    props[35] = new Property("Short Line", 200, 25, 100);
    props[36] = new Property("Chance", 0, 0, 0); // TODO
    props[37] = new Property("Park Place", 350, 35, 175);
    props[38] = new Property("Luxury Tax", 0, 0, 0);
    props[39] = new Property("Boardwalk", 400, 50, 200);
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
