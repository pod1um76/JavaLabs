import java.util.ArrayList;
import java.util.Scanner;

public class ListThings {
    private static final int OFFSET = 1;
    ArrayList<String> things = new ArrayList<>();

    void initialFilling() {
        things.add("Уборка в комнате");
        things.add("Зарядка");
        things.add("Завтрак");
        things.add("Сходить в магазин");
        things.add("Приготовить обед");
        things.add("Сделать домашнее задание");
    }

    void getList() {
        for (int i = 0; i < things.size(); i++) {
            System.out.println(i + OFFSET + "." + things.get(i));
        }
        System.out.println("UpdateList");
    }

    void addListIndex(int index, String task) {
            things.add(index - OFFSET, task);
    }

    void addListEnd(String task) {
        things.add(task);
    }

    void changList(int index, String task) {
        things.set(index - OFFSET, task);
    }

    void deletList(int index) {
        things.remove(index - OFFSET);
    }
}

class TestListThings {

    private static final String LIST = "LIST";
    private static final String ADD = "ADD";
    private static final String EDIT = "EDIT";
    private static final String DELETE = "DELETE";
    private static final String COMPLETION = "STOP";

    public static void main(String []args) {
        ListThings listThings = new ListThings();
        Scanner in = new Scanner(System.in);
        String command = null;
        String task;
        int index;

        listThings.initialFilling();


        while (true){
            command = in.next();

            switch (command) {
                case LIST:
                    listThings.getList();
                    break;
                case EDIT:
                    index = in.nextInt();
                    task = in.nextLine();

                    listThings.changList(index, task);
                    listThings.getList();
                    break;
                case DELETE:
                    index = in.nextInt();

                    listThings.deletList(index);
                    listThings.getList();
                    break;
                case ADD:
                    index = in.nextInt();
                    task = in.nextLine();

                    listThings.addListIndex(index, task);
                    listThings.getList();
                    break;
            }
        }
    }
}
