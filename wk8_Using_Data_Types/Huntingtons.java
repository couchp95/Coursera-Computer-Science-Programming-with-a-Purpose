public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        // substring(), equals(), and length();
        int max = 0;
        for (int i = 0; i < dna.length() - 2; i++) {
            String tmp = dna.substring(i, i + 3);
            if (tmp.equals("CAG")) {
                int count = 1;
                max = Math.max(count, max);
                for (int j = i + 3; j < dna.length() - 2; j += 3) {
                    String tmp2 = dna.substring(j, j + 3);
                    if (tmp2.equals("CAG")) {
                        count++;
                        max = Math.max(count, max);
                    } else {
                        max = Math.max(max, count);
                        // i = j + 2;
                        break;
                    }
                }
            }
        }
        return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        //  replace() method from the String library.Use \n to specify a newline character and \t t;
        s = s.replace("\n", "");
        s = s.replace("\t", "");
        s = s.replace(" ", "");
        return s;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        // if (maxRepeats <= 9 || maxRepeats >= 181)
        if (maxRepeats >= 10 && maxRepeats <= 35) return "normal";
        if (maxRepeats >= 36 && maxRepeats <= 39) return "high risk";
        if (maxRepeats >= 40 && maxRepeats <= 180) return "Huntington's";
        return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        In in = new In(args[0]);
        String dna = in.readAll();
        dna = removeWhitespace(dna);
        // System.out.println(dna);
        int max = maxRepeats(dna);
        System.out.println("max repeats = " + max);
        System.out.println(diagnose(max));
    }
}
