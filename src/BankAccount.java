import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Random;

public class BankAccount {

    private String ownerName;
    private int balance;
    private LocalDateTime openingDate;
    private boolean isBlocked;
    private String accountNumber;


    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0;
        this.openingDate = LocalDateTime.now();
        this.isBlocked = false;
        this.accountNumber = generateAccountNumber();
    }


    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            number.append(random.nextInt(10));
        }
        return number.toString();
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

    public String getAccountNumber() {
        return accountNumber;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String status = isBlocked ? "ЗАБЛОКИРОВАН" : "АКТИВЕН";

        return "===================================\n" +
                "         БАНКОВСКИЙ СЧЕТ          \n" +
                "===================================\n" +
                " Номер счета: " + accountNumber + "\n" +
                " Владелец:    " + ownerName + "\n" +
                " Баланс:      " + balance + " руб.\n" +
                " Дата откр.:  " + openingDate.format(formatter) + "\n" +
                " Статус:      " + status + "\n" +
                "===================================";
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }


        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }


        BankAccount other = (BankAccount) obj;


        return Objects.equals(accountNumber, other.accountNumber);
    }


    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }


    public boolean equalsDetailed(BankAccount other) {
        if (this == other) return true;
        if (other == null) return false;

        return Objects.equals(accountNumber, other.accountNumber) &&
                Objects.equals(ownerName, other.ownerName) &&
                balance == other.balance &&
                Objects.equals(openingDate, other.openingDate) &&
                isBlocked == other.isBlocked;
    }
}