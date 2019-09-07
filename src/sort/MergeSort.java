package sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] array) {
        int len = array.length;
        if (len < 2) {
            return;
        }
        int mid = len / 2;
        int[] leftArr = Arrays.copyOfRange(array, 0, mid);
        int[] rightArr = new int[len - mid];
        System.arraycopy(array, mid, rightArr, 0, len - mid);

        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(leftArr, rightArr, array);
    }

    public static void merge(int[] leftArr, int[] rightArr, int[] resultList) {
        int positionA = 0, positionB = 0, resultIndex = 0;

//        The first way

        while (positionA < leftArr.length && positionB < rightArr.length) {
            if (leftArr[positionA] < rightArr[positionB]) {
                resultList[resultIndex++] = leftArr[positionA++];
            } else {
                resultList[resultIndex++] = rightArr[positionB++];
            }
        }

        System.arraycopy(leftArr, positionA, resultList, resultIndex, leftArr.length - positionA);
        System.arraycopy(rightArr, positionB, resultList, resultIndex, rightArr.length - positionB);

//        or instead of System.arraycopy
    /*
        while (positionA < leftArr.length) {
            resultList[resultIndex++] = leftArr[positionA++];
        }
        while (positionB < rightArr.length) {
            resultList[resultIndex++] = rightArr[positionB++];
        }
    */
//        The third way
    /*
        for (int i = 0; i < resultList.length; i++) {
            if (positionA == leftArr.length) {
                resultList[i] = rightArr[positionB++];
            } else if (positionB == rightArr.length) {
                resultList[i] = leftArr[positionA++];
            } else if (leftArr[positionA] < rightArr[positionB]) {
                resultList[i] = leftArr[positionA++];
            } else {
                resultList[i] = rightArr[positionB++];
            }
        }
    */
    }
}