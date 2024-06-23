import javax.swing.JOptionPane;
class BankAccount {
    private String name;           //User's first name
    private String surname;        //User's surname
    private String accountNumber;  //User's account number
    private double balance;        // Account balance
    
    //constructor to initialize BankAccount with user details and initial balance
    public BankAccount(String name, String surname, String accountNumber, double initialBalance) {
        this.name = name;
        this.surname = surname;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }  

    // Deduct a fee from the account balance (private method)
    private void deductFee(double feeAmount) {
        balance -= feeAmount;
    }

    // withdraw an amount from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            deductFee(0.5); //Deducting transaction fee
            JOptionPane.showMessageDialog(null, "withdraw: " + amount);
        }else {
            JOptionPane.showMessageDialog(null, "Insufficient Balance.");
        }
    }

    // Deposit an amount to the account
    public void deposit (double amount) {
        if (amount > 0) {
            balance += amount;
        }else {
            JOptionPane.showMessageDialog(null, "Invalid deposit amount.");
        }
    }
    // Get the current balance of the account
    public double getBalance() {
        return balance;
    }

    // Get the account details as a formatted string
    public String getAccountDetails() {
        return "Name: " + name + "\n" +
               "Surname: " + surname + "\n" +
               "Account Number: " + accountNumber + "\n" +
               "Current Balance: " + balance;
    }   
}
