package banking;

public class BankAccountHandler {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(123456, "Jone Doe", 2000);

        // Deposit
        bankAccount.deposit(3000);

        // Display Balance
        System.out.println("Current Balance: " + bankAccount.getCurrentBalance());

        try {
            // Withdraw sufficient balance
            bankAccount.withdraw(4000);

            // Withdraw insufficient balance
            bankAccount.withdraw(1001);
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
