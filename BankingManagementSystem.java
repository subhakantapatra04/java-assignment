import java.util.Scanner;

class BankAccount {
    double balance = 0;

    void deposit(double amt) {
        balance = balance + amt;
        System.out.println("Deposited");
    }

    void withdraw(double amt) {
        if (amt > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance = balance - amt;
            System.out.println("Withdrawn");
        }
    }

    void checkBalance() {
        System.out.println("Balance: " + balance);
    }
}

public class BankingManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount acc = new BankAccount();

        while (true) {
            System.out.println("\n1 Deposit");
            System.out.println("2 Withdraw");
            System.out.println("3 Check Balance");
            System.out.println("4 Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Enter amount: ");
                double amt = sc.nextDouble();
                acc.deposit(amt);

            } else if (ch == 2) {
                System.out.print("Enter amount: ");
                double amt = sc.nextDouble();
                acc.withdraw(amt);

            } else if (ch == 3) {
                acc.checkBalance();

            } else if (ch == 4) {
                break;
            }
        }
    }
}
