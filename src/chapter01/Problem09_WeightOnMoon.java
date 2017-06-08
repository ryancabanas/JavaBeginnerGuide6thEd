/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter01;

/**
 * Class used to determine an Earth weight on the Moon.
 * @author Ryan
 */
public class Problem09_WeightOnMoon {
      
  /**
   * Accepts an Earthly integer weight and returns the integer weight as if you were on the Moon.
   * @param pounds Earthly integer weight.
   * @return Integer weight on the Moon.
   */
  public static int convertToMoonWeight (int pounds) {
    return (int) (pounds * 0.17);
  }
  
}
