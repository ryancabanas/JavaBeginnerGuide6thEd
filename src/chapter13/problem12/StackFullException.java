/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13.problem12;

/**
 *
 * @author Ryan Cabanas
 */
public class StackFullException extends Exception {
  
  @Override
  public String toString() {
    return "The stack is currently full. Pop something off first.";
  }
}
