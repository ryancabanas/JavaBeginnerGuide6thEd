/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter03;

import java.io.IOException;

/**
 * A class responsible for converting lowercase characters to uppercase and vise-versa.
 * @author Ryan Cabanas
 */
public class Problem10_ConvertCase {
  private static char lastKey;
  private static int count = 0;
  
  /**
   * Starts the character conversion program.
   * are printed untouched.
   */
  public static void initiate() {
    System.out.println("Enter a character and press the \"Enter\" key after each:");
    
    do {
      try {
        lastKey = (char) System.in.read();
        System.out.print(convert(lastKey));
      }
      catch (IOException ex) {
        System.out.println(ex.toString());
      }
    } while(lastKey != '.');
    
    System.out.println("Total number of conversion: " + count);
  }

  private static char convert(char c) {
    if(c >= 65 && c <= 90) {
      count++;
      return (char) (c + 32);
    }
    if(c >= 97 && c <= 122) {
      count++;
      return (char) (c - 32);
    }
    return c;
  }
  
}
