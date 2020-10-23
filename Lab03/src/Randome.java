import java.util.Random;
class Randome {
    public static void completion(int mass[]) {
        for (int i = 0; i < mass.length; i++) {
            mass[i] = (int) ( 7 + Math.random() * 23);
        }
    }
    public static void completion_too(int mass_2[]) {
        Random rand = new Random();
        rand.nextInt();
        for (int i = 0; i < mass_2.length; i++) {
            mass_2[i] = rand.nextInt(100);
        }
    }
    public static void show(int mass[]) {
        for(int i = 0; i < mass.length; i++) {
            System.out.print(mass[i] + " ");
        }
        System.out.println(" ");
    }
    public static void sort(int mass[]) {
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < mass.length-1; i++) {
                if(mass[i] > mass[i + 1]){
                    isSorted = false;
                    buf = mass[i];
                    mass[i] = mass[i + 1];
                    mass[i + 1] = buf;
                }
            }
        }
        show(mass);
    }
    public static void main(String [] args) {
        int mass[] = new int[10];
        int mass_2[] = new int[10];
        completion(mass);
        show(mass);
        sort(mass);
        completion_too(mass_2);
        show(mass_2);
        sort(mass_2);

    }
}