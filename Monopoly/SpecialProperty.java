public class SpecialProperty extends Property {
  boolean isChance = false;
  boolean isCommunityChest = false;
  boolean isJail = false;

  public SpecialProperty(String name, Board board) {
    super(name, 0, 0, 0, board);
    if (name == "Chance") {
      isChance = true;
    } else if (name == "Community Chest") {
      isCommunityChest = false;
    } else if (name == "Jail") {
      isJail = true;
    } else if (name == "Free Parking") {
      // do nothing
    } else if (name == "Go To Jail") {
      // do nothing
    } else if (name == "Go") {
      // do nothing
    } else if (name == "Luxury Tax") {
      // do nothing
    } else if (name == "Income Tax") {
      // do nothing
    } else {
      System.out.println("ERROR: SpecialProperty constructor: unknown name: " + name);}
    }

  @Override
  public void payRent(Player player) {
    if (isChance) {
      board.chance.drawnBy(player);
    } else {
      board.communityChest.drawnBy(player);
    }
  }
}
