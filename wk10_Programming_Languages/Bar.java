public class Bar implements Comparable<Bar> {
    private final String barName;
    private final int barValue;
    private final String barCategory;

    // Creates a new bar.
    public Bar(String name, int value, String category) {
        if (name == null || value < 0 || category == null) throw new IllegalArgumentException("Invalid parameter");
        barName = name;
        barValue = value;
        barCategory = category;
    }

    // Returns the name of this bar.
    public String getName() {
        return barName;
    }

    // Returns the value of this bar.
    public int getValue() {
        return barValue;
    }

    // Returns the category of this bar.
    public String getCategory() {
        return barCategory;
    }

    // Compare two bars by value.
    public int compareTo(Bar that) {
        if (that == null) throw new NullPointerException("Invalid parameter");
        return (barValue - that.getValue());

    }

    // Sample client (see below).
    public static void main(String[] args) {

        // comment
    }

}
