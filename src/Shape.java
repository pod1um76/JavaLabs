import java.util.Scanner;

abstract class Shape {

    public abstract int getArea();
    public abstract int getLongSide();

}

class Circle extends Shape {
    private int rad;
    Circle(int rad_) {
        this.rad = rad_;
    }
    public int getRad(){
        return rad;
    }
    public void setRad(int rad1) {
        this.rad = rad1;
    }
    public int getLongSide() {
        System.out.println("Длина окружности равна: " + 2 * Math.PI * rad);
        return 0;
    }

    public int getArea() {
        System.out.println("Площадь окружности равна: " + Math.PI * Math.pow(rad, 2));
        return 0;
    }

}
class Square extends Shape {
    private int sideA;
    Square(int side) {
        this.sideA = side;
    }
    public int getRad(){
        return sideA;
    }
    public void setRad(int side) {
        this.sideA = side;
    }
    public int getArea() {
        System.out.println("Площадь квадрата равна: " + Math.pow(sideA, 2));
        return 0;
    }

    public int getLongSide() {
        System.out.println("Периметр квадрата равна: " + sideA * 4);
        return 0;
    }
}
class Rectangle extends Shape {
    private int sideA, sideB;

    Rectangle(int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public int getSideA() {
        return sideA;
    }

    public void setSideA(int sideA) {
        this.sideA = sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public void setSideB(int sideB) {
        this.sideB = sideB;
    }

    public int getArea() {
        System.out.println("Площадь прямоугольника равна: " + sideA * sideB);
        return 0;
    }
    public int getLongSide() {
        System.out.println("Периметр прямоугольника равна: " + sideA * sideB);
        return 0;
    }
}

class TestShape {
    public static  void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("введите радиус: ");
        int rad = input.nextInt();
        System.out.println("Ведите сторону для квадрата и 2-ую сторону для прямоугольник: ");
        int side_a = input.nextInt();
        int side_b = input.nextInt();
        Circle test = new Circle(rad);
        test.getLongSide();
        test.getArea();
        Square test_1 = new Square(side_a);
        test_1.getArea();
        test_1.getLongSide();
        Rectangle test_2 = new Rectangle(side_a, side_b);
        test_2.getArea();
        test_2.getLongSide();
    }
}
