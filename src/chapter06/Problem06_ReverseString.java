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
public class Problem06_ReverseString {
  
  private static int indexPosition = 0;
  private static int lastIndex;
  private static String theString;
  private static StringBuilder reverseString;
  
  public static void start(String input) {
    theString = input;
    lastIndex = theString.length() - 1;
    reverseString = new StringBuilder(theString.length());
    reverse();
    System.out.println(reverseString.toString())    ;
  }
  
  private static void reverse() {
    if(indexPosition < lastIndex) {
      indexPosition++;
      reverse();
    }
    reverseString.append(theString.charAt(indexPosition--));
  }
  
}
