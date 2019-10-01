package sort;

public class CountingSort {
    public static int[] countingSort(int[] array) {
        int n = array.length;
        int[] result = new int[n], countArr = new int[n];

        int i;
        for (i = 0; i < n; i++) {
            countArr[array[i]]++;
        }

        for (i = 1; i < n; i++) {
            countArr[i] += countArr[i - 1];
        }

        for (i = n - 1; i >=0; i--) {
            result[countArr[array[i]] - 1] = array[i];
            countArr[array[i]]--;
        }
        return result;
    }
}
