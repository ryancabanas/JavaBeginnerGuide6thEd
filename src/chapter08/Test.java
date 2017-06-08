/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter08;

/**
 *
 * @author Ryan Cabanas
 */
public class Test {
  
  private static final int VALUE = 0;
  
  //Static methods do not get inherited.
  public static int getValue() {
    return VALUE;
  }
}
