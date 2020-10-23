class Ball {
    String type = "football, ", color = "black-white, ";
    int weight = 110, volume = 1000;
    void parameters() {
        System.out.print(type + color + "масса: " + weight + " "+ "объём: " + volume );
    }
}
class ballTest {
    public static void main(String[] args) {
        Ball show = new Ball();
        show.parameters();
    }
}