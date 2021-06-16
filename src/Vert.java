import java.util.ArrayList;

public class Vert {
    boolean isVisited;
    String name;
    ArrayList<Edge> edgeList = new ArrayList<>();

    public Vert(String name) {
        this.isVisited = false;
        this.name = name;
    }

    public void addNeighbour(Edge edge) {
        edgeList.add(edge);
    }

    public void setVisited() {
        this.isVisited = true;
    }

    public Vert getNext(Edge link) {
        return link.end;
    }


    public void fullDisplay() {
        System.out.println("Vert " + name);
        System.out.print("Edges: ");
        for (Edge edge : edgeList) edge.display();
        System.out.println();
    }
}
