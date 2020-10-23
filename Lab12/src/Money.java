public class Money {
    static final int PATH_VASA = 2;
    static final int PATH_MASHA = 11;

    void children() {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        String[] Parts = text.split(" ");
        int moneyVasiliy = Integer.parseInt(Parts[PATH_VASA].trim());
        int moneyMasha = Integer.parseInt(Parts[PATH_MASHA].trim());
        System.out.println("Cумма денег Василия и Марии: " + (moneyVasiliy + moneyMasha));
    }
}

class TestMoney {

    public static void main(String args[]) {
        Money obj = new Money();
        obj.children();
    }
}
