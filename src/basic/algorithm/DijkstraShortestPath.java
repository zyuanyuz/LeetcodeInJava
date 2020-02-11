package basic.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraph;
import com.google.common.graph.ValueGraphBuilder;

public class DijkstraShortestPath {

    public List<Integer> shortestPath(int srcPointer, ValueGraph<Integer, Integer> valueGraph) {
        List<Integer> result = new ArrayList<>(valueGraph.nodes().size());
        //result.set(srcPointer, 0); // 0 distance from the pointer itself
        int resultSize = 0;
        while (resultSize < valueGraph.nodes().size()) {
            for(Integer node : valueGraph.nodes()){
                
            }
        }
        return null;
    }

    public static void main(String[] args) {
        DijkstraShortestPath d = new DijkstraShortestPath();
        MutableValueGraph<Integer, Integer> graph = ValueGraphBuilder.undirected().build();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.putEdgeValue(1, 2, 7);
        graph.putEdgeValue(1, 3, 9);
        graph.putEdgeValue(1, 6, 14);
        graph.putEdgeValue(2, 3, 10);
        graph.putEdgeValue(2, 4, 15);
        graph.putEdgeValue(3, 4, 11);
        graph.putEdgeValue(3, 6, 2);
        graph.putEdgeValue(4, 5, 6);
        graph.putEdgeValue(5, 6, 9);    
        System.out.println(d.shortestPath(3, graph));
    }
}
