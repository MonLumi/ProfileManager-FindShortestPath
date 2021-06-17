import java.util.Scanner;

public class Tools {
    static Scanner keyboard = Main.functionChoice;
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
        Main.lineBreak();
        System.out.println("Add new staff successful");
        System.out.printf("%-10s%s%n", id, name);
    }

    public static void findID() {
        System.out.print("ID: ");
        int id = Integer.parseInt(keyboard.nextLine());
        Node result = tree.search(id);
        Main.lineBreak();
        if (result == null) System.out.println("The ID isn't exist!");
        else {
            System.out.println("Found staff");
            result.display();
        }
        System.out.println();
    }

    public static void deletedID() {
        System.out.print("ID: ");
        int id = Integer.parseInt(keyboard.nextLine());
        Node result = tree.search(id);
        Main.lineBreak();
        if (result == null) System.out.println("The ID isn't exist!");
        else {
            System.out.println("Staff deleted");
            result.display();
            tree.delete(id);
        }
        System.out.println();
    }
}
