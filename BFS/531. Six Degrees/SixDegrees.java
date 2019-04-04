/**
 * Jake Ma
 * Six Degrees
 * BFS
 * 4/4/2019
 * 
 * 
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */


public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * @param s: Undirected graph node
     * @param t: Undirected graph nodes
     * @return: an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        if (s == t) {
            return 0;
        }
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        
        queue.offer(s);
        set.add(s);
        int result = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++; // add a step in each level

            for (int i = 0; i < size; i++) {
                UndirectedGraphNode node = queue.poll();
                for (int j = 0; j < node.neighbors.size(); j++) {
                    UndirectedGraphNode temp = node.neighbors.get(j);
                    if (temp == t) {
                        return result; // found it!!
                    }
                    
                    if (!set.contains(temp)) {
                        queue.offer(temp);
                        set.add(temp);
                    }    
                }
            }
        }
        
        return -1;
    }
}