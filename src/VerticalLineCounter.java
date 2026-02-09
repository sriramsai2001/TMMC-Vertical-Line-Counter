import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class VerticalLineCounter {

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("Error: Please provide exactly one image path.");
                return;
            }

            BufferedImage image = ImageIO.read(new File(args[0]));
            if (image == null) {
                System.out.println("Error: Invalid image file.");
                return;
            }

            int width = image.getWidth();
            int height = image.getHeight();

            boolean prevBlack = false;
            int count = 0;

            for (int x = 0; x < width; x++) {

                int topBlack = 0;
                int bottomBlack = 0;

                for (int y = 0; y < height / 2; y++) {
                    int rgb = image.getRGB(x, y);
                    if (((rgb >> 16) & 0xFF) < 50 &&
                            ((rgb >> 8) & 0xFF) < 50 &&
                            (rgb & 0xFF) < 50) {
                        topBlack++;
                    }
                }

                for (int y = height / 2; y < height; y++) {
                    int rgb = image.getRGB(x, y);
                    if (((rgb >> 16) & 0xFF) < 50 &&
                            ((rgb >> 8) & 0xFF) < 50 &&
                            (rgb & 0xFF) < 50) {
                        bottomBlack++;
                    }
                }

                boolean isBlack =
                        topBlack > (height / 2) * 0.3 &&
                                bottomBlack > (height / 2) * 0.3;

                if (isBlack && !prevBlack) {
                    count++;
                }

                prevBlack = isBlack;
            }

            System.out.println(count);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
