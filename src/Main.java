import java.util.Scanner;

public class Main {
    static Scanner keyboard = new Scanner(System.in);
    static Tree tree = new Tree();

    public static void main(String[] args) {
        Database.firstDatabase();

        int choice;
        do {
            menu();
            choice = Integer.parseInt(keyboard.nextLine());
            switch (choice) {
                //Add new Employee
                case 1 -> {
                    int isRepeat;
                    do {
                        Tools.addEmployee();

                        System.out.print("Do you want to add another staff? (\"1\" for Yes): ");
                        isRepeat = Integer.parseInt(keyboard.nextLine());
                    } while (isRepeat == 1);
                }

                //Inorder
                case 2 -> {
                    tree.inOrder();
                    System.out.print("Press Enter... ");
                    keyboard.nextLine();
                }

                //Bread First Travel
                case 3 -> {
                    tree.breadFirstTravel();
                    System.out.print("Press Enter... ");
                    keyboard.nextLine();
                }

                //Find ID
                case 4 -> {
                    int isRepeat;
                    do {
                        Tools.findID();

                        System.out.print("Do you want to find another staff? (\"1\" for Yes): ");
                        isRepeat = Integer.parseInt(keyboard.nextLine());
                    } while (isRepeat == 1);
                }

                //Deleted ID
                case 5 -> {}

                //Balance Tree
                case 6 -> {}

                //
                case 7 -> {}


                case 8 -> {}

                //exit
                case 0 -> {}

                //type mistake
                default -> {}
            }
        } while (choice > 0);
    }


    public static void menu() {
        System.out.println("1. Add new employee");
        System.out.println("2. Travel");
        System.out.println("3. Bread First Search");
        System.out.println("4. Search ID");
        System.out.println("5. Delete ID");
        System.out.println("6. Balance Tree");
        System.out.println("7. Deep First Search");
        System.out.println("8. Find shorted path");
        System.out.println("0. Exit");
        lineBreak();
        System.out.print("Your choice: ");
    }

    public static void lineBreak() {
        System.out.println("--------------------");
    }
}
