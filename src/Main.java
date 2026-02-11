public class Main {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ БАНКОВСКИХ СЧЕТОВ ===\n");


        BankAccount account1 = new BankAccount("Иван Петров");
        BankAccount account2 = new BankAccount("Мария Иванова");
        BankAccount account3 = new BankAccount("Иван Петров");


        System.out.println("ЗАДАНИЕ 1: МЕТОД toString()");
        System.out.println("-----------------------------------");
        System.out.println("Счет №1:");
        System.out.println(account1);
        System.out.println();
        System.out.println("Счет №2:");
        System.out.println(account2);
        System.out.println();


        System.out.println("ЗАДАНИЕ 2: НОМЕРА СЧЕТОВ");
        System.out.println("-----------------------------------");
        System.out.println("Номер счета 1: " + account1.getAccountNumber());
        System.out.println("Номер счета 2: " + account2.getAccountNumber());
        System.out.println("Номер счета 3: " + account3.getAccountNumber());
        System.out.println();


        account1.deposit(5000);
        account2.deposit(3000);
        account3.deposit(10000);

        account1.transfer(account2, 1500);
        account2.setBlocked(true);


        System.out.println("ЗАДАНИЕ 3: МЕТОДЫ equals() И hashCode()");
        System.out.println("-----------------------------------");


        System.out.println("account1.equals(account1): " + account1.equals(account1));


        System.out.println("account1.equals(account2): " + account1.equals(account2));


        System.out.println("account1.equals(account3): " + account1.equals(account3));


        System.out.println("\nХеш-коды счетов:");
        System.out.println("account1 hash: " + account1.hashCode());
        System.out.println("account2 hash: " + account2.hashCode());
        System.out.println("account3 hash: " + account3.hashCode());


        System.out.println("\naccount1.equals(null): " + account1.equals(null));


        System.out.println("\nКонтракт equals/hashCode:");
        System.out.println("account1.equals(account1): " + account1.equals(account1));
        System.out.println("hashCode одинаковый: " +
                (account1.hashCode() == account1.hashCode()));


        System.out.println("\nИспользование в коллекциях:");
        java.util.HashSet<BankAccount> accounts = new java.util.HashSet<>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account1);

        System.out.println("Размер HashSet: " + accounts.size() + " (должен быть 3)");
        System.out.println("Счета в HashSet:");
        for (BankAccount acc : accounts) {
            System.out.println("  - " + acc.getAccountNumber() + " | " + acc.getOwnerName());
        }


        System.out.println("\n=== ФИНАЛЬНОЕ СОСТОЯНИЕ СЧЕТОВ ===");
        System.out.println(account1);
        System.out.println();
        System.out.println(account2);
        System.out.println();
        System.out.println(account3);
    }
}