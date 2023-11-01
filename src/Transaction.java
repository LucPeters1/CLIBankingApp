import java.util.Date;

public class Transaction {
    private Date timeStamp;
    private double amount;
    private String type;
    private int accountNumber;

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}