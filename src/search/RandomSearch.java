package search;

public class RandomSearch {
    static int randomSearch(int[] array, int value) {
        boolean[] checkArray = new boolean[array.length];
        int count = 0, attemts = 0;
        while (count < array.length) {
            attemts++;
            int index = (int)(Math.random() * array.length);
            if (array[index] == value) {
                System.out.println("Attempts = " + attemts + ", array length is " + array.length);
                return index;
            } else {
                if (!checkArray[index]) {
                    count++;
                    checkArray[index] = true;
                }
            }
        }
        System.out.println("Attempts = " + attemts + ", array length is " + array.length);
        return -1;
    }
}
