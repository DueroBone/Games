public class Game {
  public Board board;
  private Player[] players;
  private Player currentPlayer;
  private GameState currentState;

  public Game() {
    board = new Board();
    players = new Player[2];
    players[0] = new Player(1, this);
    // players[1] = new Player(2, this);
    players[1] = new ComputerPlayer(2, this);
    currentPlayer = players[0];
    currentState = GameState.PLAYING;
  }

  public Game(Player player1, Player player2) {
    this();
    players[0] = player1;
    players[1] = player2;
  }

  public void play() {
    while (currentState == GameState.PLAYING) {
      board.printBoard();
      int[] move = currentPlayer.getMove();
      board.updateBoard(move, currentPlayer.getSymbol());
      if (board.checkForWin() != 0) {
        currentState = GameState.WON;
      } else if (board.checkForDraw()) {
        currentState = GameState.DRAW;
      } else {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
      }
    }

    board.printBoard();
    if (currentState == GameState.WON) {
      System.out.println(currentPlayer.getSymbolChar() + " won!");
    } else if (currentState == GameState.DRAW) {
      System.out.println("It's a draw!");
    }
  }
}