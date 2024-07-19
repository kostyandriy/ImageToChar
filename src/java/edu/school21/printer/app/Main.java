package edu.school21.printer.app;

import com.beust.jcommander.*;
import edu.school21.printer.logic.ImagesToChar;

@Parameters(separators = "=")
public class Main {
  public static void main(String[] args) {
    try {
      JCommander.newBuilder().addObject(new Main()).build().parse(args);
    } catch (ParameterException e) {
      System.err.println("Error: wrong parameteres");
      System.exit(-1);
    }

    ImagesToChar imagesToChar = new ImagesToChar(black, white);
    imagesToChar.start();
  }

  @Parameter(names = {"--black", "-b"}, description = "Color for background", required = true)
  private static String black;

  @Parameter(names = {"--white", "-w"}, description = "Color for image", required = true)
  private static String white;
}
