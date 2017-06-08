/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter09.problem10;

import java.io.IOException;

/**
 *
 * @author Ryan Cabanas
 */
public class Stack {
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
  private int currentIndexPosition;
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
  public Stack() {
    size = 10;
    currentIndexPosition = 0;
    lastIndexPosition = size - 1;
    theArray = new char[size];
    start();
  }
  /**
   * Constructor with an array size specified.
   * @param size The size you want the array to be.
   */
  public Stack(int size) {
    this.size = size;
    currentIndexPosition = 0;
    lastIndexPosition = size - 1;
    theArray = new char[size];
    start();
  }
  
  /**********/
  /*Methods */
  /**********/
  /**
   * Starts the program.
   */
  public final void start() {
    do {
      System.out.print("Choose something to do...a push(+), a pop(-), or diplay(=):");

      try {
        do {
          ch = (char) System.in.read();
        } while(ch == '\n');
        
        switch (ch) {
          case '+':
            push();
            break;
          case '-':
            pop();
            break;
          case '=':
            display();
            break;
          default:
            break;
        }
      } catch (IOException | StackFullException | StackEmptyException e) {
        System.out.println(e.toString());
      }
      
    } while(ch != '.');
    
  }
  
  /**
   * Adds a new character to the stack.
   */
  private void push() throws StackFullException {
    do {
      if(currentIndexPosition == size) {
        throw new StackFullException();
      }
      
      try {
        System.out.print("Type a single letter to add to the stack and press \"Enter\": ");
        
        do {
          ch = (char) System.in.read();          
        } while(ch == '\n');
        
        if(Character.isLetter(ch)) {
          theArray[currentIndexPosition++] = ch;
          System.out.println("\'" + ch + "\' added to the stack. "
                  + (size - currentIndexPosition) + " slots remaining.");
        }
      } catch (IOException e) {
        e.toString();
      }      
    } while(!Character.isLetter(ch));
  }
  
  /**
   * Pulls off the last character from the stack.
   */
  private void pop() throws StackEmptyException {
    if(currentIndexPosition == 0) {
      throw new StackEmptyException();
    }
    
    System.out.println("\'" + theArray[--currentIndexPosition] + "\' popped off of the stack. "
    + (size - currentIndexPosition) + " slots remaining." );
  }

  /**
   * Print out the characters in the stack.
   */
  private void display() throws StackEmptyException {
    if(currentIndexPosition == 0) {
      throw new StackEmptyException();
    }
    
    for(int i = 0; i < currentIndexPosition; i++)
      System.out.print(theArray[i]);
    
    System.out.println();
  }
  
}
