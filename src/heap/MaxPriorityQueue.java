package heap;

import java.util.Arrays;

public class MaxPriorityQueue {
    public int[] array;

    public MaxPriorityQueue (int[] array) {
        this.array = Arrays.copyOf(array, array.length);
        MaxHeapify.buildMaxHeap(this.array);
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
        while (i > 0 && array[MaxHeapify.parent(i)] < key) {
            array[i] = array[MaxHeapify.parent(i)];
            i = MaxHeapify.parent(i);
        }
        array[i] = key;
    }

    public void maxHeapInsert(int key) {
        int temp = Integer.MIN_VALUE;
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = temp;
        heapIncreaseKey(array.length - 1, key);
    }

    public void heapDelete(int key) {
/*
        6.5-8
        The operation HEAP -DELETE .A; i/ deletes the item in node i from heap A. Give
        an implementation of HEAP -DELETE that runs in O (lg n) time for an n-element
        max-heap.
        6.5-9
        Give an O.n lg k/-time algorithm to merge k sorted lists into one sorted list,
        where n is the total number of elements in all the input lists. (Hint: Use a min-
        heap for k-way merging.)
*/

//        An ugly way
//        while (key < array.length) {
//            int left = MaxHeapify.left(array, key, array.length);
//            int right = MaxHeapify.right(array, key, array.length);
//            right = right == -1 ? left : right;
//            if (left == -1) {
//                break;
//            }
//            int largest = array[left] > array[right] ? left : right;
//
//            array[key] = array[largest];
//            key = largest;
//        }
//        array[key] = array[array.length - 1];
//        heapIncreaseKey(key, array[key]);
//        array = Arrays.copyOf(array, array.length - 1);
    }
}