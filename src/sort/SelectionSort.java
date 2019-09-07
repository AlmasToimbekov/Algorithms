package sort;

public class SelectionSort {
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int currentValue = array[i];

            int j = i + 1;
            int minIndex = i;
            while (j < array.length) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
                j++;
            }
            array[i] = array[minIndex];
            array[minIndex] = currentValue;
        }
        return array;
    }
}
    /*same in JS
    function selection(array) {
        for (var i = 0; i < array.length; i++) {
            var minIndex = findMin(array.slice(i)) + i;
            var temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    function findMin(array) {
        var min = array[0];
        var minIndex = 0;
        for (var i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }*/

