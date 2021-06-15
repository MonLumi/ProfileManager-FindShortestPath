import java.util.Scanner;

public class Tools {
    static Scanner keyboard = Main.keyboard;
    static Tree tree = Main.tree;

    public static void addEmployee() {
        System.out.print("ID: ");
        int id = Integer.parseInt(keyboard.nextLine());
        if (Main.tree.search(id) != null) {
            System.out.println("Duplicate ID, try Again");
            return;
        }

        System.out.print("Name: ");
        String name = keyboard.nextLine();

        tree.insert(new Person(id, name));
    }

}
