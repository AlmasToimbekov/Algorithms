import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        for (int ii = 0; ii < 20; ii++) {
            int size = 20000;
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = i;//(int)(Math.random() * size);
            }
            long timeBegin = System.nanoTime();
//        int[] array = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
            array = InsertionSort.insertionSort(array);
//        System.out.println(Arrays.toString(array));
            long timeEnd = System.nanoTime();
            System.out.println(timeEnd - timeBegin);
        }
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

//        Same with binary search
//        for (int i = 1; i < array.length; i++) {
//            int compare = array[i];
//
//            int start = 0;
//            int end = i;
//            while (start != end) {
//                int mid = (start + end) / 2;
//                if (compare < array[mid]) {
//                    end = mid;
//                } else {
//                    start = mid + 1;
//                }
//            }
//            if (start != i) {
//                System.arraycopy(array, start, array, start + 1, i - start);
//            }
//            if (start != i) {
//                array[start] = compare;
//            }
//        }

//        Same with recursion
//        if (array.length == 1) {
//            return array;
//        }
//        int mid = array.length / 2;
//        int[] arrayToSort = insertionSort(Arrays.copyOfRange(array, 0, mid));
//        int[] arrayToSort2 = insertionSort(Arrays.copyOfRange(array, mid, array.length));
//
//        int left = 0;
//        int right = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (left == arrayToSort.length) {
//                array[i] = arrayToSort2[right];
//            } else if (right == arrayToSort2.length) {
//                array[i] = arrayToSort[left];
//            } else if (arrayToSort[left] < arrayToSort2[right]) {
//                array[i] = arrayToSort[left++];
//            } else {
//                array[i] = arrayToSort2[right++];
//            }
//        }
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

