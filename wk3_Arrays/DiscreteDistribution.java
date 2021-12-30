public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] n = new int[args.length];
        int[] s = new int[args.length];
        for (int i = 1; i < args.length; i++) {
            n[i] = Integer.parseInt(args[i]);
            s[i] = s[i - 1] + n[i];
            // System.out.print(s[i]);
        }
        for (int i = 0; i < m; i++) {
            int r = (int) (Math.random() * s[s.length - 1]);
            // System.out.println(r);
            for (int j = 1; j < s.length; j++) {
                if ((r >= s[j - 1]) && (r < s[j])) {
                    System.out.print(j + " ");
                    break;
                }
            }
        }
        System.out.println();
    }
}
