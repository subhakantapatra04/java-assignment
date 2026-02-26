import java.util.Scanner;

public class Calculator {
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static Double divide(double a, double b) {
        if (b == 0) {
            return null;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Basic Calculator");
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        System.out.println("\nChoose operation:");
        System.out.println("1  Addition");
        System.out.println("2  Subtraction");
        System.out.println("3  Multiplication");
        System.out.println("4  Division");
        int op = sc.nextInt();
        System.out.print("Enter operation: ");
        Double result = null;
        switch (op) {
            case 1:
                result = add(num1, num2);
                break;

            case 2:
                result = subtract(num1, num2);
                break;

            case 3:
                result = multiply(num1, num2);
                break;

            case 4:
                result = divide(num1, num2);
                if (result == null) {
                    System.out.println("Division by zero is not allowed");
                    sc.close();
                    return;
                }
                break;

            default:
                System.out.println(" Invalid operation");
                return;
        }
        System.out.println("Result= " + result);
    }
}