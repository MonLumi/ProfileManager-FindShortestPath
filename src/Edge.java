public class Edge {
    Vert start, end;
    int weight;

    public Edge(Vert start, Vert end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public void display() {
        System.out.print(start.name + end.name + " ");
    }
}
