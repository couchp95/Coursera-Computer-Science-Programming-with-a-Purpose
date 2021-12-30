public class MaximumSquareSubmatrix {
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int n = a.length;
        int max = 0;
        int[][] b = new int[n][n];
        int[][] c = new int[n][n];
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) b[i][j] = a[i][j];
                else if (a[i][j] == 0) b[i][j] = 0;
                else b[i][j] = b[i][j - 1] + 1;
                if (i == 0) c[i][j] = a[i][j];
                else if (a[i][j] == 0) c[i][j] = 0;
                else c[i][j] = c[i - 1][j] + 1;
                d[i][j] = Math.min(c[i][j], b[i][j]);
                if (i > 0 && j > 0) d[i][j] = Math.min(d[i - 1][j - 1] + 1, d[i][j]);
                max = Math.max(max, d[i][j]);
            }
        }
        /*
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }

       */
        return max;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = StdIn.readInt();
        System.out.println(size(a));

    }
}
