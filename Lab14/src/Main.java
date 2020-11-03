import java.util.*;

class GeneratingBeautifulNumber {

    private static final int MAX_SIZE = 199;
    private static final int FORMAT_NUMBER = 100;
    private static final int SIZE_NUMBER = 10;
    private static final int POSITIONS_FIVE = 5;
    private static final int POSITIONS_FOUR = 4;
    private static final int POSITIONS_ONE = 1;
    public static final int POSITIONS_NULL = 0;

    public static SearchMethod<ArrayList<String>, HashSet<String>, TreeSet<String>> genNumbers() {
        ArrayList<String> arrayList = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        ArrayList<Character> chars = new ArrayList<>(Arrays.asList('A', 'B', 'E', 'K', 'M', 'H', 'O', 'P', 'C', 'T', 'Y', 'X'));

        for (int charInter1 = POSITIONS_NULL; charInter1 < chars.size(); charInter1++) {
            StringBuilder number = new StringBuilder();
            number.append(chars.get(charInter1));
            for (int numInter = POSITIONS_NULL; numInter < SIZE_NUMBER; numInter++) {
                number.append(String.format("%03d", numInter * FORMAT_NUMBER + numInter * SIZE_NUMBER + numInter));
                for (int charInter2 = POSITIONS_NULL; charInter2 < chars.size(); charInter2++) {
                    if (charInter2 == charInter1) {
                        charInter2++;
                    }
                    if (charInter2 >= chars.size())
                        break;
                    number.append(chars.get(charInter2));

                    for (int charInter3 = POSITIONS_NULL; charInter3 < chars.size(); charInter3++) {
                        if (charInter3 == charInter1 || charInter3 == charInter2) {
                            charInter3++;
                            if (charInter3 == charInter1 || charInter3 == charInter2)
                                charInter3++;

                            if (charInter3 >= chars.size())
                                break;
                        }
                        number.append(chars.get(charInter3));

                        for (int i = POSITIONS_ONE; i <= MAX_SIZE; i++) {
                            arrayList.add(number + String.format("%02d",i));
                            hashSet.add(number + String.format("%02d",i));
                            treeSet.add(number + String.format("%02d",i));
                        }
                        number = new StringBuilder(number.substring(POSITIONS_NULL, POSITIONS_FIVE));
                    }
                    number = new StringBuilder(number.substring(POSITIONS_NULL, POSITIONS_FOUR));
                }
                number = new StringBuilder(number.substring(POSITIONS_NULL, POSITIONS_ONE));
            }
            number = new StringBuilder(number.substring(POSITIONS_NULL, POSITIONS_NULL));
        }
        return new SearchMethod<>(arrayList,hashSet,treeSet);
    }
}

class SearchMethod<SearchOne, SearchTwo, SearchThree> {
    public SearchOne first;
    public SearchTwo second;
    public SearchThree third;

    SearchMethod(SearchOne fst, SearchTwo second, SearchThree third) {
        this.first = fst;
        this.second = second;
        this.third = third;
    }
}

public class Main {

    public static void main(String[] args) {
        SearchMethod<ArrayList<String>, HashSet<String>, TreeSet<String>> triplet = GeneratingBeautifulNumber.genNumbers();
        ArrayList<String> sorted = (ArrayList<String>) triplet.first.clone();
        Collections.sort(sorted);
        Scanner in = new Scanner(System.in);

        while (true) {

            System.out.print("Укажите номер для поиска: ");
            String numberToFind = in.nextLine();
            if(numberToFind.equals("q"))
                break;
            long start = System.nanoTime();
            boolean res = triplet.first.contains(numberToFind);
            long end = System.nanoTime();
            System.out.format("Поиск перебором: номер найден - %b, поиск занял: %d нс\n", res, end - start);

            start = System.nanoTime();
            int index = Collections.binarySearch(sorted, numberToFind);
            end = System.nanoTime();
            System.out.format("Бинарный поиск: номер найден - %b, поиск занял: %d нс\n", index >= 0, end - start);

            start = System.nanoTime();
            res = triplet.second.contains(numberToFind);
            end = System.nanoTime();
            System.out.format("Поиск в HashSet: номер найден - %b, поиск занял: %d нс\n", res, end - start);

            start = System.nanoTime();
            res = triplet.third.contains(numberToFind);
            end = System.nanoTime();
            System.out.format("Поиск в TreeSet: номер найден - %b, поиск занял: %d нс\n", res, end - start);
        }

        in.close();
    }
}
