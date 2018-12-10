package Graph;

import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Passcode {

    static <V> void derivePasscode(Graph g) {
        V item = null;
        List<V> sortElements = new ArrayList<>();
        List<V> noIncoming = new ArrayList<>();
        List<V> getVertices = new ArrayList<>(g.getVertices());

        for (V v : getVertices){
            if (g.getInEdges(v).isEmpty()){
                noIncoming.add(v);
            }
        }
        //System.out.println(noIncoming);

        while (!noIncoming.isEmpty()) {

            item = noIncoming.remove(0);
            sortElements.add(item);
            List<V> neighbor = new ArrayList<>(g.getNeighbors(item));
            for (V m : neighbor){
                g.removeEdge(g.findEdge(item,m));
                if (g.getInEdges(m).isEmpty()) {
                    noIncoming.add(m);
                }
            }
        }

        System.out.println(sortElements);

    }



    public static void main(String[] args) throws IOException{
        DirectedGraph<Integer, Integer> g = new DirectedSparseGraph<>();
        List<String> keylog = new ArrayList<>();


        String filename = "C:\\Users\\tshot\\Documents\\Java Project\\DataStructProj\\keylog.txt";
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()){
            keylog.add(sc.next());


            //derivePasscode(g,i);
        }
        sc.close();

        for (int i = 0, j = 0; i < keylog.size(); i++, j=j+3) {
            g.addEdge(j, Character.getNumericValue(keylog.get(i).charAt(0)),Character.getNumericValue(keylog.get(i).charAt(1)));
            g.addEdge(j+1, Character.getNumericValue(keylog.get(i).charAt(0)), Character.getNumericValue(keylog.get(i).charAt(2)));
            g.addEdge(j+2, Character.getNumericValue(keylog.get(i).charAt(1)), Character.getNumericValue(keylog.get(i).charAt(2)));


        }

        derivePasscode(g);


    }

}
