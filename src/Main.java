import heap.MaxHeapify;
import heap.MaxPriorityQueue;
import sort.HeapSort;
import sort.MergeSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int size = 1_000_0000;
        int[] array = getArray("littleArr", size);
//        int[] array2 = getArray("sizedRandArray", size);
//        int[] array3 = getArray("sizedRandArray", size);
        long timeBegin, timeEnd;

//        timeBegin = System.nanoTime();
//        timeEnd = System.nanoTime();
//        System.out.println((double)((timeEnd - timeBegin)) / 1_000_000_000 + " seconds");
        MaxHeapify.buildMaxHeap(array);
        System.out.println(Arrays.toString(array));
        MaxPriorityQueue maxPriorityQueue = new MaxPriorityQueue(array);
        maxPriorityQueue.maxHeapInsert(-8);
        for (int i = 0; i < 5; i++) {
            System.out.println(maxPriorityQueue.heapExtractMax());
            System.out.println(Arrays.toString(maxPriorityQueue.array));
        }


//        timeBegin = System.nanoTime();
//        HeapSort.heapSort(array2);
//        timeEnd = System.nanoTime();
//        System.out.println((double)((timeEnd - timeBegin)) / 1_000_000_000 + " seconds");
//
//        timeBegin = System.nanoTime();
//        HeapSort.heapSort(array3);
//        timeEnd = System.nanoTime();
//        System.out.println((double)((timeEnd - timeBegin)) / 1_000_000_000 + " seconds");
    }

    public static void printHeap(int[] array) {
        for (int i = 0; i < Math.sqrt(array.length) + 1; i++) {
            int reversedLevel = (int)(Math.sqrt(array.length) + 1) - i;
            System.out.print(" ".repeat((int)Math.pow(reversedLevel, Math.sqrt(reversedLevel))));
            for (int j = 0; j < Math.pow(2, i) && j + Math.pow(2, i) <= array.length; j++) {
                System.out.print(array[j + (int)Math.pow(2, i) - 1] + " ");
            }
            System.out.println();
        }
    }

    private static int[] getArray(String type, int size) {
        if (type.equals("littleArr")) {
            return new int[]{1, 3, 4, 2, 4, 75, 3, 23, 5, 2, 23, 4, 8, 15};
        }
        else if (type.equals("mediumArr")) {
            return new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        }
        else if (type.equals("sizedRandArray")) {
            int[] sizedRandArray = new int[size];
            for (int i = 0; i < size; i++) {
                sizedRandArray[i] = (int) (Math.random() * size);
            }
            return sizedRandArray;
        }
        else if (type.equals("sizedIncArray")) {
            int[] sizedIncArray = new int[size];
            for (int i = 0; i < size; i++) {
                sizedIncArray[i] = i;
            }
            return sizedIncArray;
        }
        else if (type.equals("sizedDecArray")) {
            int[] sizedDecArray = new int[size];
            for (int i = size - 1; i >= 0; i--) {
                sizedDecArray[i] = i;
            }
            return sizedDecArray;
        } else {
            return new int[0];
        }
    }
}
