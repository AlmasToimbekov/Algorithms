package heap;

import sort.HeapSort;

import java.util.Arrays;

public class MaxPriorityQueue {
    public int[] array;

    public MaxPriorityQueue (int[] array) {
        this.array = array;
    }

    public int heapExtractMax() {
        if (array.length < 1) {
            throw new UnsupportedOperationException("The array is empty");
        }
        int max = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = max;
        MaxHeapify.heapify(array, 0, array.length - 1);
        this.array = Arrays.copyOfRange(array, 0, array.length - 1);
        return max;
    }

    public void heapIncreaseKey(int i, int key) {
        if (key < array[i]) {
            System.out.println("Key is smaller than current index");
            return;
        }
        array[i] = key;
        while (i > 0 && array[MaxHeapify.parent(i)] < array[i]) {
            int temp = array[i];
            array[i] = array[MaxHeapify.parent(i)];
            array[MaxHeapify.parent(i)] = temp;
            i = MaxHeapify.parent(i);
        }
    }

    public void maxHeapInsert(int key) {
        int temp = Integer.MIN_VALUE;
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = temp;
        heapIncreaseKey(array.length - 1, key);
    }
}
