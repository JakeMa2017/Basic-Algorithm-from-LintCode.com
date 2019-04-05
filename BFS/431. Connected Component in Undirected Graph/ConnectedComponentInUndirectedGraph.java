/**
 * Jake Ma
 * Connected Component in Undirected Graph
 * BFS
 * 4/4/2019
 * 
 * 
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class ConnectedComponentInUndirectedGraph {
    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        
        if (nodes == null || nodes.size() == 0) {
            return results;
        }
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        
        for (UndirectedGraphNode node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            
            queue.offer(node);
            visited.add(node);
            List<Integer> result = new ArrayList<>();
            
            while (!queue.isEmpty()) {
                UndirectedGraphNode n = queue.poll();
                result.add(n.label);
                
                for (UndirectedGraphNode nei : n.neighbors) {
                    if (!visited.contains(nei)) {
                        queue.offer(nei);
                        visited.add(nei);
                    }
                }
            }
            Collections.sort(result); // for the sake of testing
            results.add(result);
        }
        
        return results;
    }
}