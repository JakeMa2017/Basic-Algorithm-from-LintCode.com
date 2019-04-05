/**
 * Jake Ma
 * Number of Islands II
 * Union Find
 * 4/5/2019
 * 
 * 
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class NumberOfIslandsII {
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    
    private int[] father = null;
    private boolean[][] grid = null;
    private int count = 0;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
     
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> result = new ArrayList<>();
        if (operators == null || operators.length == 0 || n == 0 || m == 0) {
            return result;
        }
        
        construct(n, m);
        
        for (int i = 0; i < operators.length; i++) {
            connect(operators[i]);
            result.add(count);
        }
        
        return result;
    }
    
    // union find methods
    private int convertToID(int x, int y, int m) {
        return x * m + y;
    }
    
    private void construct(int n, int m) {
        father = new int[n * m];
        grid = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                father[convertToID(i, j, m)] = convertToID(i, j, m);
            }
        }
    }
    
    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        
        return father[x] = find(father[x]);
    }
    
    private void connect(Point p) {
        if (grid[p.x][p.y]) {
            return;
        }
        
        grid[p.x][p.y] = true;
        count++;
        
        // see if there are any adjacent islands that were not connected
        for (int i = 0; i < 4; i++) {
            int nextX = p.x + dx[i];
            int nextY = p.y + dy[i];
            
            // if (inBound())
            if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                continue;
            }
            
            if (grid[nextX][nextY]) {
                int curRoot = find(convertToID(p.x, p.y, grid[0].length));
                int nextRoot = find(convertToID(nextX, nextY, grid[0].length));
                
                if (curRoot != nextRoot) {
                    father[curRoot] = nextRoot;
                    count--;
                }
            }
        }
    }
    // union find ijodesu
}