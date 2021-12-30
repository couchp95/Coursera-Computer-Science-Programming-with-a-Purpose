public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int s = 0;
        while ((Math.abs(x) + Math.abs(y)) < r) {
            System.out.println("(" + x + "," + y + ")");
            double d = Math.random();
            if (d < 0.25) y = y - 1;
            else if (d < 0.5) y = y + 1;
            else if (d < 0.75) x = x - 1;
            else x = x + 1;
            s++;
        }
        System.out.println("(" + x + "," + y + ")");
        System.out.println("steps = " + s);
    }
}
