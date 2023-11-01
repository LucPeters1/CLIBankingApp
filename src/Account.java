import java.util.ArrayList;
import java.util.UUID;

public class Account {
    // Every account has an account number
    private int accountNumber;

    private double balance;

    // User who owns the account
    private User user;

    private int pin;

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public double getBalance(){
        return balance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public User getUser(){
        return user;
    }

    public boolean verifyPin(int enteredPin){
        return this.pin == enteredPin;
    }

    public void setPin(int pin){
        this.pin = pin;
    }

    public void changePin(int oldPin, int newPin){
        if(verifyPin(oldPin)){
            setPin(newPin);
        } else {
            System.out.println("Incorrect pin");
        }
    }

}