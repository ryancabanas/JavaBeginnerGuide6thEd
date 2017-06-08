/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter06;

/**
 *
 * @author Ryan Cabanas
 */
public class Problem13_SumVarArgs {
  
  public static int sum(int...x) {
    int sum = 0;
    for(int y: x) {
      sum += y;
    }
    return sum;
  }
  
}
