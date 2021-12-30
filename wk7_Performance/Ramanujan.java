public class Ramanujan {
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        long m = Math.round(Math.cbrt(n));
        int count = 0;
        for (long a = 1; a <= m; a++) {
            long b = Math.round(Math.cbrt((n - a * a * a)));

            //  System.out.println(a + "  " + b + "  " + Math.pow((n - Math.pow(a, 3)), 1.0 / 3));
            //  System.out.println(a * a * a + "+" + b * b * b + "=" + (a * a * a + b * b * b));
            if (a * a * a + b * b * b == n) {
                //      System.out.println(n + "^3 = " + a + "^3 + " + b + "^3");
                m = b - 1;
                count++;
            }
        }
        if (count >= 2) return true;
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }

}
