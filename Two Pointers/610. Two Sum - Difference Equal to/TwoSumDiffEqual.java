/**
 * Two Sum - Difference Equal to Target
 * Two Pointers
 * Jake Ma
 * 12-7-2018
 */
public class TwoSumDiffEqual {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSumDiffEqual(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return null;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i] + target;
            if (map.containsKey(sum)) {
                result[0] = map.get(sum) + 1;
                result[1] = i + 1;
                return result;
            }
            
            int diff = nums[i] - target;
            if (map.containsKey(diff)) {
                result[0] = map.get(diff) + 1;
                result[1] = i + 1;
                return result;
            }
            
            map.put(nums[i], i);
        }
        
        return result;
    }
    
    
}