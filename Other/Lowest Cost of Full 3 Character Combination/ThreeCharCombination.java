/**
 * Lowest Cost of Full 3 Character Combination
 * Don't Know....
 * Jake Ma
 * 12-09-2018
 */

import java.util.ArrayList;

public class ThreeCharCombination {
    public ArrayList<Integer> lowestCost(ArrayList<String[]> inputs) {
        ArrayList<Integer> results = new ArrayList<>();

        for (String[] s : inputs) {
            // Read data into two array of strings.
            int n = Integer.parseInt(s[0]);
            int[] cost = new int[n];
            String[] minerals = new String[n];
            for (int i = 1; i < s.length; i++) {
                cost[i - 1] = Integer.parseInt(s[i].split(" ")[0]);
                minerals[i - 1] = s[i].split(" ")[1];
            }
            // See if it can forge.
            boolean foundA = false;
            boolean foundB = false;
            boolean foundC = false;
            if (!ifCanForge(minerals, foundA, foundB, foundC)) {
                results.add(-1);
                continue;
            }
            // Find the lowest cost for each possible chunk of mineral.
            // A, B, C, AB||BA, AC||CA, BC||CB, ABC||...
            int[] lowest = findLowest(cost, minerals);

            // Find the lowest cost among all possible combinations.
            // A+B+C, A+BC, B+AC, C+AB, ABC
            int result = Integer.MAX_VALUE;
            int a = lowest[0] + lowest[1] + lowest[2];
            if (a < result) result = a;
            int b = lowest[0] + lowest[5];
            if (b < result) result = b;
            int c = lowest[1] + lowest[4];
            if (c < result) result = c;
            int d = lowest[2] + lowest[3];
            if (d < result) result = d;
            if (lowest[6] < result) result = lowest[6];
            results.add(result);

        }

        return results;
    }
    private int[] findLowest(int[] cost, String[] minerals) {
        int[] lowest = new int[7];
        for (int i = 0; i < 7; i++) {
            lowest[i] = 200000;
        }

        for (int i = 0; i < cost.length; i++) {
            switch (minerals[i]) {
                case "A":
                    if (cost[i] < lowest[0]) {
                        lowest[0] = cost[i];
                    }
                    break;
                case "B":
                    if (cost[i] < lowest[1]) {
                        lowest[1] = cost[i];
                    }
                    break;
                case "C":
                    if (cost[i] < lowest[2]) {
                        lowest[2] = cost[i];
                    }
                    break;
                case "AB":
                case "BA":
                    if (cost[i] < lowest[3]) {
                        lowest[3] = cost[i];
                    }
                    break;
                case "AC":
                case "CA":
                    if (cost[i] < lowest[4]) {
                        lowest[4] = cost[i];
                    }
                    break;
                case "BC":
                    if (cost[i] < lowest[5]) {
                        lowest[5] = cost[i];
                    }
                    break;
                default:
                    break;
            }
            if (minerals[i].length() == 3) {
                lowest[6] = lowest[6] < cost[i] ? lowest[6] : cost[i];
            }
        }
        return lowest;
    }
    private boolean ifCanForge(String[] minerals, 
    boolean foundA, boolean foundB, boolean foundC) {
        for (int i = 0; i < minerals.length; i++) {
            String m = minerals[i];
            if (m.length() == 3) {
                return true;
            }
            if (m.length() == 2) {
                hasABC(m.charAt(0), foundA, foundB, foundC);
                hasABC(m.charAt(1), foundA, foundB, foundC);
            } else {
                hasABC(m.charAt(0), foundA, foundB, foundC);
            }
            if (foundA && foundB && foundC) {
                return true;
            }
        }

        return false;
    }

    private void hasABC(char c, boolean foundA, boolean foundB, boolean foundC) {
        if (c == 'A') foundA = true;
        if (c == 'B') foundB = true;
        if (c == 'C') foundC = true;
    }

    public static void main(String[] args) {
        String[] input1 = {"3", "5 BCA", "5 C", "8 ACB"};
        String[] input2 = {"1", "2 CA"};
        String[] input3 = {"6", "1 AC", "2 C", "3 C", "4 A", "5 C", "6 A"};
        ThreeCharCombination cold = new ThreeCharCombination();
        ArrayList<String[]> inputs = new ArrayList<>();
        inputs.add(input1);
        inputs.add(input2);
        inputs.add(input3);
        System.out.println(cold.lowestCost(inputs));
    }
}
