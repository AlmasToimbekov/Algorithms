package sort;

public class QuickSort {
    public static void quickSort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int q = partition(array, left, right);
        quickSort(array, left, q);
        quickSort(array, q + 1, right);
    }

    public static int partition(int[] array, int left, int right) {
        int k = array[right - 1];
        int p = left - 1;
        for (int i = left; i < right; i++) {
            if (array[i] < k) {
                int temp = array[i];
                array[i] = array[p + 1];
                array[p + 1] = temp;
                p++;
            }
        }
        array[right - 1] = array[p + 1];
        array[p + 1] = k;
        return p + 1;
    }

    public static void randomizedQuicksort(int[] array, int left, int right) {
        if (left < right) {
            int q = randomizedPartition(array, left, right);
            randomizedQuicksort(array, left, q);
            randomizedQuicksort(array, q + 1, right);
        }
    }

    public static int randomizedPartition(int[] array, int left, int right) {
        int i = left + (int)(Math.random() * (right - left));
        int temp = array[right - 1];
        array[right - 1] = array[i];
        array[i] = temp;
        return partition(array, left, right);
    }

    public static void tailRecursiveQuicksort(int[] array, int left, int right) {
        while (left < right) {
            int q = partition(array, left, right);
            tailRecursiveQuicksort(array, left, right - 1);
            left = q + 1;
        }
    }
}
