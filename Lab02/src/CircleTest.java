import java.util.Scanner;
class Circle {
    public double radius, diam, lina, square, pi = 3.14;
    Circle(double radius_1) {
        radius = radius_1;
    }
    void getDiam() {
        diam = radius * 2;
        System.out.println(diam);
    }
    void getLina() {
        lina = 2 * pi * radius;
        System.out.println(lina);
    }
    void getSquare() {
        square = pi * Math.pow(radius, 2);
        System.out.println(square);
    }
    void setRadius(double radius_1) {
        radius = radius_1;
    }
}
public class CircleTest {
    static void collection(Circle inf) {
        inf.getDiam();
        inf.getLina();
        inf.getSquare();
    }
    public static void main(String[] args) {
        Scanner rad = new Scanner(System.in);
        System.out.println("Введите радиус: ");
        double rad_1 = rad.nextDouble();
        Circle inf = new Circle(rad_1);
        for(int i = 0; i < 2; i++) {
            if(i == 1) {
                rad_1 = rad.nextDouble();
                inf.setRadius(rad_1);
                collection(inf);
            }
            else {
                collection(inf);
            }
        }
    }
}