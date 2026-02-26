import java.util.*;

public class Factorial {
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Factorial Calculator");
        System.out.print("Enter a number: ");
        if (!sc.hasNextInt()) {
            System.out.println("Please enter an integer");
            return;
        }
        int number = sc.nextInt();
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long result = factorial(number);
            System.out.println("Factorial of " + number + " is: " + result);
        }
    }
}