/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter05;

import java.util.Arrays;

/**
 * Class to find the min and max values of an array of integer values.
 * @author Ryan Cabanas
 */
public class Problem13_MinMax {
  /**
   * An array of integers.
   */
  private static int[] intArray = {15, 46, 27, 0, 6, 9, 74, 111, 45, 324, 77};
  /**
   * Min and max variables.
   */
  private static int min, max;
  
  /**
   * Sifts through the array of integers, finds the min and max values, and prints them.
   */
  public static void start() {
    for(int i: intArray) {
      if(i < min) min = i;
      if(i > max) max = i;
    }
    
    System.out.println("Original values: " + Arrays.toString(intArray));
    System.out.println("Min: " + min);
    System.out.println("Max: " + max);
  }
  
}
