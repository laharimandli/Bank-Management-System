
import java.util.Scanner;

class BankApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bankName = sc.nextLine();
        int userID = sc.nextInt();
        sc.nextLine();
        String userName = sc.nextLine();
        long accountNumber = sc.nextLong();
        sc.nextLine();
        String accountType = sc.nextLine();
        double openingBalance = sc.nextDouble();

        Bank bank = new Bank(bankName, userID, userName, accountNumber, accountType, openingBalance);
        bank.displayBankDetails();
        bank.displayUserDetails();
        bank.displayAccountDetails();
        bank.createAccountSummary();
        if (bank.hasMinimumBalance(openingBalance)) {
            System.out.println("Minimum balance is maintained.");
        } else {
            System.out.println("Minimum balance is not maintained.");
        }
        sc.close();
    }
}

class Bank {

    String bankName;
    int userId;
    String userName;
    long accountNumber;
    String accountType;
    double balance;

    Bank(String bankName, int userId, String userName, long accountNumber, String accountType, double balance) {
        this.bankName = bankName;
        this.userId = userId;
        this.userName = userName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    void displayBankDetails() {
        System.out.println("Bank Name: " + bankName);
    }

    void displayUserDetails() {
        System.out.println("User ID: " + userId);
        System.out.println("User Name: " + userName);

    }

    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: " + balance);
    }

    String createAccountSummary() {
        String accountSummary = "Bank Name: " + bankName + "\nUserId: " + userId
                + "\naccountNumber: " + accountNumber + "accountType: "
                + accountType + "\nBalance: " + balance;
        return accountSummary;
    }

    boolean hasMinimumBalance(double minimumBalance) {
        boolean res = false;
        if (balance >= minimumBalance) {
            res = true;
        }
        return res;
    }

}
