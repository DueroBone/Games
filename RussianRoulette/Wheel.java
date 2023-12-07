package RussianRoulette;

public class Wheel {
  int bulletPosition;

  public Wheel() {
    spin();
  }

  public boolean fire() {
    bulletPosition--;
    if (bulletPosition == -1) {
      reset();
      return true;
    }
    return false;
  }

  private void reset() {
    bulletPosition = (int) (Math.random() * 6);
  }

  public void spin() {
    reset();
    int random1 = (int) (Math.random() * 6) + 2; // repeats
    for (int i = 0; i < random1; i++) {
      System.out.print("Spinning");
      for (int j = 0; j < 6; j++) {
        System.out.print(".");
        sleep(50);
      }
      System.out.print("\r                    \r");
    }
    System.out.println();
  }

  private void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
