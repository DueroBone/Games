public class Game {
  public Board board;
  private Player[] players;
  private Player currentPlayer;
  private GameState currentState;
  private final boolean Verbose = !TicTacToe.SilentMode;

  public Game() {
    board = new Board();
    players = new Player[2];
    players[0] = new Player(1, this);
    players[1] = new Player(2, this);
    currentState = GameState.PLAYING;
  }

  public void play() {
    currentPlayer = players[0];
    while (currentState == GameState.PLAYING) {
      board.printBoard();
      int[] move = currentPlayer.getMove();
      board.updateBoard(move, currentPlayer.getSymbol());
      int winState = board.checkForWin();
      if (winState > 0) {
        currentState = GameState.WON;
      } else if (winState == -1) {
        currentState = GameState.DRAW;
      } else {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
      }
    }

    if (Verbose) {
      board.printBoard();
      if (currentState == GameState.WON) {
        System.out.println(currentPlayer.getSymbolChar() + " won!");
      } else if (currentState == GameState.DRAW) {
        System.out.println("It's a draw!");
      }
    }
  }

  public void setPlayer(int index, Player player) {
    players[index] = player;
  }
}