import javax.swing.JOptionPane;
class ATM {
    private BankAccount account; //The BankAccount Associated with this ATM 

    // Constructor to initialize ATM with a BankAccount
    public ATM(BankAccount account) {
        this.account = account;
    }

    //Handle the withdrawal process
    public void withdraw(double amount) {
        if (amount > 0 && amount <= account.getBalance()) {
            account.withdraw(amount);
            JOptionPane.showMessageDialog(null, account.getAccountDetails());
            int choice = JOptionPane.showConfirmDialog(null, "Do you want a receipt?", "Receipt", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                printReceipt("Withdraw", amount);
            }        
        } else {
            JOptionPane.showMessageDialog(null,"Insufficient balance or invalid amount.");
        } 
    }

    //Handle the deposit process
    public void deposit(double amount) {
        if (amount > 0) {
            account.deposit(amount);
            JOptionPane.showMessageDialog(null, account.getAccountDetails());
            int choice = JOptionPane.showConfirmDialog(null, "Do you want a receipt?", "Receipt", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                printReceipt("Deposit", amount);
            }              
        } else {
            JOptionPane.showMessageDialog(null, "Invalid deposit amount.");
        }      
    }

    //Display the account balance
    public void checkBalance() {
        JOptionPane.showMessageDialog(null, account.getAccountDetails());
    }

    //print the receipt for the transaction
    private void printReceipt(String transactionType, double amount) {
        String receipt = "====================================================================" + "\n" +
                "Receipt\n" +
                "===========================================================================\n" +
                "Transaction Type: " + transactionType + "\n" +
                "Amount: " + amount + "\n" +
                account.getAccountDetails() + "\n" +
                "===========================================================================";
        JOptionPane.showMessageDialog(null, receipt);
    }   
}
