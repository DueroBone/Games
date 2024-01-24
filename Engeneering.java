import java.util.Scanner;

public class Engeneering {
  public static void main(String[] args) {
    double length, flowRate, constant, diameter, frictionLoss = 0;
    int numDecimals = 3;
    Scanner input = new Scanner(System.in);
    System.out.print("Pipe length (ft): ");
    length = input.nextDouble();
    System.out.print("Flow rate (gpm): ");
    flowRate = input.nextDouble();
    System.out.print("Constant (idk): ");
    constant = input.nextDouble();
    System.out.print("Diameter (in): ");
    diameter = input.nextDouble();

    frictionLoss = HazenWilliamsFormula(length, flowRate, constant, diameter);
    double loss = (double) ((int) (frictionLoss * Math.pow(10, numDecimals))) / Math.pow(10, numDecimals);
    System.out.println("Friction loss: " + loss + " ft");
  }

  static double HazenWilliamsFormula(double length, double flowRate, double constant, double diameter) {
    return (10.44 * length * Math.pow(flowRate, 1.85)) / (Math.pow(constant, 1.85) * Math.pow(diameter, 4.8655));
  }
}
