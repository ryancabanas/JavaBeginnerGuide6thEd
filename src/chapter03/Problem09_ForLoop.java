/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter03;

/**
 * A class that tests a for loop.
 * @author Ryan Cabanas
 */
public class Problem09_ForLoop {
  
  /**
   * Tests a for loop using the integer range of 1 to some ending integer.
   * @param y The ending integer of the test range.
   */
  public static void Test(int y) {
    StringBuilder result = new StringBuilder();
    
    for(int i = 1; i <= y; i *= 2) {
      result.append(i).append(", ");
    }
    
    result.delete(result.length() - 2, result.length());
    System.out.println(result.toString());
  }
  
}
