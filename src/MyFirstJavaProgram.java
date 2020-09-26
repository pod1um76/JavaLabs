public class MyFirstJavaProgram {
    private static char toUpper(char ascii) {
        if(ascii > 96 && ascii < 123) {
            return (char)(ascii - 32);
        }
        return ascii;
    }
    private static boolean isLetter(char ascii) {
        return (ascii > 64 && ascii < 91) || (ascii > 96 && ascii < 123);
    }
    public static void check(String save) {
        int i = 0, j = save.length() - 1;
        while(i < j) {
            while(!isLetter(save.charAt(i))) {
                i++;
            }
            while(!isLetter(save.charAt(j))) {
                j--;
            }
            if(toUpper(save.charAt(i)) != toUpper(save.charAt(j))) {
                System.out.print("false");
                break;
            }
            i++;
            j--;
        }
        if(i >= j) {
            System.out.print("True");
        }
    }
    public static void main(String[] args) {
        String save = "d95605243adam, I'm Adam!!!!!!!";
        check(save);
    }
}