import java.util.ArrayList;

public class ActionsDeck {
  ArrayList<Action> actions = new ArrayList<Action>();
  Board board;

  public ActionsDeck(String name) {
    if (name == "Chance") {
      actions.add(new Action("Advance to Go").asPositionChange(0, true, false));
      actions.add(new Action("Advance to Illinois Ave").asPositionChange(24, true, false));
      actions.add(new Action("Advance to St. Charles Place").asPositionChange(11, true, false));
      actions.add(new Action("Advance token to nearest Utility").asPositionChange(0, true, false));
      actions.add(new Action("Advance token to nearest Railroad").asPositionChange(0, true, false));
      actions.add(new Action("Bank pays you dividend of $50").asMoneyChange(50));
      actions.add(new Action("Get out of Jail free").asGetOutOfJail(true));
      actions.add(new Action("Go back 3 spaces").asPositionChange(-3, false, false));
      actions.add(new Action("Go to Jail").asPositionChange(10, false, true));
      actions.add(new Action("Make general repairs on all your property").asStreetRepairs(25, 100));
      actions.add(new Action("Pay poor tax of $15").asMoneyChange(-15));
      actions.add(new Action("Take a trip to Reading Railroad").asPositionChange(5, true, false));
      actions.add(new Action("Take a walk on the Boardwalk").asPositionChange(39, true, false));
      actions.add(new Action("You have been elected Chairman of the Board").asMoneyChange(50));
      actions.add(new Action("Your building loan matures").asMoneyChange(150));
    } else if (name == "Community Chest") {
      actions.add(new Action("Advance to Go").asPositionChange(0, true, false));
      actions.add(new Action("Bank error in your favor").asMoneyChange(200));
      actions.add(new Action("Doctor's fees").asMoneyChange(-50));
      actions.add(new Action("Get out of Jail free").asGetOutOfJail(true));
      actions.add(new Action("Go to Jail").asPositionChange(10, false, true));
      actions.add(new Action("Grand Opera Night").asMoneyChange(50));
      actions.add(new Action("Holiday Fund matures").asMoneyChange(100));
      actions.add(new Action("Income tax refund").asMoneyChange(20));
      actions.add(new Action("It is your birthday").asMoneyChange(10));
      actions.add(new Action("Life insurance matures").asMoneyChange(100));
      actions.add(new Action("Pay hospital fees of $100").asMoneyChange(-100));
      actions.add(new Action("Pay school fees of $150").asMoneyChange(-150));
      actions.add(new Action("Receive $25 consultancy fee").asMoneyChange(25));
      actions.add(new Action("You are assessed for street repairs").asStreetRepairs(40, 115));
      actions.add(new Action("You have won second prize in a beauty contest").asMoneyChange(10));
      actions.add(new Action("You inherit $100").asMoneyChange(100));
    }
  }

  public void drawnBy(Player player) {
    Action action = actions.remove(0);
    action.drawnBy(player);
    actions.add(action);
  }

  class Action {
    String comment;
    int moneyChange;
    int positionChange;
    boolean goToPosition;
    boolean goToJail;
    boolean getOutOfJail;
    boolean payEachPlayer;
    int[] houseHotelPrice;

    public Action(String comment) {
      this.comment = comment;
    }

    public Action asMoneyChange(int moneyChange) {
      this.moneyChange = moneyChange;
      return this;
    }

    public Action asPositionChange(int positionChange, boolean goToPosition, boolean goToJail) {
      this.positionChange = positionChange;
      this.goToPosition = goToPosition;
      this.goToJail = goToJail;
      return this;
    }

    public Action asGetOutOfJail(boolean getOutOfJail) {
      this.getOutOfJail = getOutOfJail;
      return this;
    }

    public Action asPayEachPlayer(int moneyChange) {
      this.moneyChange = moneyChange;
      this.payEachPlayer = true;
      return this;
    }

    public Action asStreetRepairs(int housePrice, int hotelPrice) {
      this.houseHotelPrice = new int[] { housePrice, hotelPrice };
      return this;
    }

    public void drawnBy(Player player) {
      if (moneyChange != 0) {
        player.money += moneyChange;
      }

      if (positionChange != 0) {
        if (goToPosition) {
          player.position = positionChange;
        } else if (goToJail) {
          player.position = positionChange;
          player.inJail = true;
        } else {
          player.move(positionChange);
        }
      }

      if (getOutOfJail) {
        player.getOutOfJailCard = true;
      }

      if (payEachPlayer) {
        for (Player otherPlayer : board.game.players) {
          if (otherPlayer != player) {
            otherPlayer.money += moneyChange;
            player.money -= moneyChange;
          }
        }
      }

      if (houseHotelPrice != null) {
        int total = 0;
        for (Property prop : board.properties) {
          if (prop.owner == null) {
            continue;
          }

          if (prop.owner == player) {
            total += prop.numHouses * houseHotelPrice[0];
            total += prop.numHotels * houseHotelPrice[1];
          }
        }
        player.money -= total;
      }
    }
  }
}
