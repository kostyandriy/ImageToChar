package edu.school21.printer.logic;

import com.diogonunes.jcolor.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImagesToChar {
  public ImagesToChar(String black, String white) {
    this.black = getColor(black);
    this.white = getColor(white);
    path = "/resources/image.bmp";
  }

  public void start() {
    testImage();
    printImage();
  }

  private void testImage() {
    try {
      image = ImageIO.read(ImagesToChar.class.getResource(path));
    } catch (IOException e) {
      System.err.println("Error: not a file");
      System.exit(-1);
    }

    if (image == null) {
      System.err.println("Error: error in uploading image");
      System.exit(-1);
    }

    int width = image.getWidth();
    int height = image.getHeight();

    if (width != 16 || height != 16) {
      System.err.println("Error: format is not 16x16");
      System.exit(-1);
    }
  }

  private void printImage() {
    int width = image.getWidth();
    int height = image.getHeight();
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int pixel = image.getRGB(x, y);

        int gray = (pixel >> 16) & 0xff;
        Attribute color = black;
        if (gray == 0) {
          color = white;
        }
        System.out.print(Ansi.colorize(" ", color));
      }
      System.out.println();
    }
  }

  private Attribute getColor(String color) {
    switch (color.toLowerCase()) {
      case "black":
        return Attribute.BLACK_BACK();
      case "red":
        return Attribute.RED_BACK();
      case "green":
        return Attribute.GREEN_BACK();
      case "yellow":
        return Attribute.YELLOW_BACK();
      case "blue":
        return Attribute.BLUE_BACK();
      case "magenta":
        return Attribute.MAGENTA_BACK();
      case "cyan":
        return Attribute.CYAN_BACK();
      case "white":
        return Attribute.WHITE_BACK();
      default:
        return Attribute.BLACK_BACK();
    }
  }

  private String path;
  private BufferedImage image;
  private Attribute black;
  private Attribute white;
}
