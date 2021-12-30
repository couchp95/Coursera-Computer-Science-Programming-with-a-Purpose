public class Clock {
    private int hh;
    private int mm;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23) throw new IllegalArgumentException("the hour must be between 0 and 23");
        else hh = h;
        if (m < 0 || m > 59) throw new IllegalArgumentException("the minute must be between 0 and 23");
        else mm = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        String[] a = new String[2];
        if ((s == null) || s.isEmpty() || s.length() != 5 || !(s.contains(":"))
                || s.indexOf(":") != 2
        ) throw new IllegalArgumentException("the time is invalid");
        a = s.split(":");
        if (a[0].length() < 2 || a[1].length() < 2) throw new IllegalArgumentException("the time is invalid");
        int h = Integer.parseInt(a[0]);
        int m = Integer.parseInt(a[1]);
        if (h < 0 || h > 23) throw new IllegalArgumentException("the hour must be between 0 and 23");
        else hh = h;
        if (m < 0 || m > 59) throw new IllegalArgumentException("the minute must be between 0 and 23");
        else mm = m;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String s = "";
        if (hh < 10) s += "0" + hh + ":";
        else s += hh + ":";
        if (mm < 10) s += "0" + mm;
        else s += mm;
        return s;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (that.hh > hh) return true;
        else if (that.hh < hh) return false;
        if (that.mm > mm) return true;
        return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        toc(1);
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException("the delta must be positive");
        int h = hh;
        int m = mm;
        mm = (m + delta) % 60;
        hh = (h + (m + delta) / 60) % 24;
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock c1 = new Clock("12.34");
        System.out.println(c1);
        Clock c3 = new Clock("1234:");
        System.out.println(c3);
        Clock c2 = new Clock(10, 8);
        System.out.println(c2);
        System.out.println(c1.isEarlierThan(c2));
        c1.tic();
        System.out.println(c1);
        c2.toc(59);
        System.out.println(c2);
        c2.toc(60);
        System.out.println(c2);
    }
}
