package heap;

public class MaxHeapify {
    public static void buildMaxHeap(int[] array) {
        for (int i = array.length / 2 - 1; i > -1; i--) {
            heapify(array, i, array.length);
        }
    }

    public static void heapify(int[] array, int index, int len) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        if (left < len && array[left] > array[largest]) {
            largest = left;
        }
        if (right < len && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != index) {
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;
            heapify(array, largest, len);
        }
    }

    public static void heapify(int[] array, int index) {
        heapify(array, index, array.length);
    }

    public static void straightforwardBuild(int[] array, int index) {
        int swaps = 0;
        int left;
        int right;
        for (int i = index; i < array.length / 2 - 1; i++) {
            left = left(array, i, array.length);
            right = right(array, i, array.length);
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

    public static int left(int[] array, int index, int len) {
        if (index * 2 + 1 < len) {
            return index * 2 + 1;
        } else {
            return -1;
        }
    }

    public static int right(int[] array, int index, int len) {
        int leftIndex = left(array, index, len);
        if (leftIndex != -1 && leftIndex + 1 < len) {
            return leftIndex + 1;
        } else {
            return -1;
        }
    }

    public static int parent(int index) {
        int result = (index + 1) / 2 - 1;
        if (result > -1) {
            return result;
        } else {
            return -1;
        }
    }
}