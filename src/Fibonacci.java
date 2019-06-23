public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(improvedMethod(10));
    }
//1, 1, 2, 3, 5
    private static long recursiveMethod(long n) {
        if (n <= 1) {
            return n;
        }

        for (long i = 2; i <= n; i++) {
            n += i;
        }

        return recursiveMethod(n);
    }

    private static long improvedMethod(long n) {
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
}
