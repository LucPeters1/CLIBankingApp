import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private int userID;
    private String name;
    private String address;
    private String phoneNumber;
    private List<Account> accounts;
    private int pin;

    private double balance;

    public User(int userID, String name, String address, String phoneNumber, int pin) {
        this.userID = userID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.pin = pin;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    // Loops over the account List, for each account, check if the account number matches the account number passed in
    public Account getAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getUserID() {
        return userID;
    }

    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void changePin(int oldPin, int newPin) {
        if (verifyPin(oldPin)) {
            setPin(newPin);
        } else {
            System.out.println("Incorrect pin");
        }
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        //check if amount is greater than balance
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return;
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }


    public void transfer(int accountNumberTo, double transferAmount) {
        Account accountTo = getAccount(accountNumberTo);
        accountTo.deposit(transferAmount);
        this.withdraw(transferAmount);
    }
}