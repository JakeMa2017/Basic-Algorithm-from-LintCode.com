/**
 * Pancake Sorting
 * Sort
 * Jake Ma
 * 12-03-2018
 */

public class PancakeSort {
    /**
     * @param array: an integer array
     * @return: nothing
     */
    public void pancakeSort(int[] array) {
        if (array.length == 0 || array == null) {
            return;
        }
        
        int end = array.length;
        while (end > 1) {
            int index = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < end; i++) {
                if (array[i] > max) {
                    index = i;
                    max = array[i];
                }
            }
            FlipTool.flip(array, index);
            FlipTool.flip(array, end - 1);
            end--;
        }
        
    }
}