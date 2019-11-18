package search;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{5, 7};
        FindMedianSortedArrays t1 = new FindMedianSortedArrays();
        double result = t1.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenA = nums1.length, lenB = nums2.length;
        if (lenA > lenB) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int indA = lenA / 2, indB;
        while (true) {
            indB = (lenA + lenB + 1) / 2 - indA;

            int leftMaxA = indA == 0 ? Integer.MIN_VALUE : nums1[indA - 1];
            int rightMinA = indA == lenA ? Integer.MAX_VALUE : nums1[indA];

            int leftMaxB = indB == 0 ? Integer.MIN_VALUE : nums2[indB - 1];
            int rightMinB = indB == lenB ? Integer.MAX_VALUE : nums2[indB];

            if (leftMaxA <= rightMinB && leftMaxB <= rightMinA) {
                if ((lenA + lenB) % 2 == 0) {
                    int leftMax = leftMaxA > leftMaxB ? leftMaxA : leftMaxB;
                    int rightMin = rightMinA < rightMinB ? rightMinA : rightMinB;
                    return (double)(leftMax + rightMin) / 2;
                } else {
                    return leftMaxA > leftMaxB ? leftMaxA : leftMaxB;
                }
            } else if (leftMaxA > rightMinB) {
                indA--;
            } else {
                indA++;
            }
        }
//        throw new IllegalArgumentException("Array is not sorted");
    }
}
