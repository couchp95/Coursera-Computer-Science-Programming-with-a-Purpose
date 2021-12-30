public class ActivationFunction {
    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        else {
            if (x < 0) return 0;
            else if (x == 0) return 0.5;
            else return 1.0;
        }
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        else return 1 / (1 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (Double.isInfinite(x)) if (x < 0) return -1.0;
        else return 1.0;
        if (x == -Double.MAX_VALUE) return -1.0;
        if (x == Double.MAX_VALUE) return 1.0;
        double i = Math.exp(x) - Math.exp(-x);
        double j = Math.exp(x) + Math.exp(-x);
        //    System.out.println(x + "\t" + i + "\t" + j);
        return (i / j);
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (Double.isInfinite(x)) if (x < 0) return -1.0;
        else return 1.0;
        return (x / (1 + Math.abs(x)));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        else {
            if (x <= -2) return -1;
            else if (x < 0) return (x + x * x / 4);
            else if (x < 2) return (x - x * x / 4);
            else return 1;
        }

    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        // a = Double.MIN_VALUE;
        System.out.println("heaviside(" + a + ") = " + heaviside(a));
        System.out.println("  sigmoid(" + a + ") = " + sigmoid(a));
        System.out.println("     tanh(" + a + ") = " + tanh(a));
        System.out.println(" softsign(" + a + ") = " + softsign(a));
        System.out.println("     sqnl(" + a + ") = " + sqnl(a));
    }
}
