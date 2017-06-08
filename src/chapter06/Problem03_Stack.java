/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter06;

import java.io.IOException;

/**
 *
 * @author Ryan Cabanas
 */
public class Problem03_Stack {
  /*************/
  /*Variables  */
  /*************/
  /**
   * The size of the character array.
   */
  private final int size;
  /**
   * The max reference index value of the array.
   */
  private final int lastIndexPosition;
  /**
   * The current index reference position being pointed to in the array.
   */
  private int currentIndexPosition = -1;
  /**
   * The last character retrieved from the user.
   */
  private char ch;
  /**
   * The stack array.
   */
  private char[] theArray;
  
  /****************/
  /*Constructors  */
  /****************/
  /**
   * Default constructor.  Default array size is 10.
   */
  public Problem03_Stack() {
    size = 10;
    lastIndexPosition = size - 1;
    theArray = new char[size];
  }
  /**
   * Constructor with an array size specified.
   * @param size The size you want the array to be.
   */
  public Problem03_Stack(int size) {
    this.size = size;
    lastIndexPosition = size - 1;
    theArray = new char[size];
  }
  
  /**********/
  /*Methods */
  /**********/
  /**
   * Starts the program.
   */
  public void start() {
    do {
      System.out.print("Choose something to do...a push(+), a pop(-), or diplay(=):");
      
      try {
        do {
          ch = (char) System.in.read();
        } while(ch == '\n');
        
        if(ch == '+') push();
        if(ch == '-') pop();
        if(ch == '=') display();
      } catch (IOException e) {
        e.toString();
      }
      
    } while(ch != '.');
    
  }
  
  /**
   * Adds a new character to the stack.
   */
  private void push() {
    do {
      if(currentIndexPosition == lastIndexPosition) {
        System.out.println("The stack is currently full. Pop something off first.");
        return;
      }
      
      try {
        System.out.print("Type a single letter to add to the stack and press \"Enter\": ");
        
        do {
          ch = (char) System.in.read();          
        } while(ch == '\n');
        
        if(Character.isLetter(ch)) {
          theArray[++currentIndexPosition] = ch;
          System.out.println("\'" + ch + "\' added to the stack. "
                  + (lastIndexPosition - currentIndexPosition) + " slots remaining.");
        }
      } catch (IOException e) {
        e.toString();
      }      
    } while(!Character.isLetter(ch));
  }
  
  /**
   * Pulls off the last character from the stack.
   */
  private void pop() {
    if(currentIndexPosition == -1) {
        System.out.println("The stack is empty. Push something to it first.");
        return;
    }
    
    System.out.println("\'" + theArray[currentIndexPosition--] + "\' popped off of the stack."
    + (lastIndexPosition - currentIndexPosition) + " slots remaining." );
  }

  /**
   * Print out the characters in the stack.
   */
  private void display() {
    if(currentIndexPosition == -1) {
      System.out.println("The stack is currently empty.");
      return;
    }
    
    for(int i = 0; i <= currentIndexPosition; i++)
      System.out.print(theArray[i]);
    
    System.out.println();
  }
  
}
