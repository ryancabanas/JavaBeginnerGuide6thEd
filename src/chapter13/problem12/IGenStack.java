/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13.problem12;

/**
 *
 * @author Ryan Cabanas
 * @param <T> An object of class Character, or a subclass of.
 */
interface IGenStack<T> {
  
  void push() throws StackFullException;
  
  void pop() throws StackEmptyException;
}
