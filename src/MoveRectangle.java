import java.util.Scanner;

interface Movable {
    int move(int movablePointХle, int movablePointYle, int movablePointХra, int movablePointYra, int x1, int y1);
}
class MovableRectangle implements Movable {
    int tester(int one, int two) {
        Scanner in = new Scanner(System.in);
        if(one != two) {
            while (one != two) {
                System.out.println("Точки должны двигаться с одинаковой скоростью, повторите ввод: ");
                one = in.nextInt();
                two = in.nextInt();
            }
        }
        return one;
    }

    public int move(int movablePointХle, int movablePointYle, int movablePointХra, int movablePointYra, int x1, int y1) {
        movablePointХle += x1;
        movablePointХra += x1;
        movablePointYle += y1;
        movablePointYra += y1;
        show(movablePointХle,  movablePointХra,  movablePointYle,  movablePointYra);
        return  0;
    }
    public void show(int movablePointХle, int movablePointХra, int movablePointYle, int movablePointYra) {
        System.out.println("x1 и x2: " + movablePointХle + " " + movablePointХra + " y1 и y2: " + movablePointYle + " " + movablePointYra);
    }
}
class TestMovableRectangle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите координаты х и у для точки левого верхнего угла прямоугольника: ");
        int movablePointХle = in.nextInt();
        int movablePointYle = in.nextInt();
        System.out.println("Введите координаты х и у для точки правого нижнего угла прямоугольника: ");
        int movablePointХra = in.nextInt();
        int movablePointYra = in.nextInt();
        System.out.println("Введите сдвиг по х для левой верхней и правой нижней точки: ");
        int one = in.nextInt();
        int two = in.nextInt();
        MovableRectangle square = new MovableRectangle();
        int a = square.tester(one, two);
        System.out.println("Введите сдвиг по y для левой верхней и правой нижней точки: ");
        one = in.nextInt();
        two = in.nextInt();
        int b = square.tester(one, two);
        square.move(movablePointХle,  movablePointYle,  movablePointХra, movablePointYra, a, b);
    }
}