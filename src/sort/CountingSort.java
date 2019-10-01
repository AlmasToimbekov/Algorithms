package sort;

public class CountingSort {
    public static int[] countingSort(int[] array, int n) {
        int[] result = new int[array.length], countArr = new int[n];
        for (int i = 0; i < array.length; i++) {
            countArr[array[i]]++;
        }

        for (int i = 1; i < n; i++) {
            countArr[i] += countArr[i - 1];
        }

        for (int i = array.length - 1; i >=0; i--) {
            result[countArr[array[i]] - 1] = array[i];
            countArr[array[i]]--;
        }
        return result;
    }
}
