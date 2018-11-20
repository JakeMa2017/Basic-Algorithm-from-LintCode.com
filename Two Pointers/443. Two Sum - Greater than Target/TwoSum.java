/**
 * Two Sum - Greater than target
 * Two Pointers
 * Jake Ma
 * 11-19-2019
 */

public class TwoSum {
     /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        int result = 0;
        int right = nums.length - 1;
        int left = 0;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                result += right - left;
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}