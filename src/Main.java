import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner mainChoice = new Scanner(System.in);
    static Scanner functionChoice = new Scanner(System.in);
    static Tree tree = new Tree();

    public static void main(String[] args) throws IOException {
        Database.firstDatabase();
        Graph.importFile();
        Graph.declareVert();
        Graph.addVertInfo();

        int choice;
        do {
            menu();
            choice = Integer.parseInt(mainChoice.nextLine());
            System.out.println();
            switch (choice) {
                //Add new Employee
                case 1 -> {
                    int isRepeat;
                    do {
                        System.out.println("Add new Employee");
                        lineBreak();
                        Tools.addEmployee();
                        lineBreak();
                        System.out.println();
                        System.out.print("Do you want to add another staff? (\"1\" for Yes): ");
                        isRepeat = Integer.parseInt(functionChoice.nextLine());
                    } while (isRepeat == 1);
                }

                //Inorder
                case 2 -> {
                    int isRepeat;
                    do {
                        System.out.println("Deep First Travel");
                        lineBreak();
                        System.out.println("What type do you want to travel? ");
                        System.out.println("1. Pre-order");
                        System.out.println("2. In-order");
                        System.out.println("3. Post-order");
                        System.out.println();
                        System.out.println("0. Exit");
                        lineBreak();
                        System.out.print("Your choice: ");
                        int travelChoice = Integer.parseInt(functionChoice.nextLine());
                        System.out.println();
                        switch (travelChoice) {
                            case 1 -> {
                                System.out.println("Pre-Order Travel");
                                lineBreak();
                                tree.preOrder();
                            }
                            case 2 -> {
                                System.out.println("In-Order Travel");
                                lineBreak();
                                tree.inOrder();
                            }
                            case 3 -> {
                                System.out.println("Post-Order Travel");
                                lineBreak();
                                tree.postOrder();
                            }
                            case 0 -> {}
                            default -> System.out.println("Your choice isn't valid, please try again!");
                        }
                        if (travelChoice > 0 && travelChoice < 4) {
                            System.out.print("Do you want to travel another type? (\"1\" for Yes): ");
                            isRepeat = Integer.parseInt(functionChoice.nextLine());
                        } else if (travelChoice != 0) isRepeat = 1;
                        else break;
                    } while (isRepeat == 1);
                }

                //Bread First Travel
                case 3 -> {
                    System.out.println("Bread First Travel");
                    lineBreak();
                    tree.breadFirstTravel();
                    lineBreak();
                    System.out.print("Press Enter... ");
                    functionChoice.nextLine();
                }

                //Find ID
                case 4 -> {
                    int isRepeat;
                    do {
                        System.out.println("Search ID");
                        lineBreak();
                        Tools.findID();

                        System.out.print("Do you want to find another staff? (\"1\" for Yes): ");
                        isRepeat = Integer.parseInt(functionChoice.nextLine());
                        System.out.println();
                    } while (isRepeat == 1);
                }

                //Deleted ID
                case 5 -> {
                    int isRepeat;
                    do {
                        System.out.println("Delete ID");
                        lineBreak();
                        Tools.deletedID();

                        System.out.print("Do you want to delete another staff? (\"1\" for Yes): ");
                        isRepeat = Integer.parseInt(functionChoice.nextLine());
                        System.out.println();
                    } while (isRepeat == 1);
                }

                //Balance Tree
                case 6 -> {
                    System.out.println("Balance Tree");
                    tree.balanceHelper();
                }

                //Travel Graph
                case 7 -> {
                    int isRepeat;
                    do {
                        Graph.resetGraphStatus();
                        System.out.println("Graph Travel");
                        lineBreak();
                        System.out.println("What type do you want to travel?");
                        System.out.println("1. Deep First Travel");
                        System.out.println("2. Bread First Travel");
                        System.out.println();
                        System.out.println("0. Exit");
                        lineBreak();
                        System.out.print("Your choice: ");
                        int travelChoice = Integer.parseInt(functionChoice.nextLine());
                        switch (travelChoice) {
                            case 1 -> {
                                System.out.println();
                                System.out.println("Deep First Travel from A");
                                Graph.deepFirstTravel(Graph.adjList.get(0));
                                System.out.println();
                            }
                            case 2 -> {
                                System.out.println();
                                System.out.println("Bread First Travel from A");
                                Graph.breadFirstTravel(Graph.adjList.get(0));
                                System.out.println();
                            }
                            case 0 -> {}
                            default -> System.out.println("Your choice isn't correct");
                        }
                        if (travelChoice == 1 || travelChoice == 2) {
                            lineBreak();
                            System.out.print("Do you want to travel by another type (\"1\" for Yes): ");
                            isRepeat = Integer.parseInt(functionChoice.nextLine());
                            System.out.println();
                        } else if (travelChoice != 0) {
                            isRepeat = 1;
                            System.out.println();
                        }
                        else break;

                    } while (isRepeat == 1);
                }

                //Find the shortest path
                case 8 -> {
                    Graph.resetGraphStatus();
                    System.out.println("Find Shorted path from A to E");
                    lineBreak();
                    Graph.DijkstraResult();
                    lineBreak();
                    System.out.print("Press Enter...");
                    functionChoice.nextLine();
                }

                //exit
                case 0 -> {}

                //type mistake
                default -> System.out.println("Your input isn't correct, please try again!");
            }
            System.out.println();

        } while (choice != 0);
        System.out.println("Good bye");
    }

    public static void menu() {
        System.out.println("What do you want?");
        lineBreak();
        System.out.printf("%-50s%s%n","1. Add new employee","5. Delete ID");
        System.out.printf("%-50s%s%n","2. Deep First Travel", "6. Balance Tree");
        System.out.printf("%-50s%s%n","3. Bread First Search", "7. Graph Deep First Travel");
        System.out.printf("%-50s%s%n","4. Search ID", "8. Find shorted path");
        System.out.println();
        System.out.println("0. Exit");
        lineBreak();
        System.out.print("Your choice: ");
    }

    public static void lineBreak() {
        System.out.println("--------------------");
    }
}
