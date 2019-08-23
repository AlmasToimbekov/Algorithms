public class MaxSubarray {
    public static void main(String[] args) {
        int size = 5000000;
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
        System.out.println(new MaxSubarray().findMaxSubarray(array, 0, array.length));
    }

    private int findMaxSubarray(int[] array, int low, int high) {
        if (high - low == 1) {
            return array[low];
        } else {
            int mid = (low + high) / 2;
            int leftSum = findMaxSubarray(array, low, mid);
            int rightSum = findMaxSubarray(array, mid, high);
            int crossingSum = findMaxCrossingSubarray(array, low, mid, high);
            if (leftSum >= rightSum && leftSum >= crossingSum) {
                return leftSum;
            } else if (rightSum >= leftSum && rightSum >= crossingSum) {
                return rightSum;
            } else {
                return crossingSum;
            }
        }
    }

    private int findMaxCrossingSubarray(int[] array, int low, int mid, int high) {
        int maxLeft = low;
        int maxRight = high;
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid - 1; i >= low; i--) {
            sum += array[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int j = mid; j < high; j++) {
            sum = sum + array[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }
        return leftSum + rightSum;
    }
}
