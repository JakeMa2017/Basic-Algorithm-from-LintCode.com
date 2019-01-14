public class SequenceReconstruction {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // Error detection
        if (org == null || seqs == null) {
            return false;
        }

        int size = org.length;
        Map<Integer, Set<Integer>> map =  new HashMap<>();
        int[] inDegree = new int[size + 1];
        int lengthSum = 0; // for error detection only

        for (int i = 0; i < size; i++) {
            // Since there may be duplicate records in seqs, we use HashSet here.
            map.put(org[i], new HashSet<Integer>());
        }
        for (int i = 0; i < seqs.length; i++) {
            lengthSum += seqs[i].length;
            // Error detection
            if (seqs[i].length > 0 && (seqs[i][0] > size || seqs[i][0] < 0)) {
                return false;
            }
            for (int j = 1; j < seqs[i].length; j++) {
                // Error detection
                if (seqs[i][j] > size || seqs[i][j] < 0) {
                    return false;
                }
                // Add in degree only when it's not a dupoicated node.
                if (map.get(seqs[i][j - 1]).add(seqs[i][j])) {
                    inDegree[seqs[i][j]]++;
                }
            }
        }
        // Error detection
        if (lengthSum < size) {
            return false;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int result = 0;
        while (queue.size() == 1) {
            int num = queue.poll();
            if (num != org[result]) {
                return false;
            }
            result++;
            for (int node : map.get(num)) {
                inDegree[node]--;
                if (inDegree[node] == 0) {
                    queue.offer(node);
                }
            }
        }
        
        
        return result == size;
    }
}