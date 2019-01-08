/**
 * Two Sum
 * Two Pointers (not really)
 * Jake Ma
 * 12-08-2018
 */

public class TwoSum {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length == 0) {
            return null;
        }
 
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int sub = target - numbers[i];
            if (map.containsKey(sub)) {
                result[0] = map.get(sub);
                result[1] = i;
                return result;
            }
            map.put(numbers[i], i);
        }
        return null;
    }
}