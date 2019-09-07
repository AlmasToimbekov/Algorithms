package search;

public class SearchingProblem {
    public static int search(int[] array, int value) {
        int start = 0;
        int end = array.length;
        while (end - start > 0) {
            int mid = (start + end) / 2;
            if (array[mid] == value) {
                return mid;
            }
            if (array[mid] > value) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return -1;
    }
}