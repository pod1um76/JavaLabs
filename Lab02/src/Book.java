import  java.util.Scanner;
class Book {
    String author = "Tolstoy- ", name = "war and peace, ";
    int pages = 1500, volumes = 4, year = 1867;
    String aftor() {
        return author;
    }
    String emya() {
        return name;
    }
    int str() {
        return pages;
    }
    int tom() {
        return volumes;
    }
    int god() {
        return year;
    }
    void chenge(String author_1, String name_1, int pages_1, int volumes_1, int year_1) {
        author = author_1;
        name = name_1;
        pages = pages_1;
        volumes = volumes_1;
        year = year_1;
    }
    void show() {
        System.out.println(aftor() + " " + emya() + " " + str() + " " + tom() + " " + god());
    }
}
class BookTest {
    public static void main(String[] args) {
        Book writen = new Book();
        writen.show();
        Scanner in = new Scanner(System.in);
        System.out.println("Укажите автора");
        String author_1 = in.next();
        System.out.println("Укажите название книги");
        String name_1 = in.next();
        System.out.println("Укажите кол-во страниц");
        int pages_1 = in.nextInt();
        System.out.println("Укажите кол-во томов");
        int volumes_1 = in.nextInt();
        System.out.println("Укажите год выпуска");
        int years_1 = in.nextInt();
        writen.chenge(author_1, name_1, pages_1, volumes_1, years_1);
        writen.show();

    }
}