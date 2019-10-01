package sort;

public class RadixSort {
    public static void radixSort(int[] array) {
        int max = getMax(array);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, exp);
        }
    }

    private static void countSort(int[] array, int exp) {
        int n = array.length;

        int[] result = new int[n];
        int[] count = new int[10];

        int i;
        for (i = 0; i < n; i++) {
            count[array[i] / exp % 10]++;
        }

        for (i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (i = n - 1; i >= 0; i--) {
            result[count[array[i] / exp % 10] - 1] = array[i];
            count[(array[i] / exp % 10)]--;
        }

        System.arraycopy(result, 0, array, 0, n);
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int number : array) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    }
}
