import sort.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] littleArr = {1, 3, 4, 2, 4, 75, 3, 23, 5, 2, 23, 4, 8, 15};
//        int[] mediumArr = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
//        int[] mediumArr2 = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
//
//        System.out.println(Arrays.toString(mediumArr));
//        MaxHeapify.buildMaxHeap(mediumArr);
//        Main.printHeap(mediumArr);
//        System.out.println(Arrays.toString(mediumArr));
//
//        MaxHeapify.straightforwardBuild(mediumArr2, 0);
//        Main.printHeap(mediumArr2);
//        System.out.println(Arrays.toString(mediumArr2));
//
        int size = 1_000_000;
        int[] sizedRandArray = new int[size];
        for (int i = 0; i < size; i++) {
                sizedRandArray[i] = (int)(Math.random() * size);
            }
        int[] sizedRandArray2 = Arrays.copyOfRange(sizedRandArray, 0, sizedRandArray.length);
        long timeBegin = System.nanoTime();
        MaxHeapify.buildMaxHeap(sizedRandArray);
        long timeEnd = System.nanoTime();
        System.out.println((double)((timeEnd - timeBegin)) / 1_000_000_000 + " seconds");

        timeBegin = System.nanoTime();
        MaxHeapify.straightforwardBuild(sizedRandArray2, 0);
        timeEnd = System.nanoTime();
        System.out.println((double)((timeEnd - timeBegin)) / 1_000_000_000 + " seconds");

//
//        System.out.println(Fibonacci.effectiveMethod(10));
//
//        System.out.println(search.RandomSearch.randomSearch(sizedRandArray, 3));

    }

    private static void printHeap(int[] array) {
        for (int i = 0; i < Math.sqrt(array.length) + 1; i++) {
            int reversedLevel = (int)(Math.sqrt(array.length) + 1) - i;
            System.out.print(" ".repeat((int)Math.pow(reversedLevel, Math.sqrt(reversedLevel))));
            for (int j = 0; j < Math.pow(2, i) && j + Math.pow(2, i) <= array.length; j++) {
                System.out.print(array[j + (int)Math.pow(2, i) - 1] + " ");
            }
            System.out.println();
        }
    }
}
