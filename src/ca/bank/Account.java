package ca.bank;

public class Account {
    private final String owner;
    private double balance;
    private String type;  //account type
    private String investment; //type of investment account

    public Account(String ownerName, String acctType, double initialBalance) {

        if (!acctType.equals("Checking")) {
            throw new IllegalArgumentException("Account type must be Checking");
        }

        owner = ownerName;
        type = acctType;
        balance = initialBalance;
    }

    public Account(String ownerName, String acctType, double initialBalance, String investmentType) {

        if (!acctType.equals("Investment")) {
            throw new IllegalArgumentException("Account type must be Investment");
        }
        if (!(investmentType.equals("Individual") || investmentType.equals("Corporate"))) {
            throw new IllegalArgumentException("Investment type must be Individual or Corporate");
        }

        owner = ownerName;
        type = acctType;
        balance = initialBalance;
        investment = investmentType;

    }

    public void deposit(double amount) {
        balance += amount;

    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("insufficient funds");
        }
        if (this.investment.equals("Individual") && amount > 500) {
            throw new IllegalArgumentException("Individual accounts have a withdrawal limit of 500 dollars");
        } else {
            balance -= amount;
        }

    }

    public void transfer(Account other, double amount) {
        other.deposit(amount);
        this.withdraw(amount);
    }

    public String getOwner() {
        return owner;
    }

    public String getAccountType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }


    public static void main(String[] args) {

        Account first = new Account("Andy", "Investment", 1000, "Individual");
        first.withdraw(499);
        System.out.println(first.type);
    }

}
