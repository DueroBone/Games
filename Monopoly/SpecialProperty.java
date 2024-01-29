public class SpecialProperty extends Property {
  SpecialPropertyType type;

  public SpecialProperty(String name, Board board) {
    super(name, 0, 0, 0, board);
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
    } else {
      board.communityChest.drawnBy(player);
    }
  }

  public static enum SpecialPropertyType {
    CHANCE, COMMUNITY_CHEST, JAIL, FREE_PARKING, GO_TO_JAIL, GO, LUXURY_TAX, INCOME_TAX
  }
}
