public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        int[] c = new int[30 + n];
        int distinct = 1;
        for (int i = 0; i < t; i++) {
            boolean[] b = new boolean[n];
            int count = 0;
            while (distinct == 1) {
                int r = (int) (Math.random() * n);
                // System.out.println(r);
                count++;
                if (!b[r]) {
                    // distinct++;
                    b[r] = true;
                } else break;
            }
            c[count]++;
        }
        int sum = 0;
        double avg = 0.0;
        for (int i = 1; i < c.length; i++) {
            sum = sum + c[i];
            avg = (double) sum / t;
            System.out.println(i + "\t" + c[i] + "\t" + avg);
            if (avg >= 0.5) break;
        }
    }
}
