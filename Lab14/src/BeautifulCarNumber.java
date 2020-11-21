import java.util.*;

public class BeautifulCarNumber {
    static ArrayList<String> numbersCar = new ArrayList< >();
    private static final int COMBINATION = 200;
    private static final int SIZE_SYMBOLS = 10;

    static void generateNumbers() {
        char[] symbols = {'А','В','Е','К','М','Н','О','Р','С','Т','У','Х'};
        String saveSymbols;

        for (char i : symbols)
            for (char j : symbols)
                for (char k : symbols)
                    for (int m = 1; m < COMBINATION; m++)
                        for (int n = 0; n < SIZE_SYMBOLS; n++) {
                            saveSymbols = i + String.valueOf(n) + n + n + j + k;
                            saveSymbols += m < SIZE_SYMBOLS ? ("0" + m) : (String.valueOf(m));
                            numbersCar.add(saveSymbols);
                        }

        System.out.println("Кол-во номеров: " + numbersCar.size());
    }

    static void findCarNumber() {
        HashSet<String> numbersHash = new HashSet< >(numbersCar);
        TreeSet<String> numbersTree = new TreeSet< >(numbersCar);
        Scanner in = new Scanner(System.in);
        String saveSymbols;
        boolean flag;
        int binarySearch;
        long startTine;
        long stopTime;

        System.out.print("Введите номер для поиска: ");
        String line = in.nextLine();

        startTine = System.nanoTime();
        flag = numbersCar.contains(line);
        stopTime = System.nanoTime();

        saveSymbols = flag? ("Найден") : ("НЕ найден");
        System.out.println("Поиск перебором: " + saveSymbols + ", поиск занял: " + (stopTime - startTine) + " нс");

        Collections.sort(numbersCar);
        startTine = System.nanoTime();
        binarySearch = Collections.binarySearch(numbersCar,line);
        stopTime = System.nanoTime();

        saveSymbols = binarySearch>=0? ("Найден") : ("НЕ найден");
        System.out.println("Бинарный  поиск: " + saveSymbols + ", поиск занял: " + (stopTime - startTine) + " нс");

        startTine = System.nanoTime();
        flag = numbersHash.contains(line);
        stopTime = System.nanoTime();

        saveSymbols = flag? ("Найден") : ("НЕ найден");
        System.out.println("Поиск в HashSet: " + saveSymbols + ", поиск занял: " + (stopTime - startTine) + " нс");

        startTine = System.nanoTime();
        flag = numbersTree.contains(line);
        stopTime = System.nanoTime();

        saveSymbols = flag? ("Найден") : ("НЕ найден");
        System.out.println("Поиск в TreeSet: " + saveSymbols + ", поиск занял: " + (stopTime - startTine) + " нс");
    }

    public static void main(String []args) {
        generateNumbers();
        findCarNumber();
    }
}