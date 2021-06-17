import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    static int[][] weightMatrix;
    static final int INF = 9999;
    static ArrayList<Vert> adjList = new ArrayList<>();
    static LinkedList<Vert> stack = new LinkedList<>();

    static LinkedList<Vert> knownVert = new LinkedList<>();
    public Graph() {}

    //import matran.txt file to 2D array
    public static void importFile() throws IOException {
        File file = new File("src/Matran.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        weightMatrix = new int[7][];
        for (int vertNumber = 0; vertNumber < 7; vertNumber++) {
            String[] temp = reader.readLine().split(" {4}");
            int[] edgesWeight = new int[temp.length];
            for (int i = 0; i < temp.length; i++) edgesWeight[i] = Integer.parseInt(temp[i]);
            weightMatrix[vertNumber] = edgesWeight;
        }
        reader.close();
    }

    public static void declareVert() {
        for (int vertIndex = 0; vertIndex < weightMatrix.length; vertIndex++) {
            adjList.add(new Vert(((char)(65 + vertIndex))+"")) ;
        }
    }

    public static void addVertInfo() {
        for (int vertIndex = 0; vertIndex < adjList.size(); vertIndex++) {
            Vert current = adjList.get(vertIndex);
            int[] vertInfo = weightMatrix[vertIndex];
            for (int end = 0; end < vertInfo.length; end ++) {
                int weight = vertInfo[end];
                if (weight != INF && weight != 0) {
                    Edge availableEdge = new Edge(current, adjList.get(end), weight);
                    current.addNeighbour(availableEdge);
                }
            }
        }
    }

    public static void deepFirstTravel() {
        Vert start = adjList.get(0);
        dfs(start);
        System.out.println();
    }

    private static void dfs(Vert vert) {
        stack.push(vert);
        vert.setVisited();
        System.out.print(vert.name + " ");
        for (Edge link : vert.edgeList) {
            Vert next = vert.getNext(link);
            if (next.isVisited) continue;
            dfs(next);
        }
    }

    public static void findPathRecursion(Vert start, Vert end) {
        knownVert.addLast(start);
        while (knownVert.peekLast() != end) {
            if (knownVert.size() == 0) break;
            Vert current = knownVert.peekLast();
            //relax all edge from current
            for (Edge link : current.edgeList) {
                Vert updateVert = current.getNext(link);
                //update minimum distance;
                if (updateVert.distance > link.weight + current.distance) {
                    updateVert.distance = current.distance + link.weight;
                    updateVert.isVisited = false;
                }
            }
            current.setVisited();
            Vert newCurrent = minDistance(current.edgeList);
            knownVert.addLast(newCurrent);
        }
    }

    public static Vert minDistance(ArrayList<Edge> edgeList) {
        Vert minVertDistance = null;
        int minDistance = INF;

        for (Edge edge : edgeList) {
            Vert check = (edge.end);
            if (check.isVisited) continue;

            boolean isHasNext = false;
            for (Edge linkNext : check.edgeList) {
                if (!check.getNext(linkNext).isVisited) {
                    isHasNext = true;
                    break;
                }
            }

            if (check.distance < minDistance && isHasNext) {
                minDistance = check.distance;
                minVertDistance = check;
            }
        }
        return minVertDistance;
    }

    public static void Dijkstra() {
        Vert start = adjList.get(0);
        Vert end = adjList.get(4);
        start.distance = 0;
        findPathRecursion(start, end);

        Vert out = knownVert.removeFirst();
        while (out != end) {
            System.out.print(out.name + "->");
            out = knownVert.removeFirst();
        }
        System.out.println(out.name);
        System.out.println("Total distance: " + out.distance);
    }
}
