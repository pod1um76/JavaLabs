import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

public class Bank implements Runnable {
    static private long bankMoney = 0;
    static private long bankMoneyCheck = 0;
    static private HashMap<String, Account> accounts = new HashMap<String, Account>();
    static private ArrayList<String> blockedAccounts = new ArrayList<>();
    static private final Random random = new Random();
    static String line = "";
    static Scanner read = new Scanner(System.in);
    static String aa = "";
    static String a = "", b = "";
    static long c = 0;
    static AtomicBoolean balance = new AtomicBoolean();
    static Bank myThread = new Bank();
    private static Thread bankMulti = new Thread(myThread, "bank");

    public static void main(String[] args) {
        accounts.put("Геннадий", new Account(47826, "Геннадий"));
        accounts.put("Федор", new Account(24655, "Федор"));
        accounts.put("Андрей", new Account(74225, "Андрей"));
        accounts.put("Леонид", new Account(87568, "Леонид"));
        accounts.put("Евгений", new Account(325465, "Евгений"));
        accounts.put("Джамшут", new Account(12678, "Джамшут"));
        accounts.put("Дмитрий", new Account(65752, "Дмитрий"));
        accounts.put("Ринат", new Account(12678, "Ринат"));

        ArrayList<Account> values = new ArrayList<>(accounts.values());

        for (int i = 0; i < accounts.size(); i++)
            bankMoney += values.get(i).money;

        System.out.println(
                "Терминал банка. Вам доступны две команды: баланс {имя клиента банка}, перевод {имя клиента, у которого хотите снять деньги} {имя клиента, которому хотите передать сумму} {сумма перевода}");

        line = read.nextLine();

        balance.set(false);

        while (!line.equals("выход")) {
            String[] lineArr = line.split(" ");

            switch (lineArr[0]) {
                case ("баланс"):
                    if (lineArr.length == 2 && accounts.containsKey(lineArr[1])) {
                        balance.set(true);
                        aa = lineArr[1];
                        c = 0;
                        bankMulti = new Thread(myThread, "bank");
                        bankMulti.start();
                    } else
                        System.out.println("Данных о пользователе не существует");
                    break;
                case ("перевод"):
                    if (lineArr.length == 4 && accounts.containsKey(lineArr[1]) && accounts.containsKey(lineArr[2])) {
                        a = lineArr[1];
                        b = lineArr[2];
                        c = Long.parseLong(lineArr[3]);
                        bankMulti = new Thread(myThread, "bank");
                        bankMulti.start();
                    } else
                        System.out.println("Данные о пользователях не существуют");
                    break;
                default:
                    System.out.println("Неизвестная команда");
                    break;
            }
            line = read.nextLine();
        }
    }

    public static boolean isFraud(String fromAccountNum, String toAccountNum, long amount) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        return random.nextBoolean();
    }

    public static synchronized void transfer(String fromAccountNum, String toAccountNum, long amount) {
        if (!(blockedAccounts.contains(fromAccountNum) || blockedAccounts.contains(toAccountNum))) {
            if (accounts.get(fromAccountNum).money >= amount && amount > 0) {
                if (amount <= 50000) {
                    checkAllSum();
                    accounts.get(fromAccountNum).money -= amount;
                    accounts.get(toAccountNum).money += amount;
                    System.out.println(
                            "Перевод " + fromAccountNum + " -> " + toAccountNum + " = " + amount + " проведен успешно");
                    checkAllSum();
                } else {
                    if (isFraud(fromAccountNum, toAccountNum, amount)) {
                        blockedAccounts.add(fromAccountNum);
                        blockedAccounts.add(toAccountNum);
                        System.out.println("Перевод " + fromAccountNum + " -> " + toAccountNum + " = " + amount
                                + " заблокирован. Подозрение в мошенничестве");
                    } else {
                        checkAllSum();
                        accounts.get(fromAccountNum).money -= amount;
                        accounts.get(toAccountNum).money += amount;
                        System.out.println("Перевод " + fromAccountNum + " -> " + toAccountNum + " = " + amount
                                + " проведен успешно");
                        checkAllSum();
                    }
                }
            } else {
                System.out.println("Перевод " + fromAccountNum + " -> " + toAccountNum + " = " + amount
                        + " заблокирован. Недостаточно средств");
            }
        } else {
            System.out.println("Перевод " + fromAccountNum + " -> " + toAccountNum + " = " + amount
                    + " заблокирован. Служба Безопасности не позволила провести перевод");
        }
    }

    public static void getBalance(String accountNum) {
        balance.set(false);
        System.out.println("Пользователь: " + accountNum + "\n" + "Баланс: " + accounts.get(accountNum).money + " р");
    }

    public static void checkAllSum() {
        bankMoneyCheck = 0;

        ArrayList<Account> values = new ArrayList<>(accounts.values());

        for (int i = 0; i < accounts.size(); i++)
            bankMoneyCheck += values.get(i).money;

        if (bankMoney != bankMoneyCheck) {
            System.out.println("Произошла непридвиденная ошибка, повторите попытку снова");
            System.exit(-1);
        }
    }

    @Override
    public void run() {
        if (!balance.get())
            transfer(a, b, c);
        else
            getBalance(aa);
    }
}
