import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
//        long[] count = new long[10];
//        for (int j = 0; j < 10; j++) {
//            int size = 5000000;
//            int[] array = new int[size];
//            for (int i = 0; i < size; i++) {
//                int sign = (int)(Math.random() * 2) == 1 ? -1 : 1;
//                array[i] = (int)(Math.random() * size) * sign;
//            }
////        array[2000] = -100;
////        array[2500] = -150;
////        array[25020] = -1500;
////        array[25030] = -10;
////        array[25400] = -350;
        int[] array = {13, -3, -5, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
//            long timeBegin = System.nanoTime();
        new MergeSort().mergeSort(array, array.length);
//            long timeEnd = System.nanoTime();
//            count[j] = timeEnd - timeBegin;
//        }
//        for (long k: count) {
//            System.out.println(k);
//        }
        System.out.println(Arrays.toString(array));
    }

    public int[] mergeSort(int[] array, int len) {
        if (len < 2) {
            return array;
        }
        int mid = len / 2;
        int[] leftArr = Arrays.copyOfRange(array, 0, mid);
        int[] rightArr = new int[len - mid];
        System.arraycopy(array, mid, rightArr, 0, array.length - mid);

        mergeSort(leftArr, mid);
        mergeSort(rightArr, len - mid);
        merge(leftArr, rightArr, array);
        return array;
    }

    public void merge(int[] leftArr, int[] rightArr, int[] resultList) {
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
//        while (positionA < leftArr.length) {
//            resultList[resultIndex++] = leftArr[positionA++];
//        }
//        while (positionB < rightArr.length) {
//            resultList[resultIndex++] = rightArr[positionB++];
//        }

//        The third way
//        for (int i = 0; i < resultList.length; i++) {
//            if (positionA == leftArr.length) {
//                resultList[i] = rightArr[positionB++];
//            } else if (positionB == rightArr.length) {
//                resultList[i] = leftArr[positionA++];
//            } else if (leftArr[positionA] < rightArr[positionB]) {
//                resultList[i] = leftArr[positionA++];
//            } else {
//                resultList[i] = rightArr[positionB++];
//            }
//        }
    }
}