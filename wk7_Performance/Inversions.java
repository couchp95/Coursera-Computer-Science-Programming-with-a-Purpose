public class Inversions {
    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long count = 0;
        int n = a.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (a[j] < a[i]) count++;
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] a = new int[n];
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if ((k >= i) && k > 0) {
                a[count] = i;
                //   System.out.println("k=" + k + "  i=" + i + "  a[" + (count) + "]=" + a[(count)]);
                k = k - i;
                count++;
            } else {
                a[i + count] = i;
                //   System.out.println("k=" + k + "  i=" + i + "  a[" + (i + count) + "]=" + a[i + count]);
            }

        }
        return a;
    }


    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] a = generate(n, k);
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        // System.out.println(count(a));
    }
}
