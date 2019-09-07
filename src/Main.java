import sort.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] littleArr = {1, 3, 4, 2, 4, 75, 3, 23, 5, 2, 23, 4, 8, 15};
        int[] mediumArr = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};

        int size = 20000;
        int[] sizedRandArray = new int[size];
        for (int i = 0; i < size; i++) {
                sizedRandArray[i] = (int)(Math.random() * size);
            }
        long timeBegin = System.nanoTime();
        BubbleSort.bubbleSort(sizedRandArray);
        long timeEnd = System.nanoTime();

        System.out.println((double)((timeEnd - timeBegin)) / 1_000_000_000 + " seconds");
//
//        System.out.println(Fibonacci.effectiveMethod(10));
//
//        System.out.println(search.RandomSearch.randomSearch(sizedRandArray, 3));


    }
}
