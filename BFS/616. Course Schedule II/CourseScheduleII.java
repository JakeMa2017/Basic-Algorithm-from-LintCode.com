/**
 * Course Schedule II
 * BFS
 * Jake Ma
 * 1-11-2018
 */

public class CourseScheduleII {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        
        List[] edges = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[count] = course;
            count++;
            int size = edges[course].size();
            for (int i = 0; i < size; i++) {
                int taken = (int) edges[course].get(i);
                inDegree[taken]--;
                if (inDegree[taken] == 0) {
                    queue.offer(taken);
                }
            }
        }
        
        if (count == numCourses) {
            return result;
        }
        return new int[0];
    }
}