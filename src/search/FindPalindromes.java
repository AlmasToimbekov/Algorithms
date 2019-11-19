package search;

import java.util.Arrays;

public class FindPalindromes {
    public static void main(String[] args) {
        FindPalindromes t = new FindPalindromes();
        String result = t.findPalindromes("cbcdcbedcbc");
        System.out.println(result);
    }


    public String findPalindromes(String s) {
        String modifiedS = addSalt(s);
        int n = modifiedS.length();
        int C = 0, R = 0, biggest = 0, biggestInd = 0;
        int[] palindromeList = new int[n];

        for (int i = 1; i < n && biggest / 2 + i < n - 1; i++) {
            if (i > R) {
                palindromeList[i] = getPalindromeSize(modifiedS, i, i, n);
                C = i;
                R = palindromeList[i] / 2 + i;
            } else {
                int newRight = i + palindromeList[C - (i - C)] / 2;
                if (newRight > R) {
                    newRight = R;
                }
                palindromeList[i] = getPalindromeSize(modifiedS, i, newRight + 1, n);
                if (palindromeList[i] / 2 + i > R) {
                    C = i;
                    R = palindromeList[i] / 2 + i;
                }
            }
            if (biggest < palindromeList[i]) {
                biggest = palindromeList[i];
                biggestInd = i;
            }
        }
/*
        System.out.println(Arrays.toString(palindromeList));
        for (int i = 0; i < modifiedS.length(); i++) {
            System.out.print(" " + modifiedS.charAt(i) + " ");
        }
        System.out.println();
*/

        int leftInd = (biggestInd - palindromeList[biggestInd] / 2) / 2;
        int rightInd = (biggestInd + palindromeList[biggestInd] / 2) / 2;
        return s.substring(leftInd, rightInd);
    }

    private int getPalindromeSize(String s, int center, int right, int n) {
        int left = 2 * center - right;
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    private String addSalt(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(' ');
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append(' ');
        }
        return sb.toString();
    }
}