import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accountList;
    private List<User> userList;

    private List<ATM> atmList;

    private static int nextUserID = 1000;

    public static int generateUserID() {
        return nextUserID++;
    }

    public Bank(String name) {
        this.name = name;
        userList = new ArrayList<>();

    }

    public void addATM(ATM atm) {
        atmList.add(atm);
    }

    public void removeATM(ATM atm) {
        atmList.remove(atm);
    }

    public ATM getATM(int atmID) {
        for (ATM atm : atmList) {
            if (atm.getATMID() == atmID) {
                return atm;
            }
        }
        return null;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        accountList.remove(account);
    }

    public Account getAccount(int accountNumber) {
        for (Account account : accountList) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void deleteUser(User user) {
        userList.remove(user);
    }

    public User getUser(int userID) {
        for (User user : userList) {
            if (user.getUserID() == userID) {
                return user;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}