/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter03;

import java.io.IOException;

/**
 * A class that accepts input characters until a period character is detected.  The class also
 * returns the number of times the space bar was pressed during this period.
 * @author Ryan Cabanas
 */
public class Problem01_CountSpaces {
  
  /**
   * Holds a count of the number of times the space bar was pressed.
   */
  private int spaceBars;
  /**
   * Holds the last input character received from the keyboard.
   */
  private char lastChar;

  /**
   * Default constructor.
   */
  public Problem01_CountSpaces() {
    spaceBars = 0;
  }
  
  /**
   * Begins the process of reading user input from the keyboard.  The method counts the number of
   * times the space bar was pressed.  The method returns to its caller when the period key is
   * pressed on the keyboard.
   */
  public void interact() {
    System.out.println("Press a key on the keyboard, followed by the \"Enter\" key:");
    
    do {
      try {
        lastChar = (char) System.in.read();
        if(lastChar == ' ') spaceBars++;
      }
      catch (IOException ex) {
        System.out.println(ex.toString());
      }
    } while(lastChar != '.');
    
    printSpaces();
  }
  
  /**
   * Prints the number of times the space bar was pressed.
   */
  private void printSpaces() {
    System.out.println("The number of times the spacebar was pressed was " + spaceBars + ".");
  }
  
}
