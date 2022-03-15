package com.jardadev;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessor {
    private BufferedImage img = null;

    public ImageProcessor(String path, String outPath) throws IOException {

        //load image
        img = readFile(path);

        //convert colors
        makeItBlackOrWhite(img);
        ImageIO.write(img, "jpg", new File("convertedColors.jpg"));

        //identify objects
        ObjectIdentificator objI = new ObjectIdentificator(img);
        objI.IdentifyPad();
        objI.MarkPad();
        ImageIO.write(img, "jpg", new File("markedPad.jpg"));
        objI.CropPad();
        objI.FillFullPad();
        objI.IdentifyItem();
        objI.MarkItem();
        ImageIO.write(img, "jpg", new File("markedItem.jpg"));
        objI.CalculateSize();
        //ImageIO.write(objI.GetImage(), "jpg", new File(outPath));
    }

    private BufferedImage readFile(String path) throws IOException {
        File f = new File(path);

        BufferedImage img = ImageIO.read(f);
        return img;
    }

    private void makeItBlackOrWhite(BufferedImage img) {
        int pixel;
        int r;
        int g;
        int b;
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                pixel = img.getRGB(j, i);
                r = (pixel >> 16) & 0xFF;
                g = (pixel >> 8) & 0xFF;
                b = (pixel) & 0xFF;
                if (r < 140 && g < 140 && b < 140) {
                    img.setRGB(j, i, -16777216);
                } else {
                    img.setRGB(j, i, -1);
                }
            }
        }
    }
}
