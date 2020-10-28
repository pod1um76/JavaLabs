import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Collection {

    Map<Integer, String> map = new TreeMap<>();

    void installation() {
        map.put(798561177, "Вася" );
        map.put(798535789, "Петя" );
        map.put(798591063, "Аркаша" );
        map.put(798512314, "Миша" );
        map.put(798570056, "Гоша" );
        map.put(798511128, "Коля" );
    }

    void addCollection() {

    }

}

class TestCollection {

    public static void main()  {
        Scanner in = new Scanner(System.in);
        Collection collection = new Collection();
        String name;
        int phoneNumber;

        collection.installation();

        boolean flag = true;
        while (flag) {
            

        }
    }
}
