import java.util.Arrays;

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
        int[] result = new MaxSubarray().findMaxSubarray(array, 0, array.length);
        System.out.println(Arrays.toString(result));
    }

    private int[] findMaxSubarray(int[] array, int low, int high) {
        if (high - low == 1) {
            return new int[]{low, high, array[low]};
        } else {
            int mid = (low + high) / 2;
            int[] leftSum = findMaxSubarray(array, low, mid);
            int[] rightSum = findMaxSubarray(array, mid, high);
            int[] crossingSum = findMaxCrossingSubarray(array, low, mid, high);
            if (leftSum[2] >= rightSum[2] && leftSum[2] >= crossingSum[2]) {
                return leftSum;
            } else if (rightSum[2] >= leftSum[2] && rightSum[2] >= crossingSum[2]) {
                return rightSum;
            } else {
                return crossingSum;
            }
        }

//        Same with O(n)
//        int left = 0, right = 0, sum = Integer.MIN_VALUE, sumMax = Integer.MIN_VALUE;
//        for (int i = 0; i < array.length; i++) {
//            if (sum < 0) {
//                sum = array[i];
//                left = i;
//            } else {
//                sum += array[i];
//            }
//
//            if (sum > sumMax) {
//                sumMax = sum;
//                right = i + 1;
//            }
//        }
//        return new int[] {sumMax, left, right};
    }

    private int[] findMaxCrossingSubarray(int[] array, int low, int mid, int high) {
        int maxLeft = low, maxRight = high, leftSum = Integer.MIN_VALUE, rightSum = leftSum, sum = 0;
        for (int i = mid - 1; i >= low; i--) {
            sum += array[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        sum = 0;
        for (int j = mid; j < high; j++) {
            sum += array[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j + 1;
            }
        }
        return new int[]{maxLeft, maxRight, leftSum + rightSum};
    }
}
