package ca.bank;

public class Bank {
    private String name;
    private Account[] accounts;

    // bank accounts are stored in Account array
    public Bank(String bankName, Account[] allAccounts) {

        name = bankName;
        accounts = allAccounts;
    }

    public String getName() {
        return name;
    }

    //gets individual account
    public Account getAccount(int index) {
        return accounts[index];
    }


    public static void main(String[] args) {

    }
}
