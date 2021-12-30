public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        boolean RT = false;

        long a2 = (long) a * a;


        long b2 = (long) b * b;
        long c2 = (long) c * c;
        RT = (a > 0) && (b > 0) && (c > 0) && (a2 > 0) && (b2 > 0) && (c2 > 0);
        RT = RT && ((a2 + b2 == c2) || (a2 + c2 == b2) || (a2 == b2 + c2));
        System.out.println(RT);
    }
}

