package Graph;

import edu.uci.ics.jung.graph.SparseGraph;

import javax.media.j3d.Link;
import java.util.*;

public class GraphSetup {



    static void BFS (int start, int graphSize){

        boolean visited[] = new boolean[graphSize];
        Queue<Integer> queue = new LinkedList();
        LinkedList<Integer> adj[] = new LinkedList[graphSize];
        for (int i = 0; i < graphSize; i++) {
            adj[i] = new LinkedList<>();
        }
        visited[start] = true;
        queue.add(start);

        while (queue.size() != 0) {
            start = queue.poll();
            System.out.print(start + " ");

            Iterator<Integer> i = adj[start].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        SparseGraph<Integer, Integer> giraff = new SparseGraph<>();

        Queue<Integer> queue = new LinkedList<>();

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

        List<Integer> list = new ArrayList<>(giraff.getVertices());




        System.out.println(giraff);

        BFS(0, list.size());
    }


}
