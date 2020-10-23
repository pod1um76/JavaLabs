import java.util.Scanner;

public class NumberFone {
    private String numberFone;

    void fonNumber() {
        Scanner in = new Scanner(System.in);
        numberFone = in.nextLine();
    }
}

class TestNumberFone {
    public static void main() {
        NumberFone obj = new NumberFone();
        obj.fonNumber();
    }
}
