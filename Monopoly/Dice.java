public class Dice {
  int value;
  boolean isDoubles;

  public void roll() {
    int dice1 = (int) (Math.random() * 6) + 1;
    int dice2 = (int) (Math.random() * 6) + 1;
    value = dice1 + dice2;
    isDoubles = dice1 == dice2;
  }
}
