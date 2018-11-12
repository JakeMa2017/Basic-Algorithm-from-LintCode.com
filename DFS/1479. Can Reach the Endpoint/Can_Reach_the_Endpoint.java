/*
 * Can Reach the Endpoint
 * BFS OR DFS
 * Jake Ma
 * 11-11-2018
 */

public class Can_Reach_the_Endpoint {
    /**
     * @param map: the map
     * @return: can you reach the endpoint
     */
    class Coordinate {
        int x;
        int y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int[] xDir = {0, 1, -1 ,0};
    int[] yDir = {1, 0, 0, -1};
    public boolean reachEndpoint(int[][] map) {
        // Write your code here
        if (map == null || map.length == 0 || map[0].length == 0) {
            return false;
        }
        //return helperBFS(map);
        return helperDFS(map, new Coordinate(0, 0));
    }
    
    private boolean helperDFS(int[][] map, Coordinate c) {
        if (map[c.x][c.y] == 9) {
            return true;
        }
        
        for (int i = 0; i < 4; i++) {
            Coordinate coor = new Coordinate(c.x + xDir[i], c.y + yDir[i]);
            if (!inBound(map, coor)) {
                continue;
            }
            if (map[coor.x][coor.y] == 1) {
                map[coor.x][coor.y] = 0;
            }
            if (helperDFS(map, coor)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean helperBFS(int[][] map) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(0, 0));
        
        while (!queue.isEmpty()) {
            Coordinate c = queue.poll();
            if (map[c.x][c.y] == 9) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                Coordinate coor = new Coordinate(c.x + xDir[i], c.y + yDir[i]);
                if (inBound(map, coor)) {
                    queue.offer(coor);
                    if (map[coor.x][coor.y] == 1){
                        map[coor.x][coor.y] = 0;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean inBound(int[][] map, Coordinate c) {
        int m = map.length;
        int n = map[0].length;
        
        return c.x >= 0 && c.x < m && c.y >= 0 && c.y < n && map[c.x][c.y] != 0; 
    }
}