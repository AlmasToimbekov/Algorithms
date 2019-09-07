public class Fibonacci {
//1, 1, 2, 3, 5
    static long recursiveBadMethod(long n) {
        if (n <= 1) {
            return n;
        }
        return recursiveBadMethod(n - 1) + recursiveBadMethod(n - 2);
    }

    static long improvedMethod(long n) {
        n = n - 1;
        long previous = 0;
        long current;
        long fibonacci = 1;

        for (long i = 1; i <= n; i++) {
            current = fibonacci;
            fibonacci += previous;
            previous = current;
        }
        return fibonacci;
    }

    static double effectiveMethod(int num) {
        double x1 = (1 + Math.sqrt(5)) / 2;
        double x2 = (1 - Math.sqrt(5)) / 2;
        double up = Math.pow(x1, num) - Math.pow(x2, num);
        return up / Math.sqrt(5);
    }
}
