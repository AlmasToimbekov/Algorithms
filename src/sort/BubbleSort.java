package sort;

public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        int iterations = 0;
        int n = array.length;
        int temp = 0;
        for(int i = 0; i < n; i++){
            for(int j = 1; j < (n - i); j++){
                iterations++;
                if(array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(iterations);
        return array;
    }

}
