import java.util.Scanner;

public class BankApp {
    private static Bank myBank = new Bank("MyBank");

    public static void main(String[] args) {
        User user1 = new User(1000, "John", "123 Main St", "123-456-7890", 1234);
        User user2 = new User(1001, "Jane", "456 Main St", "123-456-7890", 1234);

        myBank.addUser(user1);
        myBank.addUser(user2);

        mainMenu();
    }

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to " + myBank.getName());
            System.out.println("1. Create a new user profile");
            System.out.println("2. Access existing user profile");
            System.out.println("3. Exit");
            System.out.print("Enter choice [1-3]: ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createUserProfile(scanner);
                    break;
                case 2:
                    accessUserProfile(scanner);
                    break;
                case 3:
                    System.out.println("Thank you for using " + myBank.getName() + "!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
    }

    public static void createUserProfile(Scanner scanner) {
        System.out.println("Enter your name: ");
        String name = scanner.next();
        System.out.println("Enter your address: ");
        String address = scanner.next();
        System.out.println("Enter your phone number: ");
        String phoneNumber = scanner.next();
        System.out.println("Enter your pin: ");
        int pin = scanner.nextInt();
        int userID = Bank.generateUserID();

        User newUser = new User(userID, name, address, phoneNumber, pin);
        myBank.addUser(newUser);
        System.out.println("User profile created successfully!");
        System.out.println("Your user ID is: " + userID);
    }

    public static void accessUserProfile(Scanner scanner) {
        System.out.println("Enter your user ID: ");
        int userID = scanner.nextInt();
        User user = myBank.getUser(userID);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        System.out.println("Enter your pin: ");
        int pin = scanner.nextInt();
        if (!user.verifyPin(pin)) {
            System.out.println("Incorrect pin!");
            return;
        }
        System.out.println("Welcome " + user.getName() + "!");
        userMenu(scanner, user);
    }

    public static void userMenu(Scanner scanner, User user) {
        int choice;
        do {
            System.out.println("\nAccount Menu");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Transfer money to another account");
            System.out.println("5. Change pin");
            System.out.println("6. Return to user profile menu");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Check balance
                    double balance = user.getBalance();
                    System.out.println("Your current balance is: $" + balance);
                    break;
                case 2:
                    // Deposit money
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    user.deposit(depositAmount);
                    System.out.println("Successfully deposited $" + depositAmount);
                    break;
                case 3:
                    // Withdraw money
                    System.out.println("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    user.withdraw(withdrawAmount);
                    System.out.println("Successfully withdrew $" + withdrawAmount);
                    break;
                case 4:
                    // Transfer money
                    System.out.print("Enter the account number to transfer to: ");
                    int accountNumberTo = scanner.nextInt();
                    System.out.print("Enter the amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    user.transfer(accountNumberTo, transferAmount);
                    System.out.println("Successfully transferred $" + transferAmount + " to account number " + accountNumberTo);
                    break;
                case 5:
                    // Change pin
                    System.out.print("Enter your old pin: ");
                    int oldPin = scanner.nextInt();
                    System.out.print("Enter your new pin: ");
                    int newPin = scanner.nextInt();
                    user.changePin(oldPin, newPin);
                    System.out.println("Successfully changed pin!");
                    break;

                case 6:
                    System.out.println("Returning to user profile menu.");
                    break;
                case 7:
                    System.out.println("Thank you for using " + myBank.getName() + "!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);
    }

}
// ... other methods will come here