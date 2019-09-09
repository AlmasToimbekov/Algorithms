package sort;

public class InsertionSort {
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

//        Same with binary search
    public static int[] insertionBinarySort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int compare = array[i];

            int start = 0;
            int end = i;
            while (start != end) {
                int mid = (start + end) / 2;
                if (compare < array[mid]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            if (start != i) {
                System.arraycopy(array, start, array, start + 1, i - start);
            }
            if (start != i) {
                array[start] = compare;
            }
        }
        return array;
    }

    public static void insertionSortRecursive(int arr[], int n)
    {
        if (n <= 1)
            return;

        insertionSortRecursive(arr, n - 1);

        int last = arr[n - 1];
        int j = n - 2;

        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
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

