class IsolatedPoints {
    /**
     * 
     * @param n: number of points
     * @param m: number of edges
     * @return: a string of min and max isolated points
     */
    public String findMinAndMaxOfIsolatedPoints(int n, int m) {
        if (n == 1 && m ==0) {
            return "1 1";
        } else if (m >= n * (n - 1) / 2) {
            return "0 0";
        }

        int min = n - m * 2;
        int max = 0;
        if (m == 0) {
            max = n;
        } else if (m == 1) {
            max = n - 2;
        } else if (m == 2 || m == 3) {
            max = n - 3;
        } else {
            int dot = 3;
            for (int i = 4, j = 3; i <= m; i += j++ ) {
                dot++;
            }
            max = n - dot;
        }

        if (max < 0) max = 0;
        if (min < 0) min = 0;
        String result = min + " " + max;
        return result;
    }
}