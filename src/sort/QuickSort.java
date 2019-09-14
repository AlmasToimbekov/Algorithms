package sort;

public class QuickSort {
    public static void quickSort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int k = array[right - 1];
        int p = left - 1;
        for (int i = p + 1; i < right; i++) {
            if (array[i] < k) {
                int temp = array[i];
                array[i] = array[p + 1];
                array[p + 1] = temp;
                p++;
            }
        }
        array[right - 1] = array[p + 1];
        array[p + 1] = k;

        quickSort(array, left, p + 1);
        quickSort(array, p + 2, right);
    }
}
