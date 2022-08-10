package ca.bank;

public class BankTest {
    public static void main(String[] args) {
        Account first = new Account("Andy", "Investment", 1000, "Individual");
        Account second = new Account("John", "Checking", 10000);
        Account third = new Account("Jim", "Investment", 2000, "Corporate");
        Account fourth = new Account("Joe", "Investment", 5000, "Individual");

        Account[] accounts = {first, second, third, fourth};

        Bank bank = new Bank("Bank of Rowing", accounts);

        System.out.println(bank.getName());

        System.out.println(bank.getAccount(0).getBalance());  //balance should be 1000
        bank.getAccount(0).withdraw(400);
        System.out.println(bank.getAccount(0).getBalance()); // balance should be 600
        bank.getAccount(0).deposit(400);
        System.out.println(bank.getAccount(0).getBalance());  //balance should be 1000
        bank.getAccount(0).transfer(bank.getAccount(1), 350);
        System.out.println(bank.getAccount(0).getBalance());  //balance should be 650
        System.out.println(bank.getAccount(1).getBalance());  //balance should be 10350


        //testing error handling
        //bank.getAccount(0).withdraw(2001);
        //Account fifth = new Account("Joe", "Investment", 5000, "Individu");
        //Account fifth = new Account("Joe", "Investment", 5000);

    }
}
