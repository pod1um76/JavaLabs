import java.util.StringTokenizer;

public class Money {
    static final int PATH_VISA = 3;
    static final int PATH_MASHA = 12;

    void children() {
        int moneyVisa = 0;
        int moneyMasha = 0;
        int counter = 0;
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        StringTokenizer st = new StringTokenizer(text, " ");

        while(st.hasMoreTokens()) {
            counter++;
            String key = st.nextToken();

            if (counter == PATH_VISA)
                moneyVisa = Integer.parseInt(key.trim());

            if (counter == PATH_MASHA)
                moneyMasha = Integer.parseInt(key.trim());
        }

        System.out.println("Сумма денег Васи и Маши равна: " + (moneyVisa + moneyMasha) + " рублей");
    }
}

class TestMoney {

    public static void main(String[] args) {
        Money obj = new Money();
        obj.children();
    }
}
