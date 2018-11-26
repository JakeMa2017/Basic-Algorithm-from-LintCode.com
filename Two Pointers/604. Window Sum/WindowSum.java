/**
 * Window Sum
 * Two Pointers
 * Jake Ma
 * 11-25-2018
 */

public class WindowSum {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        if (nums.length == 0 || k == 0 || nums == null) {
            return new int[0];
        }
        
        int[] results = new int[nums.length - k + 1];
        for (int i = 0; i <k; i++) {
            results[0] += nums[i];
        }
        
        for (int left = 1, right = k; right < nums.length; right++, left++) {
            results[left] = results[left - 1] - nums[left - 1] + nums[right];
        }
        
        return results;
    }
}