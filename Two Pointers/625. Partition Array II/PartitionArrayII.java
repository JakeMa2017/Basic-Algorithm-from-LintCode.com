public class PartitionArrayII {
    /**
     * @param nums: an integer array
     * @param low: An integer
     * @param high: An integer
     * @return: nothing
     */
    public void partition2(int[] nums, int low, int high) {
        if (nums.length == 0 || nums == null) {
            return;
        }
        
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        
        while (index <= right) {
            if (nums[index] < low) {
                swap(nums, left, index);
                left++;
                index++;
            } else if (nums[index] > high) {
                swap(nums, right, index);
                right--;
                // Don't increase index here, otherwise there will be one or more unchecked numbers.
            } else {
                index++;
            }
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
}