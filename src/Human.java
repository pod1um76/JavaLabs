 class Head {
    String color = "Русый ", longe = "Средняя ", shape = "круглая ", size = "Маленькая";
    public String getHair() {
        return color + longe;
    }
    String getShape() {
        return shape;
    }
    String getSize() {
        return size;
    }
    void show()  {
        System.out.println(getHair() + getShape() + getSize());
    }

}
class Leg {
    String longe = "Длинная ", weight = "Толстая";
    String getLonge() {
        return longe;
    }
    String getWeight() {
        return weight;
    }
    void show()  {
        System.out.println(getLonge() + getWeight());
    }
}
class Hand {
    String longe_ = "Короткая ", weight_ = "Худая";
    String getLonge_() {
        return longe_;
    }
    String getWeight_() {
        return weight_;
    }
    void show()  {
        System.out.println(getLonge_() + getWeight_());
    }
}
class Human {
    void call() {
        Head social = new Head();
        social.getHair();
        social.getShape();
        social.getSize();
        social.show();
        Leg social_2 = new Leg();
        social_2.getLonge();
        social_2.getWeight();
        social_2.show();
        Hand social_3 = new Hand();
        social_3.getLonge_();
        social_3.getWeight_();
        social_3.show();
    }
}
class HumanTest {
    public static void main(String[] args) {
        Human test = new Human();
        test.call();
    }
}