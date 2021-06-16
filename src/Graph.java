import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    static int[][] weightMatrix;
    static final int INF = 9999;
    static ArrayList<Vert> vertList = new ArrayList<>();

    static LinkedList<Vert> stack = new LinkedList<>();

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

    public static void deepFirstTravel() {
        Vert start = vertList.get(0);
        dfs(start);
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

    public static void declareVert() {
        for (int vertIndex = 0; vertIndex < weightMatrix.length; vertIndex++) {
            vertList.add(new Vert(((char)(65 + vertIndex))+"")) ;
        }
    }

    public static void addVertInfo() {
        for (int vertIndex = 0; vertIndex < vertList.size(); vertIndex++) {
            Vert current = vertList.get(vertIndex);
            int[] vertInfo = weightMatrix[vertIndex];
            for (int end = 0; end < vertInfo.length; end ++) {
                int weight = vertInfo[end];
                if (weight != INF && weight != 0) {
                    Edge availableEdge = new Edge(current, vertList.get(end), weight);
                    current.addNeighbour(availableEdge);
                }
            }
        }
    }

    public static void display() {
        for (Vert vert : vertList) vert.fullDisplay();
    }
}
