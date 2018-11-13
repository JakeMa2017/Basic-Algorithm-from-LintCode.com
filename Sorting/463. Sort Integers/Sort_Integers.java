/**
 * Sort Integers
 * Selection Sort OR Bubble Sort
 * Jake Ma
 * 11-12-2018
 */

public class Sort_Integers {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        // Selection sort
        for (int i = 0; i < A.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < A.length; j++) {
                if (A[j] < min) {
                    min = A[j];
                    A[j] = A[i];
                    A[i] = min;
                }
            }
        }
        
        //bubbleSort(A);
    }
    
    private void bubbleSort(int[] A) {
        while (true) {
            boolean swapped = false;
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] > A[i + 1]) {
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}