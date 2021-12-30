public class RevesPuzzle {

    // move n smallest discs from one pole to another, using the temp pole
    private static void hanoi(int n, int k, String from, String temp, String to) {
        if (n == k) return;
        hanoi(n - 1, k, from, to, temp);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, from, to);
    }

    private static void h4(int n, String from, String temp1, String temp2, String to) {
        if (n == 0) return;
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
        if (n == k) return;
        h4(k, from, temp1, to, temp2);
        // System.out.println("K:  " + k);
        hanoi(n, k, from, temp1, to);
        h4(k, temp2, from, temp1, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
        h4(n, "A", "B", "C", "D");
    }

}
