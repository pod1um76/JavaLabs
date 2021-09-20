import java.util.ArrayList;
import java.util.Scanner;

class Dog {
    private String name;
    private int age, trans_age;

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void getName_Age(String name_2, int age_2) {
        name = name_2;
        age = age_2;
        show();
    }

    int translate() {
        trans_age = age * 7;
        return trans_age;
    }

    String toString() {

        return (name + " " + age + " " + translate());
    }
    void  show() {
        System.out.println(ToString());
    }
}

class dog_kannel {
    static void show_mass(String mass[]) {
        for (int i = 0; i < 3; i++) {
            System.out.println(mass[i]);
        }
    }

    public static void main(String[] args) {
        Scanner bob = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name_1 = bob.next();
        System.out.println("Введите возраст: ");
        int age_1 = bob.nextInt();
        Dog inf = new Dog(name_1, age_1);
        inf.translate();
        inf.ToString();
        inf.show();
        System.out.println("Введите возраст: ");
        age_1 = bob.nextInt();
        System.out.println("Введите имя: ");
        name_1 = bob.next();
        inf.getName_Age(name_1, age_1);
        Dog mass[] = new Dog[3];
        mass[0] = new Dog("strgtgth");
        mass[1] = new Dog();
        mass[2] = new Dog();
        System.out.println(mass[0]);

    }
}
