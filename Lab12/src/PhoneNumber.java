import java.util.Scanner;

public class PhoneNumber {
    private static final int SHORT_NUMBER_LENGTH = 10;
    private static final int FULL_NUMBER_LENGTH = 11;

    private String nationalCode;
    private String areaCode;
    private String subscriberNumber;

    private static String getNumberDigits(String phoneNumber) {
        String formattingOne = phoneNumber.replaceAll("[a-zA-Zа-яА-Я]*", "");
        String formattingTwo = formattingOne.replaceAll("[-!@#=$%.^&*()_+№;:?/\\\"~]*", "");

        String cleanedNumber = formattingTwo.replaceAll(" ", "");
        return cleanedNumber;
    }

    private static String normalizePhoneNumber(String phoneNumber) throws IllegalArgumentException{
        String phoneDigits = getNumberDigits(phoneNumber);

        if (phoneDigits.length() == SHORT_NUMBER_LENGTH)
            return '7' + phoneDigits;
        if (phoneDigits.length() == FULL_NUMBER_LENGTH)
            return phoneDigits;

        throw new IllegalArgumentException("Неверный формат номера");
    }

    private static boolean isCorrect(String number) {
        return number.startsWith("7") || number.startsWith("8");
    }

    private static String normalizeNationalCode(String number) {
        if (number.startsWith("8"))
            return '7' + number.substring(1);
        return number;
    }

    public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException {
        String normalized = normalizePhoneNumber(phoneNumber);
        if (!isCorrect(normalized))
            throw new IllegalArgumentException("Неверный формат номера");
        normalized = normalizeNationalCode(normalized);

        this.nationalCode = normalized.substring(0, 1);
        this.areaCode = normalized.substring(1, 4);
        this.subscriberNumber = normalized.substring(4);
    }

    public String getNumber() {
        String firstTriple = this.subscriberNumber.substring(0,3);
        String secondPair = this.subscriberNumber.substring(3,5);
        String thirdPair = this.subscriberNumber.substring(5,7);

        return String.format("+%s (%s) %s-%s-%s", this.nationalCode, this.areaCode, firstTriple, secondPair, thirdPair);
    }
}

class Main {
    public static void main(String []args) {
        Scanner in = new Scanner(System.in);

        PhoneNumber number1 = new PhoneNumber();
        try {
            number1.setPhoneNumber(in.nextLine());
            System.out.println(number1.getNumber());
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }
}