public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] b = new int[m + 1];
        double h = 0.0;
        int c = 0;
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            b[x]++;
            c++;
            //    System.out.print(x);
        }
        // System.out.println();
        for (int i = 1; i < m + 1; i++) {
            double p = 1.0 * b[i] / c;
            //  System.out.println(b[i] + "  " + p);
            if (b[i] > 0) {
                h -= p * Math.log(p) / Math.log(2);
                // System.out.println(i + "  " + b[i] + "  " + p + "  " + p * Math.log(p) / Math.log(2));
            }
        }
        // System.out.println(h);
        StdOut.printf("%6.4f\n", h);
    }
}
