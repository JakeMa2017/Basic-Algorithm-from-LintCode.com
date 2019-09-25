
/**
 * Josephus Problem
 * Math OR Lined List
 * Jake Ma
 * 11-25-2018
 */

import java.util.LinkedList;

class JosephusProblem {
    public int mathGetWinner(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }

        int winner = 0;
        for (int i = 2; i <= n; i++) {
            winner = (winner + m) % i;
        }
        // since the labels start from 1
        return winner + 1;
    }

    public int linkedListGetWinner(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        // since the labels start from 1
        return list.get(index) + 1;
    }

    public int oneLine(int n, int m) {
        return n == 1 ? n : ((oneLine(n - 1, m) + m) % n) + 1;
    }
}