public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        int[][] a = new int[m][n];
        int i = 0;
        while (i < k) {
            int r = (int) (Math.random() * (m * n));
            int x = r / n;
            int y = r % n;
            // System.out.println(r + "  " + x + "  " + y);
            if (a[x][y] != -1) {
                a[x][y] = -1;
                if ((x > 0) && a[x - 1][y] != -1) a[x - 1][y]++;
                if ((x < m - 1) && a[x + 1][y] != -1) a[x + 1][y]++;
                if ((y > 0) && a[x][y - 1] != -1) a[x][y - 1]++;
                if ((y < n - 1) && a[x][y + 1] != -1) a[x][y + 1]++;
                if ((x > 0) && (y > 0) && a[x - 1][y - 1] != -1) a[x - 1][y - 1]++;
                if ((x < m - 1) && (y < n - 1) && a[x + 1][y + 1] != -1) a[x + 1][y + 1]++;
                if ((x > 0) && (y < n - 1) && a[x - 1][y + 1] != -1) a[x - 1][y + 1]++;
                if ((x < m - 1) && (y > 0) && a[x + 1][y - 1] != -1) a[x + 1][y - 1]++;
                i++;
            } else continue;
        }
        for (i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == -1) System.out.print("*  ");
                else System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
