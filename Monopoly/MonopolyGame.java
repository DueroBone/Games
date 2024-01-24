public class MonopolyGame {
  Player[] players = new Player[4];
  Dice dice = new Dice();
  Board board = new Board();
  int turn = 0;

  public MonopolyGame() {
    players[0] = new Player("Alice");
    players[1] = new Player("Bob");
    players[2] = new Player("Charlie");
    players[3] = new Player("David");
  }
  public void playGame() {
    while (true) {
      Player player = players[turn % players.length];
      dice.roll();
      player.move(dice.value);
      Property property = board.props[player.position];
      player.buyProperty(property);
      if (dice.isDoubles) {
        turn--;
      }
      turn++;
      board.printBoard();
    }
  }
}
