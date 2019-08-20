import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        long timeBegin = System.nanoTime();
        int size = 5000000;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int)(Math.random() * size);
        }
        long timeEnd = System.nanoTime();
//        System.out.println(Arrays.toString(InsertionSort.insertionSort(array)));
        System.out.println(timeEnd - timeBegin);
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int compare = array[i];

            int j = i;
            while (j > 0 && compare < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = compare;
        }

        return array;
    }
}
    /*same in JS
    function insertSort(array) {
        var bigCycle = 1;
        while (bigCycle < array.length) {
            var innerCycle = bigCycle;
            var sortingValue = array[innerCycle];
            while (innerCycle > 0 && sortingValue < array[innerCycle - 1]) {
                array[innerCycle] = array[innerCycle - 1];
                innerCycle--;
            }
            array[innerCycle] = sortingValue;
            bigCycle++;
        }
        return array;
    }*/

