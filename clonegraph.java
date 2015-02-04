/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        HashMap<UndirectedGraphNode,UndirectedGraphNode>map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        while(!queue.isEmpty()){
            UndirectedGraphNode top = queue.remove();
            UndirectedGraphNode copy = new UndirectedGraphNode(top.label);
            map.put(top,copy);
            for(int i = 0; i < top.neighbors.size(); i++){
                if(map.get(top.neighbors.get(i)) == null){
                    map.get(top).neighbors.add(map.get(top.neighbors.get(i)));
                    queue.add(top.neighbors.get(i));
                }
            }
        }
        return map.get(node);
    }
}