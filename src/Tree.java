import java.util.ArrayList;
import java.util.LinkedList;

public class Tree {
    private Node root;

    public Tree() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(Person person) {
        root = insertRecursion(root, person);
    }

    private Node insertRecursion(Node node, Person person) {
        if (node == null) {
            node = new Node(person);
            return node;
        }
        if (node.getID().equalsIgnoreCase(person.getId())) {
            System.out.println("Duplicate ID, can't add new employee!");
            return node;
        } else {
            if (node.getID().compareToIgnoreCase(person.getId()) > 0) node.setLeft(insertRecursion(node.getLeft(), person));
            else node.setRight(insertRecursion(node.getRight(), person));
        }
        return node;
    }

    public void inOrder() {
        inOrderHelper(root);
    }

    private void inOrderHelper(Node node) {
        if (node == null) return;

        inOrderHelper(node.getLeft());
        node.display();
        inOrderHelper(node.getRight());
    }

    public void preOrder() {
        preOrderHelper(root);
    }

    private void preOrderHelper(Node node) {
        if (node == null) return;

        node.display();
        preOrderHelper(node.getLeft());
        preOrderHelper(node.getRight());
    }

    public void postOrder() {
        postOrderHelper(root);
    }

    private void postOrderHelper(Node node) {
        if (node == null) return;

        postOrderHelper(node.getLeft());
        postOrderHelper(node.getRight());
        node.display();
    }

    //I use iterative not recursive
    public Node search(String id) {
        Node curr = root;
        while (curr != null && !curr.getID().equalsIgnoreCase(id)) {
            if (id.compareToIgnoreCase(curr.getID()) < 0) curr = curr.getLeft();
            else  curr = curr.getRight();
        }
        return curr;
    }

    public ArrayList<Node> searchContain(String id) {
        ArrayList<Node> results = new ArrayList<>();
        Node curr = root;
        while (curr != null) {
            if (curr.getID().contains(id) || id.contains(curr.getID())) {
                results.add(curr);
            }
            if (id.compareToIgnoreCase(curr.getID()) < 0) curr = curr.getLeft();
            else  curr = curr.getRight();
        }
        return results;
    }

    public void breadFirstTravel() {
        LinkedList<Node> list = new LinkedList<>();

        list.add(root);
        while (list.size() > 0) {
            Node curr = list.pop();
            if (curr.getLeft() != null) list.addLast(curr.getLeft());
            if (curr.getRight() != null) list.addLast(curr.getRight());
            curr.display();
        }
    }

    public void delete(String id) {
        if (root.getID().equalsIgnoreCase(id)) {
            Node successor = root.getRight();
            while (successor.getLeft() != null) {
                successor = successor.getLeft();
            }
            successor.setLeft(root.getLeft());
            root = root.getRight();
            return;
        }
        deleteHelper(root, id);
    }

    //need to read
    private Node deleteHelper(Node node, String id) {
        if (node == null) return null;

        if (id.compareToIgnoreCase(node.getID()) < 0) {
            node.setLeft(deleteHelper(node.getLeft(), id));
        } else if (id.compareToIgnoreCase(node.getID()) > 0) {
            node.setRight(deleteHelper(node.getRight(), id));
        } else {
            if (node.getLeft() == null) return node.getRight();
            else if (node.getRight() == null) return node.getLeft();

            // the deleted node have 2 child
            else {
                Node successor = node.getRight();
                while (successor.getLeft() != null) {
                    successor = successor.getLeft();
                }

                String key = successor.getID();
                node.setRight(deleteHelper(node.getRight(), key));
            }
        }
        return node;
    }

    public void balanceHelper() {
        ArrayList<Node> nodeList = new ArrayList<>();
        inOrderPop(root, nodeList);

        Tree temp = new Tree();
        partition(nodeList, 0, nodeList.size(), temp);

        Main.tree = temp;
        System.out.println("Balance successful!");
        Main.lineBreak();
        System.out.print("Press Enter...");
        Main.functionChoice.nextLine();
    }

    private void inOrderPop(Node node, ArrayList<Node> list) {
        if (node == null) return;

        inOrderPop(node.getLeft(), list);
        list.add(node);
        inOrderPop(node.getRight(), list);
    }

    private void partition(ArrayList<Node> list, int start, int end, Tree tree) {
        if (start >= end) return;

        int midIndex = (start + end)/2;
        tree.insert(list.get(midIndex).getPerson());
        partition(list, start, midIndex, tree);
        partition(list, midIndex + 1, end, tree);
    }
}
