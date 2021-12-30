public class ThueMorse {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n;
        if ((m & m - 1) == 0) n = m;
        else n = (int) Math.pow(2, (int) Math.sqrt(m) + 1);
        int[] a = new int[n];
        for (int i = 1; i < n; i = i * 2) {
            for (int j = 0; j < i; j++) {
                a[i + j] = 1 - a[j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i] == a[j]) System.out.print("+  ");
                else System.out.print("-  ");
            }
            System.out.println();
        }
    }
}
