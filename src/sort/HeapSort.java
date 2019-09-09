package sort;

import heap.MaxHeapify;

public class HeapSort {
    public static void heapSort(int[] array) {
        MaxHeapify.buildMaxHeap(array);
        int n = array.length - 1;
        while (n > 0) {
            int temp = array[0];
            array[0] = array[n];
            array[n] = temp;
            MaxHeapify.heapify(array, 0, n);
            n--;
        }
    }
}
