class Book {
    String author = "Tolstoy- ", name = "war and peace, ";
    int pages = 1500, volumes = 4;
    void parameters() {
        System.out.print(author + name + "страниц: " + pages + " ," + "томов: " + volumes );
    }
}
class bookTest {
    public static void main(String[] args) {
        Book show = new Book();
        show.parameters();
    }
}