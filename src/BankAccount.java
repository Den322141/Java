import java.time.LocalDateTime;

public class BankAccount {
    private String ownerName;
    private int balance;
    private LocalDateTime openingDate;
    private boolean isBlocked;
    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0;
        this.openingDate = LocalDateTime.now();
        this.isBlocked = false;
    }


    public String getOwnerName() {
        return ownerName;
    }

    public int getBalance() {
        return balance;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }


    public boolean deposit(int amount) {
        if (amount > 0 && !isBlocked) {
            balance += amount;
            return true;
        }
        return false;
    }


    public boolean withdraw(int amount) {
        if (!isBlocked && amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }


    public boolean transfer(BankAccount otherAccount, int amount) {
        if (this != otherAccount && !isBlocked && !otherAccount.isBlocked()
                && amount > 0 && balance >= amount) {
            balance -= amount;
            otherAccount.deposit(amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
    }
}