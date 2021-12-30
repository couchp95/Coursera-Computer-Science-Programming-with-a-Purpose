public class TrinomialDP {
    // Returns the trinomial coefficient T(n, k).


    public static long trinomial(int n, int k) {
        k = Math.abs(k);
        long[][] t = new long[n + 2][2 * n + 2];
        t[0][0] = 1;
        if ((n == 0) && (k == 0)) return 1;
        if ((k < -n) || (k > n)) return 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 2 * n; j++)
                t[i][j] = t[i - 1][Math.abs(j - 1)] + t[i - 1][j] + t[i - 1][j + 1];
            // for (int j = 0; j <= 2 * n; j++) System.out.print(t[i][j] + ", ");
            // System.out.println();
        }
        return t[n][k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, Math.abs(k)));
    }
}
