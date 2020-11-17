import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Collection {
    static Map<String, String> map = new TreeMap<>();

    void installation() {
        map.put("Вася", "+7(985)-611-77-56" );
        map.put("Петя", "+7(985)-357-89-91" );
        map.put("Аркаша", "8(985)-910-63-33" );
        map.put("Миша", "8(911)-123-14-47" );
        map.put("Гоша", "+7(985)-700-56-99" );
        map.put("Коля", "+7(901)-111-28-72" );
    }

    static void getCollection() {
        for(Map.Entry<String, String> item : map.entrySet()){

            System.out.println(item.getKey() +"-"+ item.getValue());
        }
    }

    static void setPhoneNumber(String key) {
        System.out.println("Впишите номер: ");

        Scanner in = new Scanner(System.in);
        String phoneNumber = in.next();

        map.put(key, phoneNumber);

        getCollection();
    }

    static void setName(String value) {
        System.out.println("Впишите имя: ");

        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        map.put(name, value);

        getCollection();
    }

    void chekKey(String key) {
        int counter = 0;

        for (Map.Entry<String, String> item : map.entrySet()) {
            if (key.equals(item.getKey())) {
                System.out.println(item.getKey() +"-"+ item.getValue());
                counter++;
                break;
            }
        }

        if (counter == 0) {
            setPhoneNumber(key);
        }
    }

    void chekValue(String value) {
        int counter = 0;
        for(Map.Entry<String, String> item : map.entrySet()) {
            if (value.equals(item.getValue())) {
                System.out.println(item.getKey() + "-" + item.getValue());
                counter++;
                break;
            }
        }

        if (counter == 0) {
            setName(value);
        }
    }
}

class TestCollection {
    public static void main(String []args)  {
        Scanner in = new Scanner(System.in);
        Collection collection = new Collection();
        String command;

        collection.installation();

        boolean flag = true;
        while (flag) {
            command  = in.nextLine();

            boolean chekLetterLatin = command.matches("^[a-zA-Z0]+$");
            boolean chekLetterCyrillic = command.matches("^[а-яА-Я0]+$");
            boolean chekNumber = command.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");

            switch (command) {
                case "LIST":
                    Collection.getCollection();
                    break;
                case "STOP":
                    flag = false;
                    break;
                default:
                    if (chekNumber)
                        collection.chekValue(command);
                    else if (chekLetterLatin || chekLetterCyrillic)
                        collection.chekKey(command);
                    else
                        System.out.println("Данные введены некорректно");
                        break;
            }
        }
    }
}
