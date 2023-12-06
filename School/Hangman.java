package School;

public class Hangman {
  public static final String[] words = { "write", "that", "program", "java", "is", "fun" };
  public static final String[] hangmanStates = { "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========", "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========", "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========", "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========", "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========", "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========", "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n=========" };

  public static void main(String[] args) {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    String word = words[(int) (Math.random() * words.length)];
    char[] wordState = new char[word.length()];
    for (int i = 0; i < wordState.length; i++) {
      wordState[i] = '*';
    }
    int wrongGuesses = 0;
    System.out.println(hangmanStates[0]);
    while (wrongGuesses < 6) {
      System.out.print("(Guess) Enter a letter in word ");
      printWordState(wordState);
      System.out.print(" > ");
      char guess = scanner.nextLine().charAt(0);
      if (word.indexOf(guess) == -1) {
        System.out.println(guess + " is not in the word");
        wrongGuesses++;
        System.out.println(hangmanStates[wrongGuesses]);
      } else {
        for (int i = 0; i < word.length(); i++) {
          if (word.charAt(i) == guess) {
            wordState[i] = guess;
          }
        }
      }
      if (word.equals(new String(wordState))) {
        System.out.println("The word is \"" + word + "\". You win.");
        break;
      }
    }
    if (wrongGuesses == 6) {
      System.out.println("You lose. The word was " + word);
    }
    scanner.close();
  }

  public static void printWordState(char[] wordState) {
    for (int i = 0; i < wordState.length; i++) {
      System.out.print(wordState[i]);
    }
  }
}
