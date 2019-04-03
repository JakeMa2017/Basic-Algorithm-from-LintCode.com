/**
 * Jake Ma
 * Intersection of Two Arrays
 * Data Structure
 * 4/3/2019
 */

public class Solution {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        return method1(nums1, nums2);
    }
    
    // sort and merge
    private int[] method1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0, index = 0;
        int[] temp = new int[nums1.length];
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (index == 0 || temp[index - 1] != nums1[i]) {
                    temp[index] = nums1[i];
                    index++;
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        int[] result = new int[index];
        for (int n = 0; n < index; n++) {
            result[n] = temp[n];
        }
        
        return result;
    }
}