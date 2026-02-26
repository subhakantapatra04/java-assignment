import java.util.*;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int secretNumber = random.nextInt(1000) + 1;
        int maxAttempts = 10;
        int attempts = 0;
        boolean isGuessed = false;
        System.out.println("Welcome to the Number Guessing Game");
        System.out.println("I have generated a number between 1 and 1000.");
        System.out.println("You have " + maxAttempts + " attempts to guess");
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess:");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number");
                sc.next();
                continue;
            }
            int guess = sc.nextInt();
            attempts++;

            if (guess < 1 || guess > 1000) {
                System.out.println("⚠ Please guess a number between 1 and 100.\n");
                continue;
            }

            if (guess > secretNumber) {
                System.out.println("Very high");
            } else if (guess < secretNumber) {
                System.out.println("Very low");
            } else {
                System.out.println("You guessed the number in " + attempts + " attempts");
                isGuessed = true;
                break;
            }
        }
        if (!isGuessed) {
            System.out.println("Game Over");
            System.out.println("The correct number was: " + secretNumber);
        }
    }
}
