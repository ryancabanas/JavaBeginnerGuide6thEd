/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter01;

/**
 * Class used to convert inches to meters.
 * @author Ryan
 */
public class Problem10_InchesToMeters {
  /**
   * Inches to meters conversion ratio.
   */
  static final double INCH_TO_METER_CONVERSION = 1 / 39.37;

  /**
   * Converts inches to meters.
   * @param inches Integer value to be converted to meters.
   * @return Meters as a double value.
   */
  public static double convertIt(int inches) {
    return inches * INCH_TO_METER_CONVERSION;
  }
  
  /**
   * Prints a range of inches converted to meters.  Blank line inserted at every 1 foot marker.
   * @param begin The starting point of the inches range as an integer.
   * @param end The ending point of the inches range as an integer.
   */
  public static void printRange(int begin, int end) {
    for(; begin <= end; begin++) {
      System.out.println(
              Integer.toString(begin)
              + (begin == 1 ? " inch" : " inches")
              + " = "
              + Double.toString(convertIt(begin))
              + (convertIt(begin) == 1 ? " meter" : " meters"));
      
      if(begin % 12 == 0) System.out.println();
    }
  }
  
}
