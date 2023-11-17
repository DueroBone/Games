public class Game {
  private Board board;
  private Player[] players;
  private Player currentPlayer;
  private GameState currentState;

  public Game() {
    board = new Board();
    players = new Player[2];
    players[0] = new Player("Player 1", "X");
    players[1] = new Player("Player 2", "O");
    currentPlayer = players[0];
    currentState = GameState.PLAYING;
  }

  public void play() {
    while (currentState == GameState.PLAYING) {
      board.printBoard();
      int[] move = currentPlayer.getMove();
      board.updateBoard(move, currentPlayer.symbol);
      if (board.checkForWin()) {
        currentState = GameState.WON;
      } else if (board.checkForDraw()) {
        currentState = GameState.DRAW;
      } else {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
      }
    }

    board.printBoard();
    if (currentState == GameState.WON) {
      System.out.println(currentPlayer.name + " won!");
    } else if (currentState == GameState.DRAW) {
      System.out.println("It's a draw!");
    }
  }
}