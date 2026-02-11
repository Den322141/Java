public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Иван Петров");
        BankAccount account2 = new BankAccount("Мария Иванова");

        System.out.println("=== Пополнение счета ===");
        System.out.println("Пополнение account1 на 1000: " + account1.deposit(1000));
        System.out.println("Баланс account1: " + account1.getBalance());

        System.out.println("\n=== Снятие со счета ===");
        System.out.println("Снятие с account1 500: " + account1.withdraw(500));
        System.out.println("Баланс account1 после снятия: " + account1.getBalance());
        System.out.println("Попытка снять 600: " + account1.withdraw(600));

        System.out.println("\n=== Перевод между счетами ===");
        account2.deposit(2000);
        System.out.println("Баланс account2: " + account2.getBalance());
        System.out.println("Перевод с account1 на account2 300: " +
                account1.transfer(account2, 300));
        System.out.println("Баланс account1: " + account1.getBalance());
        System.out.println("Баланс account2: " + account2.getBalance());

        System.out.println("\n=== Проверка блокировки ===");
        account1.setBlocked(true);
        System.out.println("Счет account1 заблокирован: " + account1.isBlocked());
        System.out.println("Попытка пополнить: " + account1.deposit(100));

        System.out.println("\n=== Информация о счетах ===");
        System.out.println(account1);
        System.out.println(account2);
    }
}