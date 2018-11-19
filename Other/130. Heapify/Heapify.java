/**
 * Heapify - From LintCode.com
 * Other
 * Jake Ma
 * 11-12-2018
 */

public class Heapify {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        
        // for (int i = A.length / 2 - 1; i >= 0; i--) {
        //     siftDown(A, i, A.length - 1);
        // }
        
        for (int i = 0; i < A.length; i++) {
            siftUp(A, i);
        }
    }
    
    // O(n)
    private void siftDown(int[] A, int start, int end) {
        int father = start;
        
        while (father <= end) {
            int left = father * 2 + 1;
            int right = father * 2 + 2;
            int child = left;
            if (right <= end && A[right] < A[left]) {
                child = right;
            } else if (left > end) {
                return;
            }
            
            if (A[child] > A[father]) {
                return;
            }
            
            int temp = A[father];
            A[father] = A[child];
            A[child] = temp;
            
            father = child;
        }
    }
    
    // O(nlogn)
    private void siftUp(int[] A, int start) {
        int child = start;
        
        while (child != 0) {
            int father = (child - 1) / 2;
            if (A[child] >= A[father]) {
                return;
            }
            
            int temp = A[father];
            A[father] = A[child];
            A[child] = temp;
            
            child = father;
        }
    }
}