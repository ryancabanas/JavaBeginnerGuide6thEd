/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter05;

import java.util.Arrays;

/**
 * Class to find the average of an array of double values.
 * @author Ryan Cabanas
 */
public class Problem03_Average {
  
  /**
   * Accepts an array of doubles and returns the average.
   * @param d An array of double values.
   * @return The average of all values in the array as a double.
   */
  public static double getAverage(double[] d) {
    return Arrays.stream(d).average().getAsDouble();
  }
  
}
