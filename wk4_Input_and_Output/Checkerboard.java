public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if ((x + y) % 2 == 1) StdDraw.setPenColor(StdDraw.GRAY);
                else StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);

            }
        }


    }
}
