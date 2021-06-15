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
        if (node.getID() == person.getId()) {
            System.out.println("Duplicate ID, can't add new employee!");
            return node;
        } else {
            if (node.getID() > person.getId()) node.setLeft(insertRecursion(node.getLeft(), person));
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

    public Node search(int id) {
        Node curr = root;
        while (curr != null && curr.getID() != id) {
            if (id < curr.getID()) curr = curr.getLeft();
            else  curr = curr.getRight();
        }
        return curr;
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
}
