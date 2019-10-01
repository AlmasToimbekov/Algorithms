// Expected running time is Θ(n)

package search;

import sort.QuickSort;

public class SearchIndex {
    public static int searchMinIndex(int[] array, int left, int right, int index) {
        if (right - left == 1) return array[left];

        int q = QuickSort.randomizedPartition(array, left, right);

        if (q == index) return array[q];

        if (index < q) {
            return searchMinIndex(array, left, q, index);
        } else {
            return searchMinIndex(array, q + 1, right, index);
        }
    }
}
