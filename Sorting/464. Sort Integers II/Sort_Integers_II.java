/**
 * Sort Integers II
 * Heap Sort OR Quick Sort OR Merge Sort
 * Jake Ma
 * 11-12-2018
 */

public class Sort_Integers_II {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        
        // Merge sort
        //mergeSort(A);
        
        // Quick Sort
        //quickSort(A);
        
        // Heap Sort
        heapSort(A);
    }
    
    private void heapSort(int[] A) {
        // Build a max heap from the right most node
        for (int i = A.length / 2 - 1; i >= 0; i--) {
            maxHeapify(A, i, A.length - 1);
        }
        
        for (int i = A.length - 1; i > 0; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            
            // Build max heap again to find next highest value
            maxHeapify(A, 0, i - 1);
        }
    }
    
    private void maxHeapify(int[] A, int start, int end) {
        int parent = start;
        
        while (parent <= end) {
            int left = parent * 2 + 1;
            int right = parent * 2 + 2;
            int child = left; // Equal to left if there's only 1 child node
            
<<<<<<< HEAD
            if (right <= end && A[left] <= A[right]) {
                child = right;
            } else if (left > end && right > end) { 
=======
            if (right <= end && A[right] >= A[left]) {
                child = right;
            } else if (left > end) { 
>>>>>>> 2341cde4818bfbbc9fb96673c48711bab617610d
                return;
            }
            
            if (A[child] <= A[parent]) {
                return;
            }
            
            int temp = A[parent];
            A[parent] = A[child];
            A[child] = temp;
            
            parent = child;
        }
    }
    
    private void quickSort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int mid = start + (end - start) / 2;
        int pivot = A[mid];
        int left = start;
        int right = end;
        
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            
            // Swap
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
    
    private void mergeSort(int[] A) {
        int[] temp = new int[A.length];
        mergeSort(A, temp, 0, A.length - 1);
    }
    
    private void mergeSort(int[] A, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }
        
        // Divide
        int mid = start + (end - start) / 2;
        mergeSort(A, temp, start, mid);
        mergeSort(A, temp, mid + 1, end);
        
        // Merge
        int index = start;
        int leftStart = start;
        int rightStart = mid + 1;
        
        while (leftStart <= mid && rightStart <= end) {
            if (A[leftStart] < A[rightStart]) {
                temp[index++] = A[leftStart++];
            } else {
                temp[index++] = A[rightStart++];
            }
            
        }
        
        while (leftStart <= mid) {
            temp[index++] = A[leftStart++];
        }
        while (rightStart <= end) {
            temp[index++] = A[rightStart++];
        }
        
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
    }
}
