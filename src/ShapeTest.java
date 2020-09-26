class Shape {
     int size = 10, square = 15 ;
     void ToString() {
        System.out.print(size + " " + square);
     }
}
class ShapeTest {
    public static void main(String[] args) {
        Shape show = new Shape();
        show.ToString();
    }
}