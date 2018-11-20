/**
 * Remove Duplicate Numbers in Array
 * Two Pointers
 * Jake Ma
 * 11-19-2018
 */

public class RemoveDuplicate {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int slow = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[slow]) {
                nums[++slow] = nums[i];
            }
        }
        
        return slow + 1;
    }
}