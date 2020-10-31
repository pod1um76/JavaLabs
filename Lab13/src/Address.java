import java.util.Scanner;
import java.util.TreeSet;

public class Address {

    TreeSet<String> treeSet = new TreeSet();

    void installation() {
        treeSet.add("eyelash@mail.ru");
        treeSet.add("bnjslss@yandex.ru");
        treeSet.add("wirbehvf@gmail.com");
        treeSet.add("vfjvdvj@rambler.ru");
        treeSet.add("nkdlfbaj@skillbox.ru");
        treeSet.add("fjasjvjfk@mail.ru");
    }

    void getTreeSet() {
        for (String i: treeSet) {
            System.out.println(i);
        }
        System.out.println("New list");
    }

    boolean isCorrect(String address) {
        int  counterDogs = 0;
        int counterPoints = 0;

        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '@' ) {
                counterDogs++;
            }
            if (address.charAt(i) == '.' && i != address.length() - 1 ) {
                counterPoints++;
            }
        }
        return counterDogs == 1 && counterPoints >= 1;
    }

    void addAddress(String address) {
        treeSet.add(address);
    }
}

class TestAddress {
    public static void main(String []args) {
        Address address = new Address();
        Scanner in = new Scanner(System.in);
        String command;
        String inf;

        address.installation();

        boolean flag = true;
        while (flag) {
            command = in.next();

            switch (command) {
                case "ADD":
                    inf = in.next();
                    if (address.isCorrect(inf)) {
                        address.addAddress(inf);
                        address.getTreeSet();
                    }
                    else
                        System.out.println("Адрес введён некоррректно");
                    break;
                case "LIST":
                    address.getTreeSet();
                    break;
                case "STOP":
                    flag = false;
                    break;
            }
        }
    }
}
