import java.util.*;

public class MST_Prims {

    public static void main(String[] args) {
        MST_Prims gph = new MST_Prims(9);

        System.out.println();
        gph.primeMST();
        System.out.println();
    }

    int count;
    private LinkedList<LinkedList<Edge>> Adj;

    private static class Edge {
        private int dest;
        private int cost;

        public Edge(int dst, int cst) {
            dest = dst;
            cost = cst;

        }

        public Edge(int source, int dest2, int alt) {
            // TODO Auto-generated constructor stub
        }
    }

    public MST_Prims(int cnt) {
        count = cnt;
        Adj = new LinkedList<LinkedList<Edge>>();
        for (int i = 0; i < cnt; i++) {
            Adj.add(new LinkedList<Edge>());
        }
    }

    private void addDirectedEdge(int source, int dest, int cost) {
        Edge edge = new Edge(dest, cost);
        Adj.get(source).add(edge);
    }

    public void addDirectedEdge(int source, int dest) {
        addDirectedEdge(source, dest, 1);
    }

    public void addUndirectedEdge(int source, int dest, int cost) {
        addDirectedEdge(source, dest, cost);
        addDirectedEdge(source, dest, cost);
    }

    public void addUndirectedEdge(int source, int dest) {
        addUndirectedEdge(source, dest, 1);
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            LinkedList<Edge> ad = Adj.get(i);
            System.out.print("\n Vertex " + i + " is connected to ");
            for (Edge adn : ad) {
                System.out.print("(" + adn.dest + "," + adn.cost + ")");
            }
        }
    }

    public void primeMST() {
        int[] prev = new int[count];
        int[] dist = new int[count];
        boolean[] v = new boolean[count];
        Arrays.fill(prev, -1);
        Arrays.fill(dist, Integer.MAX_VALUE);
        int source = 0;
        dist[source] = 0;
        prev[source] = source;
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
        Edge node = new Edge(source, source, 0);
        queue.add(node);
        while (queue.isEmpty() != true) {
            node = queue.peek();
            queue.remove();
            v[source] = true;
            source = node.dest;
            LinkedList<Edge> adl = Adj.get(source);
            for (Edge adn : adl) {
                int dest = adn.dest;
                int alt = adn.cost;
                if (dist[dest] > alt && v[dest] == false) {
                    dist[dest] = alt;
                    prev[dest] = source;
                    node = new Edge(source, dest, alt);
                    queue.add(node);
                }
            }
        }

        int sum = 0;
        boolean isMst = true;
        String op = "Edges are : ";
        for (int i = 0; i < count; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                op += ("(" + prev[i] + "->" + i + "@" + ")");
            } else if (prev[i] != i) {
                op += ("(" + prev);
                sum += dist[i];
                System.out.println("(" + prev + "," + i + "," + dist[i] + ")");
            }
        }

    }
}