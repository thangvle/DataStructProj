package Graph;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;

import javax.media.j3d.Link;
import java.util.*;

public class GraphSetup {


    static <V,E> void BFS (Graph<V,E> g , V start){

        Queue<V> queue = new LinkedList();
        Set<V> identified = new HashSet<>();
        List<V> visited = new ArrayList<>();
        identified.add(start);
        visited.add(start);
        queue.offer(start);

        while (queue.size() != 0) {
            V current = queue.poll();
            visited.add(current);


            for(V neighbor : new ArrayList<>(g.getNeighbors(current))){
                if (!identified.contains(neighbor) || !visited.contains(neighbor)) {
                    identified.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        //  TODO fix printing visited duplicated
        //System.out.println(queue);
        for (V s : visited) {
            System.out.print(s);
        }

    }

    static <V, E> void DFS (Graph g, List<Integer> visitOrder, List discover, int u) {

        /**
         * Mark current vertex
         *
         * for each vertex, adj to current vertex,
         *      if v not visited,
         *          set parent of v to u
         *          recursive apply
         * Mark u as finish and add to finish list
         */

        //  TODO discovery list - stack
        //  TODO visited list - set
        //  TODO finish order -

        /*
        List<V> discovery = new ArrayList<>();
        List<V> visit = new ArrayList<>();
        discovery.add(start);



        for (V neighbors : new ArrayList<>(g.getNeighbors(start))){
            if (!discovery.contains(start)) {
                DFS(g, start);
            }
        }
        visit.add(start);
        System.out.println(visit);
        */

        List<Integer> neighbors;
        discover.add(u);
        neighbors = new ArrayList<>(g.getNeighbors(u));
        for (int v : neighbors){
            if (!discover.contains(v)){
                DFS(g, visitOrder, discover, v);
            }
        }
        visitOrder.add(u);

    }

    public static void main(String[] args) {
        SparseGraph<Integer, Integer> giraff = new SparseGraph<>();
        SparseGraph<Integer, Integer> g = new SparseGraph<>();

        List<Integer> visitOrder = new ArrayList<>();
        List discover = new ArrayList();
        int u = 0;
        //left side
        giraff.addEdge(1, 0, 1);
        giraff.addEdge(2, 0, 3);
        giraff.addEdge(3, 3, 2);
        giraff.addEdge(4, 1, 2);
        giraff.addEdge(5, 2, 9);
        giraff.addEdge(6, 2, 8);
        //right side
        giraff.addEdge(7, 1, 4);
        giraff.addEdge(8, 1, 7);
        giraff.addEdge(9, 1, 6);
        giraff.addEdge(10, 4, 5);
        giraff.addEdge(11, 4, 7);
        giraff.addEdge(12, 6, 4);
        giraff.addEdge(13, 6, 7);

        g.addEdge(1, 0, 1);
        g.addEdge(2, 0, 4);
        g.addEdge(3, 0, 3);
        g.addEdge(4, 1, 4);
        g.addEdge(5, 3, 1);
        g.addEdge(6, 3, 4);
        g.addEdge(7, 0, 2);
        g.addEdge(8, 2, 5);
        g.addEdge(9, 5, 6);
        g.addEdge(10, 2, 6);

        List<Integer> list = new ArrayList<>(giraff.getVertices());




        //System.out.println(giraff);

        BFS(giraff, 0);
        System.out.println();
        DFS(g, visitOrder, discover, u);
        System.out.println(visitOrder);
    }
}
