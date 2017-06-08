/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13.circularqueue;

// A character queue interface. 
public interface ICharQ<T> {    
  // Put a characer into the queue.    
  void put(T ch); 
 
  // Get a character from the queue.   
  T get(); 
}
