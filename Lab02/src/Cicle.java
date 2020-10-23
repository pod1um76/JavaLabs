 public class Cicle {
    public static void first(int sum_1, int mass_1[]) {
        for(int i = 0; i < mass_1.length; i++ ) {
            sum_1 = sum_1 + mass_1[i];
        }
        System.out.println(sum_1);
    }
    public static void second(int sum_2, int mass_2[], int t) {
        while(t != mass_2.length) {
            sum_2 = sum_2 + mass_2[t];
            t++;
        }
        System.out.println(sum_2);
    }
    public static void theard(int sum_3, int mass_3[], int p) {
        do {
            sum_3 = sum_3 + mass_3[p];
            p++;
        } while (p != mass_3.length);
        System.out.print(sum_3);
    }
    public static void main(String[] args) {
        int[] mass = {1, 2, 3, 4, 5, 12};
        int sum  = 0, i = 0;
        first(sum, mass);
        second(sum, mass, i);
        theard(sum, mass, i);
    }
}