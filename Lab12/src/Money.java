public class Money {

    void children() {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        String[] Parts = text.split(" ");
        int moneyVasiliy = Integer.parseInt(Parts[2].trim());
        int moneyMasha = Integer.parseInt(Parts[11].trim());
        System.out.println("Cумма денег Василия и Марии: " + (moneyVasiliy + moneyMasha));
    }
}

class TestMoney {

    public static void main(String args[]) {
        Money obj = new Money();
        obj.children();
    }
}
