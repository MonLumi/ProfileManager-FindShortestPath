public class Node {
    private Person person;
    private Node left;
    private Node right;

    public Node(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String getID() {
        return this.person.getId();
    }

    public void display() {
        person.display();
    }
}
