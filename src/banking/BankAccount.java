package banking;

public class BankAccount {
    public int accountNumber;
    public String accountHolderName;
    public double currentBalance = 0;

    public BankAccount(int accountNumber, String accountHolderName, double currentBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void deposit(double amount) {
        currentBalance += amount;
        System.out.println("An amount of " + amount + " deposited successfully!");
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (currentBalance < amount) {
            throw new InsufficientBalanceException("Insufficient Balance!!");
        } else {
            currentBalance -= amount;
            System.out.println("An amount of " + amount + " debited from your account!");
        }
    }
}
