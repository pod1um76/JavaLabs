import java.util.Scanner;

public class Personality {
    static final int MIN_FULL_NAME_LENGTH = 2;

    private boolean isCyrillic(String str) {
        for (char i : str.toCharArray()) {
            if (i != ' ' && i != '-' && (i < 'А' || i > 'я')) {
                return false;
            }
        }
        return true;
    }

    public void data() {
        Scanner in = new Scanner(System.in);
        String fullName = in.nextLine();
        String[] nameParts = fullName.split(" ");


        if (!isCyrillic(fullName) || nameParts.length < MIN_FULL_NAME_LENGTH) {
            System.out.println("Введенная строка не является ФИО");
            return;
        }
        System.out.println("Фамилия: " + nameParts[0]);
        System.out.println("Имя: " + nameParts[1]);
        if (nameParts.length > MIN_FULL_NAME_LENGTH)
            System.out.println("Отчество: " + nameParts[2]);
    }
}
class Test {
    public static void main(String []args) {
        Personality obj = new Personality();
        obj.data();
    }
}