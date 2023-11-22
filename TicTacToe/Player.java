import java.util.Scanner;

public class Player {
  private int symbol;
  private Scanner scanner;
  private Game thisGame;

  /** 1 is X, 2 is O */
  public Player(int symbol, Game game) {
    this.symbol = symbol;
    this.thisGame = game;
    scanner = new Scanner(System.in);
  }

  public int getSymbol() {
    return symbol;
  }

  public char getSymbolChar() {
    return symbol == 1 ? 'X' : 'O';
  }

  public int[] getMove() {
    System.out.print(getSymbolChar() + ": Enter a row number and collum number: ");
    int input = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]", ""));
    int[] numbers = { input / 10, input % 10 };
    if (numbers.length != 2) {
      System.out.println("Invalid input. Ex: \"1 1\". Try again.");
      return getMove();
    }
    int row = numbers[0] - 1;
    int col = numbers[1] - 1;
    if (row < 0 || row > 2 || col < 0 || col > 2) {
      System.out.println("Invalid row or column number. Try again.");
      return getMove();
    }

    if (thisGame.board.getCell(new int[] { row, col }) != 0) {
      System.out.println("That spot is already taken. Try again.");
      return getMove();
    }
    return new int[] { row, col };
  }
}