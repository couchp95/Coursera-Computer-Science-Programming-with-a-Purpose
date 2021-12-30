import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        // StdAudio.loop("soundtrackA.wav");
        String filename = args[0];
        int k = Integer.parseInt(args[1]);
        In io = new In(filename);
        String title = io.readLine();
        String xAxis = io.readLine();
        String source = io.readLine();
        BarChart chart = new BarChart(title, xAxis, source);
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
        while (io.hasNextLine()) {

            io.readLine();
            int n = Integer.parseInt(io.readLine());
            Bar[] bars = new Bar[n];
            String year = "";
            String name = "";
            String country = "";
            int value = 0;
            String category = "";
            //    System.out.println("n=" + n);
            for (int i = 0; i < n; i++) {
                String row = io.readLine();
                String[] a = new String[5];
                a = row.split(",");
                //  System.out.println(row);
                year = a[0];
                name = a[1];
                country = a[2];
                value = Integer.parseInt(a[3]);
                category = a[4];
                bars[i] = new Bar(name, value, category);
            }
            Arrays.sort(bars);
            chart.setCaption(year);
            for (int i = bars.length - 1; i >= bars.length - k; i--) {
                if (bars[i].getValue() > 0)
                    chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            StdDraw.clear();
            chart.reset();
        }

    }
}
