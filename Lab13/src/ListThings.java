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

    void addList(int index, String task) {
        things.add(index - OFFSET, task);
    }

    void addList(String task) {
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
    public static void main(String []args) {
        ListThings listThings = new ListThings();
        Scanner in = new Scanner(System.in);
        String command = null;
        String task;
        int index;

        listThings.initialFilling();

        boolean flag = true;
        while (flag){
            command = in.next();

            switch (command) {
                case "LIST":
                    listThings.getList();
                    break;
                case "EDIT":
                    index = in.nextInt();
                    task = in.nextLine();

                    listThings.changList(index, task);
                    listThings.getList();
                    break;
                case "DELETE":
                    index = in.nextInt();

                    listThings.deletList(index);
                    listThings.getList();
                    break;
                case "ADD":
                    String[] temp = in.nextLine().strip().split(" ", 1);
                    if (temp.length == 1) {
                        listThings.addList(temp[0]);
                    } else if (temp.length > 1) {
                        listThings.addList(Integer.parseInt(temp[0]), temp[1]);
                    }

                    listThings.getList();
                    break;
                case "EXIT":
                    flag = false;
                    break;
            }
        }
    }
}
