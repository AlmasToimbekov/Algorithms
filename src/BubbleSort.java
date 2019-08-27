import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
//        int size = 5000000;
//        int[] array = new int[size];
//        for (int i = 0; i < size; i++) {
//            int sign = (int)(Math.random() * 2) == 1 ? -1 : 1;
//            array[i] = (int)(Math.random() * size / 1000000) * sign;
//        }
//        array[2000] = -100;
//        array[2500] = -150;
//        array[25020] = -1500;
//        array[25030] = -10;
//        array[25400] = -350;
        int[] array = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] result = new BubbleSort().bubbleSort(array);
        System.out.println(Arrays.toString(result));
    }

    public int[] bubbleSort(int[] array) {
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
