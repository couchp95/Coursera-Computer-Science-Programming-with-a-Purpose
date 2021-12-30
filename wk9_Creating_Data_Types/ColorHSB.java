public class ColorHSB {
    private final int hh;
    private final int ss;
    private final int bb;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359) throw new IllegalArgumentException("the hue must be between 0 and 359");
        else hh = h;
        if (s < 0 || s > 100) throw new IllegalArgumentException("the saturation must be between 0 and 359");
        else ss = s;
        if (b < 0 || b > 100) throw new IllegalArgumentException("the brightness must be between 0 and 359");
        else bb = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hh + ", " + ss + ", " + bb + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        if (ss == 0 || bb == 0) return true;
        return false;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) throw new IllegalArgumentException("ColorHSB that is null.");
        return Math.min((that.hh - hh) * (that.hh - hh),
                (360 - Math.abs((that.hh - hh))) * (360 - Math.abs((that.hh - hh))))
                + (that.ss - ss) * (that.ss - ss) + (that.bb - bb) * (that.bb - bb);

    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB a = new ColorHSB(h, s, b);
        ColorHSB min = null;
        int minDistance = Integer.MAX_VALUE;
        String minName = "";
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            ColorHSB c = new ColorHSB(StdIn.readInt(), StdIn.readInt(), StdIn.readInt());
            int dis = c.distanceSquaredTo(a);
            // System.out.println(name + "  " + dis + "  " + c);
            if (dis < minDistance) {
                minDistance = dis;
                min = c;
                minName = name;
            }
        }
        if (!(min == null)) System.out.println(minName + " " + min);
    }
}
