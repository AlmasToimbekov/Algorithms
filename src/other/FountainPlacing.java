/*
Fountain problem: each fountain can water some quantity of cells - fountain power
(the first entry in Map fountains variable), if power is 0 it can water only 1 cell
where it placed at. Given some limited quantity of fountains (the second entry in
Map fountains), which must be placed into x, y sized field in such a way that the engaged
amount of fountains is minimal.
In the resulting output fountains with power of 0 are shown like "-1" since zeros are
places without fountains.
*/

package other;

import java.util.*;

public class FountainPlacing {
    public static void main(String[] args) {
        int fieldSizeX = 20;
        int fieldSizeY = 16;

//        Map entries: watering power, quantity
        Map fountains = new HashMap<Integer, Integer>() {
            {
                put(5, 10);
                put(4, 10);
                put(3, 10);
                put(2, 10);
                put(1, 10);
                put(0, 100);
            }
        };

        int[][] result = new int[fieldSizeY][fieldSizeX];
        int[] problemSize = {0, 0, result[1].length, result.length};
        fountainPlacing(fountains, problemSize, result);
        printResult(result);
    }

    static void fountainPlacing(Map fountains, int[] problem, int[][] result) {
//        Stop recursion
        if (problem[0] == problem[2] || problem[1] == problem[3] ||
                problem[0] == result[0].length || problem[1] == result.length) {
            return;
        }
//        Remove fountains with quantity 0
        Iterator<Integer> iterator = fountains.values().iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 0) {
                iterator.remove();
            }
        }
//        Put fountains to int[]
        iterator = fountains.keySet().iterator();
        int[] keys = new int[fountains.size()];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = iterator.next();
        }

        for (int i = keys.length - 1; i > -1; i--) {
            if (keys[i] * 2 + 1 <= getMinDimension(problem)) {
                int solved = keys[i] * 2 + 1;
                int index = i;
                if (result[problem[1] + keys[index]][problem[0] + keys[index]] == 0) {
                    if (keys[index] == 0) {
                        result[problem[1]][problem[0]] = -1;
                    } else {
                        if (index == 0 || getMinDimension(problem) % solved == 0) {
                            result[problem[1] + keys[index]][problem[0] + keys[index]] = keys[index];
                        } else {
                            index--;
                            solved = keys[index] * 2 + 1;
                            if (keys[index] == 0) {
                                result[problem[1]][problem[0]] = -1;
                            } else {
                                result[problem[1] + keys[index]][problem[0] + keys[index]] = keys[index];
                            }
                        }
                    }
                    fountains.replace(keys[index], (int) fountains.get(keys[index]) - 1);
                }

//                Next problem's coordinates (from[x1, y1], to[x2, y2])
                int[] subProblem1 = {problem[0] + solved, problem[1], problem[2], problem[1] + solved};
                int[] subProblem2 = {problem[0], problem[1] + solved, problem[0] + solved, problem[3]};
                if (result[0].length - solved > result.length - solved) {
                    subProblem1[2] = problem[2];
                    subProblem1[3] = problem[3];
                } else {
                    subProblem2[2] = problem[2];
                    subProblem2[3] = problem[3];

                }
                fountainPlacing(fountains, subProblem1, result);
                fountainPlacing(fountains, subProblem2, result);
                break;
            }
        }
    }

    private static int getMinDimension(int[] problem) {
        if (problem[2] - problem[0] > problem[3] - problem[1]) {
            return problem[3] - problem[1];
        } else {
            return problem[2] - problem[0];
        }
    }

    private static void printResult(int[][] result) {
        for (int a = 0; a < result.length; a++) {
            for (int b = 0; b < result[a].length; b++) {
                if (result[a][b] == -1) {
                    System.out.print(result[a][b] + " ");
                } else {
                    System.out.print(" " + result[a][b] + " ");
                }
            }
            System.out.println();
        }
    }
}