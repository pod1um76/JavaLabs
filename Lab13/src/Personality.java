import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.*;

public class Personality {

    public void data() {
        Scanner in = new Scanner(System.in);
        String smMn;
        smMn = in.next();
        int counter = 0, index = 0;
        for (int i = 0; i < smMn.length(); i++) {
            if (smMn.charAt(i) == 0) {
                counter++;
            }
            if (smMn.charAt(i) != 45 && (smMn.charAt(i) < 192|| smMn.charAt(i) > 255)) {
                out.println("Введенная строка не является ФИО");
                break;
            }
        }
        if (counter == 0) {
            out.println("Введенная строка не является ФИО");
        }
        else {
            out.print("Фамилия: ");
            while (smMn.charAt(index) != 0) {
                out.print(smMn.charAt(index));
                index++;
            }
            index++;
            out.print("\nИмя: ");
            while (smMn.charAt(index) != 0 || index != smMn.length()) {
                out.print(smMn.charAt(index));
                index++;
            }
            if (index != smMn.length()) {
                index++;
                out.print("\nОтчество: ");
                while (smMn.charAt(index) != 0 || index != smMn.length()) {
                    out.print(smMn.charAt(index));
                    index++;
                }
            }
        }
    }
}
class Test {
    public static void main(String []args) {
        Personality obj = new Personality();
        obj.data();
    }
}
