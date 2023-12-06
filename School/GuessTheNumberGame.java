package School;
public class GuessTheNumberGame {
  public static void main(String[] args) {
    int number = (int) (Math.random() * 101);
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    System.out.println("Guess a magic number between 0 and 100");
    int guess = -1;
    int guessRemaining = 10;
    while (guess != number && guessRemaining-- > 0) {
      System.out.print("\nEnter your guess: ");
      guess = scanner.nextInt();
      if (guess == number) {
        System.out.print("Yes, the number is " + number);
      } else if (guess > number) {
        System.out.print("Your guess is too high");
      } else {
        System.out.print("Your guess is too low");
      }
      System.out.println(". You have " + guessRemaining + " guess remaining.");
    }
    if (guessRemaining == 0) {
      System.out.println("The correct answer is " + number + ". You have no guess remaining. You lose.");
    } else {
      System.out.println("You had " + guessRemaining + " guess remaining. You win.");
    }
    scanner.close();
  }
}
