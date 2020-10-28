import java.util.Scanner;
import java.util.TreeSet;

public class Address {

    TreeSet<String> treeSet = new TreeSet();
    private static final char DOG = '@';
    private static final char POINT= '.';

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
            if (address.charAt(i) == DOG ) {
                counterDogs++;
            }
            if (address.charAt(i) == POINT) {
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

    private static final String ADD = "ADD";
    private static final String LIST = "LIST";

    public static void main(String []args) {
        Address address = new Address();
        Scanner in = new Scanner(System.in);
        String command;
        String inf;

        address.installation();

        while (true) {
            command = in.next();

            switch (command) {
                case ADD:
                    inf = in.next();
                    if (address.isCorrect(inf)) {
                        address.addAddress(inf);
                        address.getTreeSet();
                    }
                    else
                        System.out.println("Адрес введён некоррректно");
                    break;
                case LIST:
                    address.getTreeSet();
                    break;
            }
        }
    }
}
