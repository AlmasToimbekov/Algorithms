public class SearchingProblem {
    public static void main(String[] args) {
        int[] array = {2, 3, 5, 8, 12, 15, 19, 23};
        System.out.println(new SearchingProblem().search(array, 15));
    }
    protected int search(int[] array, int value) {
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