
import java.util.Scanner;

class BankApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Bank Name: ");
        String bankName = sc.nextLine();
        System.out.println("Enter UserId: ");
        int userID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter User Name: ");
        String userName = sc.nextLine();
        System.out.println("Enter Account Number: ");
        long accountNumber = sc.nextLong();
        sc.nextLine();
        System.out.println("Enter Account Type: ");
        String accountType = sc.nextLine();
        System.out.println("Enter OpeningBalance: ");
        double openingBalance = sc.nextDouble();

        Bank bank = new Bank(bankName, userID, userName, accountNumber, accountType, openingBalance);

        int choice;
        do {
            System.out.println();
            System.out.println("1. Display Complete Details");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Summary");
            System.out.println("6. Check Minimum Balance");
            System.out.println("0. Exit");
            System.out.println("Enter Choice: ");
            System.out.println();

            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Exit...");
                    System.out.println("Thank you...");
                    break;
                case 1:
                    bank.displayBankDetails();
                    bank.displayUserDetails();
                    bank.displayAccountDetails();

                    break;

                case 2:
                    System.out.println("Enter Amount to Deposit: ");
                    double amount = sc.nextDouble();
                    boolean res = bank.deposit(amount);
                    if (res) {
                        System.out.println("Deposit Succeded.");
                    } else {
                        System.out.println("Deposit Failed.");
                    }
                    System.out.println("Current Balance: " + bank.checkBalance());

                    break;

                case 3:
                    System.out.println("Enter Amount to Withdrawal: ");
                    double withdrwalAmount = sc.nextDouble();
                    boolean iswithdrawed = bank.withdraw(withdrwalAmount);
                    if (iswithdrawed) {
                        System.out.println("Withdrawal Succeded.");
                    } else {
                        System.out.println("Withdrawal Failed.");
                    }
                    System.out.println("Updated Balance: " + bank.checkBalance());

                    break;

                case 4:
                    double balance = bank.checkBalance();
                    System.out.println("Current Balance: " + balance);

                    break;

                case 5:
                    String accountSummary = bank.createAccountSummary();
                    System.out.println(accountSummary);

                    break;

                case 6:
                    System.out.println("Enter Minimum Balance To be Maintained: ");
                    double minimumBalance = sc.nextDouble();
                    boolean hasMinBalance = bank.hasMinimumBalance(minimumBalance);
                    if (hasMinBalance) {
                        System.out.println("Minimum Balance is Maintained.");
                    } else {
                        System.out.println("Minimum Balance is not Maintained.");
                    }

                    break;

                default:
                    System.out.println("Invalid-choice message!");

            }

        } while (choice != 0);
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
                + "\naccountNumber: " + accountNumber + "\naccountType: "
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

    boolean deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            return true;
        }
        return false;

    }

    boolean withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance = balance - amount;
                return true;
            }
        }
        return false;
    }

    double checkBalance() {
        return balance;
    }

}
