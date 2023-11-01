public class ATM {
    private int atmID;
    private Bank bank;

    public void withdraw(User user, int accountNumber, int enteredPin, double amount) {
        Account account = user.getAccount(accountNumber);
        if (account != null && account.verifyPin(enteredPin)) {
            account.withdraw(amount);
        } else {
            System.out.println("Incorrect pin");
        }
    }

    public void deposit(User user, int accountNumber, int enteredPin, double amount) {
        Account account = user.getAccount(accountNumber);
        if (account != null && account.verifyPin(enteredPin)) {
            account.deposit(amount);
        } else {
            System.out.println("Incorrect pin");
        }
    }

    public double checkBalance(User user, int accountNumber, int enteredPin) throws Exception {
        Account account = user.getAccount(accountNumber);
        if (account == null) {
            throw new Exception("Account not found");
        }
        if (!account.verifyPin(enteredPin)) {
            throw new Exception("Incorrect pin");
        }
        return account.getBalance();
    }


    public void transfer(User user, int accountNumberFrom, int accountNumberTo, double amount) {
        Account accountFrom = user.getAccount(accountNumberFrom);
        Account accountTo = user.getAccount(accountNumberTo);
        accountFrom.withdraw(amount);
        accountTo.deposit(amount);
    }

    public int getATMID() {
        return atmID;
    }

}