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
        
        //return method1(nums1, nums2);
        //return method2(nums1, nums2);
        return method3(nums1, nums2);
        
    }
    
    // sort and merge
    private int[] method1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
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
    
    // HashSet
    private int[] method2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        HashSet<Integer> init = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            init.add(nums1[i]);
        }
        
        HashSet<Integer> resultHash = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (init.contains(nums2[i]) && !resultHash.contains(nums2[i])) {
                resultHash.add(nums2[i]);
            }
        }
        
        int[] result = new int[resultHash.size()];
        int index = 0;
        for (int n : resultHash) {
            result[index++] = n;
        }
        
        return result;
    }
    
    // HashSet and BS
    private int[] method3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        
        // add intersected number into the HashSet
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                continue;
            }
            if (binarySearch(nums1, nums2[i])) {
                set.add(nums2[i]);
            }
        }
        
        int[] result = new int[set.size()];
        int index = 0;
        for (int n : set) {
            result[index++] = n;
        }
        
        return result;
    }
    
    private boolean binarySearch(int[] nums1, int n) {
        int start = 0;
        int end = nums1.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (n == nums1[mid]) {
                return true;
            }
            
            if (n < nums1[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (n == nums1[start] || n == nums1[end]) {
            return true;
        }
        
        return false;
    }
}