import java.util.Scanner;

public class Personality {

    public void data() {
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        String[] name_parts = name.split(" ");

        if (name_parts.length < 2) {
            System.out.println("Введенная строка не является ФИО");
            return;
        }
        for (char i : name.toCharArray()) {
            if (i != ' ' && i != '-' && (i < 'А' || i > 'я')) {
                System.out.println("Введенная строка не является ФИО");
                return;
            }
        }

        System.out.println("Фамилия: " + name_parts[0]);
    }
}
class Test {
    public static void main(String []args) {
        Personality obj = new Personality();
        obj.data();
    }
}