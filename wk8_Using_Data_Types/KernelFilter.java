import java.awt.Color;

public class KernelFilter {
    // Returns a new picture that applies an arbitrary kernel filter to the given picture.
    private static int res(double color) {
        int n = (int) Math.round(color);
        if (n < 0) return 0;
        if (n > 255) return 255;
        return n;
    }

    private static Picture kernel(Picture picture, double[][] weights) {
        int w = picture.width();
        int h = picture.height();
        Picture picnew = new Picture(w, h);
        for (int x = 0; x < w; x++)
            for (int y = 0; y < h; y++) {
                double rr = 0.0;
                double gg = 0.0;
                double bb = 0.0;
                for (int i = -weights.length / 2; i <= weights.length / 2; i++)
                    for (int j = -weights[0].length / 2; j <= weights[0].length / 2; j++) {
                        Color csource = picture.get(Math.floorMod(i + x, w), Math.floorMod(j + y, h));
                        double r = csource.getRed();
                        double g = csource.getGreen();
                        double b = csource.getBlue();
                        rr += weights[i + weights.length / 2][j + weights[0].length / 2] * r;
                        gg += weights[i + weights.length / 2][j + weights[0].length / 2] * g;
                        bb += weights[i + weights.length / 2][j + weights[0].length / 2] * b;
                    }
                Color cdest = new Color(res(rr), res(gg), res(bb));
                picnew.set(x, y, cdest);
            }

        return picnew;
    }


    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] a = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        return kernel(picture, a);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] a = {
                {1, 2, 1},
                {2, 4, 2},
                {1, 2, 1}};
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                a[i][j] = a[i][j] / 16;
        return kernel(picture, a);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] a = {
                {0, -1, 0},
                {-1, 5, -1},
                {0, -1, 0}};
        return kernel(picture, a);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] a = {
                {-1, -1, -1},
                {-1, 8, -1},
                {-1, -1, -1}};
        return kernel(picture, a);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] a = {
                {-2, -1, 0},
                {-1, 1, 1},
                {0, 1, 2}};
        return kernel(picture, a);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] a = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1}};
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                a[i][j] = a[i][j] / 9;
        return kernel(picture, a);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture source = new Picture(args[0]);
        Picture target = identity(source);
        target.show();
        target = gaussian(source);
        target.show();
        target = sharpen(source);
        target.show();
        target = laplacian(source);
        target.show();
        target = emboss(source);
        target.show();
        target = motionBlur(source);
        target.show();

    }
}
