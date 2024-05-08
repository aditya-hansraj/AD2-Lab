import java.util.Arrays;
import java.util.LinkedList;

public class MST_Krushkal {
    int count;
    private LinkedList<LinkedList<Edge>> Adj;
    int inf = Integer.MAX_VALUE;

    private static class Edge implements Comparable<Edge> {
        int src, dest, cost;

        public Edge(int s, int d, int c) {
            src = s;
            dest = d;
            cost = c;
        }

        public int compareTo(Edge compareEdge) {
            return this.cost - compareEdge.cost;
        }
    }

    public MST_Krushkal(int cnt) {
        count = cnt;
        Adj = new LinkedList<>();
        for (int i = 0; i < cnt; i++) {
            Adj.add(new LinkedList<>());
        }
    }

    private void addDirectedEdge(int source, int dest, int cost) {
        Edge edge = new Edge(source, dest, cost);
        Adj.get(source).add(edge);
    }

    public void addDirectedEdge(int source, int dest) {
        addDirectedEdge(source, dest, 1);
    }

    public void addUndirectedEdge(int source, int dest, int cost) {
        addDirectedEdge(source, dest, cost);
        addDirectedEdge(dest, source, cost);
    }

    public void addUndirectedEdge(int source, int dest) {
        addUndirectedEdge(source, dest, 1);
    }

    public static class Sets {
        int parent;
        int rank;

        Sets(int p, int r) {
            parent = p;
            rank = r;
        }
    }

    public int find(Sets[] sets, int index) {
        int p = sets[index].parent;
        while (p != index) {
            index = p;
            p = sets[index].parent;
        }
        return index;
    }

    public void union(Sets[] sets, int x, int y) {
        if (sets[x].rank < sets[y].rank)
            sets[x].parent = y;
        else if (sets[x].rank > sets[y].rank)
            sets[y].parent = x;
        else {
            sets[x].parent = y;
            sets[y].rank++;
        }
    }

    public String kruskal() {
        Sets[] sets = new Sets[count];
        for (int i = 0; i < count; i++) {
            sets[i] = new Sets(i, 0);
        }

        Edge[] edges = new Edge[100];
        int E = 0;
        for (int i = 0; i < count; i++) {
            LinkedList<Edge> ad = Adj.get(i);
            for (Edge adn : ad) {
                edges[E++] = adn;
            }
        }
        Arrays.sort(edges, 0, E);

        StringBuilder output = new StringBuilder("Minimum Spanning Tree (MST) Edges:\n");
        int sum = 0;
        for (int i = 0; i < E; i++) {
            int x = find(sets, edges[i].src);
            int y = find(sets, edges[i].dest);
            if (x != y) {
                output.append("(").append(edges[i].src).append("->").append(edges[i].dest).append(": ").append(edges[i].cost).append(")"+"\n");
                sum += edges[i].cost;
                union(sets, x, y);
            }
        }
        output.append("Total Cost of MST: ").append(sum).append("\n");
        return output.toString();
    }

    
    

    public static void main(String[] args) {
        MST_Krushkal gph = new MST_Krushkal(9);
        gph.addUndirectedEdge(7, 1, 11);
        gph.addUndirectedEdge(0, 7, 8);
        gph.addUndirectedEdge(1, 2, 8);
        gph.addUndirectedEdge(7, 8, 7);
        gph.addUndirectedEdge(7, 6, 1);
        gph.addUndirectedEdge(8, 6, 6);
        gph.addUndirectedEdge(8, 2, 2);
        gph.addUndirectedEdge(2, 5, 4);
        gph.addUndirectedEdge(6, 5, 2);
        gph.addUndirectedEdge(5, 3, 14);
        gph.addUndirectedEdge(5, 4, 10);
        gph.addUndirectedEdge(4, 3, 9);
        gph.addUndirectedEdge(2, 3, 7);
        System.out.println(gph.kruskal());
    }
}
