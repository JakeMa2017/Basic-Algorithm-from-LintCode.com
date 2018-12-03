/**
 * 3Sum Cloest 
 * Two Pointers
 * Jake Ma
 * 12-02-2018
 */

public class ThreeSumCloest {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        if (numbers == null || numbers.length < 3) {
            return 1;
        }
        
        Arrays.sort(numbers);
        int distance = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            
            while (left < right) {
                int tempSum = numbers[i] + numbers[left] + numbers[right];
                if (Math.abs(tempSum - target) < distance) {
                    result = tempSum;
                    distance = Math.abs(tempSum - target);
                }
                
                if (tempSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }
}