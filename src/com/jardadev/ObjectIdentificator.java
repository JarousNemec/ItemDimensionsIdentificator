package com.jardadev;

import java.awt.image.BufferedImage;

public class ObjectIdentificator {
    BufferedImage img;
    Pad pad;
    Item item;

    public ObjectIdentificator(BufferedImage img) {
        this.img = img;
        pad = new Pad();
        item = new Item();
    }

    public void IdentifyPad() {
        int pixel;
        int r;
        int g;
        int b;
        boolean found = false;
        //identify top
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                pixel = img.getRGB(j, i);
                r = (pixel >> 16) & 0xFF;
                g = (pixel >> 8) & 0xFF;
                b = (pixel) & 0xFF;
                if (r > 140 && g > 140 && b > 140) {
                    pad.top.x = j;
                    pad.top.y = i;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        found = false;
        //identify bottom
        for (int i = img.getHeight() - 1; i >= 0; i--) {
            for (int j = 0; j < img.getWidth(); j++) {
                pixel = img.getRGB(j, i);
                r = (pixel >> 16) & 0xFF;
                g = (pixel >> 8) & 0xFF;
                b = (pixel) & 0xFF;
                if (r > 140 && g > 140 && b > 140) {
                    pad.bottom.x = j;
                    pad.bottom.y = i;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        found = false;
        //identify left
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                pixel = img.getRGB(i, j);
                r = (pixel >> 16) & 0xFF;
                g = (pixel >> 8) & 0xFF;
                b = (pixel) & 0xFF;
                if (r > 140 && g > 140 && b > 140) {
                    pad.left.x = i;
                    pad.left.y = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        found = false;
        //identify right
        for (int i = img.getWidth() - 1; i >= 0; i--) {
            for (int j = 0; j < img.getHeight(); j++) {
                pixel = img.getRGB(i, j);
                r = (pixel >> 16) & 0xFF;
                g = (pixel >> 8) & 0xFF;
                b = (pixel) & 0xFF;
                if (r > 140 && g > 140 && b > 140) {
                    pad.right.x = i;
                    pad.right.y = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
    }

    public void MarkPad() {
        //mark top
        for (int i = 0; i < img.getWidth(); i++) {
            img.setRGB(i, pad.top.y, 16733728);
        }

        //mark bottom
        for (int i = 0; i < img.getWidth(); i++) {
            img.setRGB(i, pad.bottom.y, 16733728);
        }

        //mark left
        for (int i = 0; i < img.getHeight(); i++) {
            img.setRGB(pad.left.x, i, 16733728);

        }

        //mark left
        for (int i = 0; i < img.getHeight(); i++) {
            img.setRGB(pad.right.x, i, 16733728);
        }
    }

    public void CropPad() {
        img = img.getSubimage(pad.left.x, pad.top.y, pad.right.x-pad.left.x, pad.bottom.y-pad.top.y);
    }

    public void FillFullPad(){

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                img.setRGB(j, i, -1);
            }
        }

        for (int i = img.getHeight() - 1; i >= img.getHeight() - 10; i--) {
            for (int j = 0; j < img.getWidth(); j++) {
                img.setRGB(j, i, -1);
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                img.setRGB(i, j, -1);
            }
        }

        for (int i = img.getWidth() - 1; i >= img.getWidth() - 10; i--) {
            for (int j = 0; j < img.getHeight(); j++) {
                img.setRGB(i, j, -1);
            }
        }
    }

    public void IdentifyItem() {
        int pixel = -1;
        int r = 0;
        int g = 0;
        int b = 0;
        boolean found = false;
        //identify top
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                pixel = img.getRGB(j, i);
                r = (pixel >> 16) & 0xFF;
                g = (pixel >> 8) & 0xFF;
                b = (pixel >> 0) & 0xFF;
                if (r < 140 && g < 140 && b < 140) {
                    item.top.x = j;
                    item.top.y = i;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        found = false;
        //identify bottom
        for (int i = img.getHeight() - 1; i >= 0; i--) {
            for (int j = 0; j < img.getWidth(); j++) {
                pixel = img.getRGB(j, i);
                r = (pixel >> 16) & 0xFF;
                g = (pixel >> 8) & 0xFF;
                b = (pixel >> 0) & 0xFF;
                if (r < 140 && g < 140 && b < 140) {
                    item.bottom.x = j;
                    item.bottom.y = i;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        found = false;
        //identify left
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                pixel = img.getRGB(i, j);
                r = (pixel >> 16) & 0xFF;
                g = (pixel >> 8) & 0xFF;
                b = (pixel >> 0) & 0xFF;
                if (r < 140 && g < 140 && b < 140) {
                    item.left.x = i;
                    item.left.y = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        found = false;
        //identify right
        for (int i = img.getWidth() - 1; i >= 0; i--) {
            for (int j = 0; j < img.getHeight(); j++) {
                pixel = img.getRGB(i, j);
                r = (pixel >> 16) & 0xFF;
                g = (pixel >> 8) & 0xFF;
                b = (pixel >> 0) & 0xFF;
                if (r < 140 && g < 140 && b < 140) {
                    item.right.x = i;
                    item.right.y = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
    }

    public void MarkItem() {
        //mark top
        for (int i = 0; i < img.getWidth(); i++) {
            img.setRGB(i, item.top.y, 16733728);
        }

        //mark bottom
        for (int i = 0; i < img.getWidth(); i++) {
            img.setRGB(i, item.bottom.y, 16733728);
        }

        //mark left
        for (int i = 0; i < img.getHeight(); i++) {
            img.setRGB(item.left.x, i, 16733728);

        }

        //mark left
        for (int i = 0; i < img.getHeight(); i++) {
            img.setRGB(item.right.x, i, 16733728);
        }
    }

    public void CalculateSize(){
        double sizePixelX = (double) 210 / img.getWidth();
        double sizePixelY = (double) 297 / img.getHeight();
        double itemPixelWidth = item.right.x-item.left.x;
        double itemPixelHeight = item.bottom.y - item.top.y;
        double Width = sizePixelX * itemPixelWidth;
        double Height = sizePixelY * itemPixelHeight;
        System.out.println("Width:"+Width+" mm");
        System.out.println("Height:"+Height+" mm");

    }

    public BufferedImage GetImage() {
        return img;
    }
}
