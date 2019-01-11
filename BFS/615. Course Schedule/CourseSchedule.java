/**
 * Course Schedule
 * BFS
 * Jake Ma
 * 1-11-2018
 */

public class CourseSchedule {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0 || prerequisites == null) {
            return true;
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
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            int size = edges[course].size();
            for (int i = 0; i < size; i++) {
                int taken = (int)edges[course].get(i);
                inDegree[taken]--;
                if (inDegree[taken] == 0) {
                    queue.offer(taken);
                }
            }
        }
        
        return count == numCourses;
    }
}