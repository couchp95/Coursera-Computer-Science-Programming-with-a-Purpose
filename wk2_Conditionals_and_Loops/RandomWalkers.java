public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        long s = 0;
        for (int i = 0; i < t; i++) {
            int x = 0;
            int y = 0;
            while ((Math.abs(x) + Math.abs(y)) < r) {
                double d = Math.random();
                if (d < 0.25) y = y - 1;
                else if (d < 0.5) y = y + 1;
                else if (d < 0.75) x = x - 1;
                else x = x + 1;
                s++;
            }
        }
        System.out.println("average number of steps = " + (double) s / t);
    }
}
