public class SpecialProperty extends Property {
  SpecialPropertyType type;

  public SpecialProperty(String name, Board board) {
    super(name, 0, 0, 0, board);
    owner = Property.nullPlayer;
    switch (name) {
      case "Chance":
        type = SpecialPropertyType.CHANCE;
        break;
      case "Community Chest":
        type = SpecialPropertyType.COMMUNITY_CHEST;
        break;
      case "Jail":
        type = SpecialPropertyType.JAIL;
        break;
      case "Free Parking":
        type = SpecialPropertyType.FREE_PARKING;
        break;
      case "Go To Jail":
        type = SpecialPropertyType.GO_TO_JAIL;
        break;
      case "Go":
        type = SpecialPropertyType.GO;
        break;
      case "Luxury Tax":
        type = SpecialPropertyType.LUXURY_TAX;
        break;
      case "Income Tax":
        type = SpecialPropertyType.INCOME_TAX;
        break;
      default:
        throw new IllegalArgumentException("Invalid special property name");
    }
  }

  @Override
  public void payRent(Player player) {
    if (type == SpecialPropertyType.CHANCE) {
      board.chance.drawnBy(player);
    } else if (type == SpecialPropertyType.COMMUNITY_CHEST) {
      board.communityChest.drawnBy(player);
    } else if (type == SpecialPropertyType.JAIL) {
      System.out.println(player.name + " is just visiting");
    } else if (type == SpecialPropertyType.FREE_PARKING) {
      player.money += 50;
      System.out.println(player.name + " landed on Free Parking");
    } else if (type == SpecialPropertyType.GO_TO_JAIL) {
      player.inJail = true;
      player.position = 10;
      System.out.println(player.name + " landed on Go To Jail");
    } else if (type == SpecialPropertyType.GO) {
      System.out.println(player.name + " passed Go");
    } else {
      System.out.println(player.name + " landed on " + name + " NOT IMPLEMENTED");
    }
  }

  @Override
  public void transferOwnership(Player newOwner) {
  }

  public static enum SpecialPropertyType {
    CHANCE, COMMUNITY_CHEST, JAIL, FREE_PARKING, GO_TO_JAIL, GO, LUXURY_TAX, INCOME_TAX
  }
}
