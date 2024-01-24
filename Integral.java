public class Integral {
  public static void main(String[] args) {
    int steps = 1;
    for (int i = 1; i < 16; i++) {
      System.out.println("Layman's method with " + steps + " steps: " + laymans(steps, -2, 2));
      steps *= 2;
    }
  }

  static double laymans(int numSteps, double lowerBound, double upperBound) {
    double stepSize = (upperBound - lowerBound) / numSteps;
    double sum = 0;
    for (double x = lowerBound; x < upperBound; x += stepSize) {
      sum += stepSize * f(x);
    }
    return sum;
  }

  static double f(double x) {
    return x * x;
  }
}
