import javax.swing.JOptionPane;

public class BankApp {
    public static void main(String[] args) {
        // Prompt user for their name, surname, and account number
        String name = JOptionPane.showInputDialog("Enter your name:");
        String surname = JOptionPane.showInputDialog("Enter your surname:");
        String accountNumber = JOptionPane.showInputDialog("Enter your account number:");

        // Validate account number length and format
        while (accountNumber.length() != 11 || !accountNumber.matches("\\d+")) {
            accountNumber = JOptionPane.showInputDialog("Invalid account number. Please enter a 11-digit account number:");
        }

        //Create a new bank account with initial balance and user details 
        BankAccount account = new BankAccount(name, surname, accountNumber, 100000.00);
        ATM atm = new ATM(account);

        // Main loop for ATM operations
        while (true) {
            //Options for the ATM menu
            String[] options = {"Withdraw", "Deposit", "Check Balance", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "ATM Menu", "ATM", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);          

            switch (choice) {
                case 0:
                    // Handle withdrawal
                    String withdrawInput = JOptionPane.showInputDialog("Enter amount to withdraw:");
                    if (withdrawInput != null) {
                        try {
                            double withdrawAmount = Double.parseDouble(withdrawInput);
                            atm.withdraw(withdrawAmount);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.");
                        }
                    }
                    break;
                case 1:
                    //Handle deposit
                    String depositInput = JOptionPane.showInputDialog("Enter amount to deposit:");
                    if (depositInput != null) {
                        try {
                            double depositAmount = Double.parseDouble(depositInput);
                            atm.deposit(depositAmount);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.");
                        }
                    }
                    break;
                case 2:
                    // Display account balance
                    JOptionPane.showMessageDialog(null,account.getAccountDetails());
                    break;
                case 3:
                    // Exit the application
                    JOptionPane.showMessageDialog(null, "Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. please try again.");
            }
        }
    }
}