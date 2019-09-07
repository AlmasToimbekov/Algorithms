package search;

public class MaxSubarray {
    public static int[] findMaxSubarray(int[] array, int low, int high) {
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
    }

    //        Same with O(n)
    public static int[] linearMaxSubarray(int[] array, int low, int high) {
        int left = 0, right = 0, sum = Integer.MIN_VALUE, sumMax = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (sum < 0) {
                sum = array[i];
                left = i;
            } else {
                sum += array[i];
            }

            if (sum > sumMax) {
                sumMax = sum;
                right = i + 1;
            }
        }
        return new int[] {sumMax, left, right};
    }

    private static int[] findMaxCrossingSubarray(int[] array, int low, int mid, int high) {
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
