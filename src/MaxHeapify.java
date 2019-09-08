public class MaxHeapify {
    public static void buildMaxHeap(int[] array) {
        for (int i = array.length / 2 - 1; i > -1; i--) {
            heapify(array, i);
        }
    }

    private static void heapify(int[] array, int index) {
        int left = left(array, index);
        int right = right(array, index);
        int largest = index;
        if (left != -1 && array[left] > array[largest]) {
            largest = left;
        }
        if (right != -1 && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != index) {
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;
            heapify(array, largest);
        }
    }
    public static void straightforwardBuild(int[] array, int index) {
        int swaps = 0;
        int left;
        int right;
        for (int i = index; i < array.length / 2 - 1; i++) {
            left = left(array, i);
            right = right(array, i);
            int largest = i;
            if (left != -1 && array[left] > array[largest]) {
                largest = left;
            }
            if (right != -1 && array[right] > array[largest]) {
                largest = right;
            }
            if (largest != i) {
                int temp = array[i];
                array[i] = array[largest];
                array[largest] = temp;
                swaps++;
            }
        }
        if (swaps > 0) {
            straightforwardBuild(array, 0);
        }
    }

    private static int left(int[] array, int index) {
        if (index * 2 + 1 < array.length) {
            return index * 2 + 1;
        } else {
            return -1;
        }
    }

    private static int right(int[] array, int index) {
        int leftIndex = left(array, index);
        if (leftIndex != -1 && leftIndex + 1 < array.length) {
            return leftIndex + 1;
        } else {
            return -1;
        }
    }
}
