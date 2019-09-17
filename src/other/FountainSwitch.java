/*
There's one-dimensional garden of length n. In each position of the n length garden, a fountain
has been installed with a value of the coverage limit of this fountain. Return an integer that denotes
the minimum number of fountains that must be activated to cover the entire garden by water.
*/

package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FountainSwitch {

    public static void main(String[] args) {

        List list = new ArrayList<Integer>() {
            {
                add(1);
                add(1);
                add(0);
            }
        };
        int x = incorrectRecursion(list);
        System.out.println(x);
    }

    private static int fountainSwitch(List<Integer> a) {
        int n = a.size();
        int[] d = new int[n];
        for (int i = 0;i < n; ++ i) {
            d[i] = Integer.MAX_VALUE;
        }
        for (int i = 0;i < n; ++ i) {
            int left = Math.max(i - a.get(i), 0);
            int right = Math.min(i + a.get(i), n - 1);

            int x = left - 1 < 0 ? 1 : d[left - 1] + 1;
            for (int j = left; j <= right; ++ j) {
                d[j] = Math.min(d[j], x);
            }
        }

        return d[n - 1];
    }

    private static int incorrectRecursion(List<Integer> list) {

        if (list.isEmpty()) return 0;

        List<Integer> copy = new ArrayList<>(list);
        Collections.sort(copy);
        int max = list.indexOf(copy.get(copy.size() - 1));

        int left = max - list.get(max) >= 0 ? max - list.get(max) : 0;
        int right = max + list.get(max) < list.size() ? max + list.get(max) + 1 : list.size();

        int subProblem1 = incorrectRecursion(list.subList(0, left));
        int subProblem2 = incorrectRecursion(list.subList(right, list.size()));

        return subProblem1 + subProblem2 + 1;
    }
}
