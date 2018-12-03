/**
 * Triangle Count
 * Two Pointers
 * Jake Ma
 * 12-2-2018
 */

public class TriangleCount {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 2; i < nums.length; i++) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return result;
    }
}