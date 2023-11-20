import java.util.Scanner;

public class Player {
  private String symbol;
  private Scanner scanner;
  private Game m_game;

  public Player(String symbol, Game game) {
    this.symbol = symbol;
    this.m_game = game;
    scanner = new Scanner(System.in);
  }

  public String getSymbol() {
    return symbol;
  }

  public int[] getMove() {
    // TODO
    // 1. Ask the user for a row and column number
    // 2. Return an array of two integers, the first being the row number and the
    // second being the column number
    // 3. If the user enters an invalid row or column number, ask them to enter a
    // valid one
    System.out.print(symbol + ": Enter a row number and collum number: ");
    String input = scanner.nextLine();
    String[] numbers = input.strip().split(" ");
    if (numbers.length != 2) {
      System.out.println("Invalid input. Ex: \"1 1\". Try again.");
      return getMove();
    }
    int row = Integer.parseInt(numbers[0]) - 1;
    int col = Integer.parseInt(numbers[1]) - 1;
    if (row < 0 || row > 2 || col < 0 || col > 2) {
      System.out.println("Invalid row or column number. Try again.");
      return getMove();
    }

    if (m_game.board.getCell(new int[] { row, col }) != null) {
      System.out.println("That spot is already taken. Try again.");
      return getMove();
    }
    return new int[] { row, col };
  }
}