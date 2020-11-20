public class BankAccount {
    private Bank bank;
    private Person owner;
    private double balance;
    private int accountNumber;

    public BankAccount(Person owner, Bank bank, double balance, int accountNumber) {
        this.owner = owner;
        this.bank = bank;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public double withdraw(double amount) {
        if (balance < amount) {
            return -1;
        } else {
            balance -= amount;
            return balance;
        }
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    @Override
    public String toString() {
        return "Bank Account Information:\nBalance= " + balance + "\nAccount Number= " + accountNumber + "\n" + bank + "\n" + owner;
    }

    public boolean yearsPassed(int year){ // Section 2 additional task
        double money = year * 100.0;
        if (balance>=money){
            balance -= money;
            return true;
        }
        return false;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
