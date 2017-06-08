/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13.circularqueue;

// A circular queue. 
public class CircularQueue<T> implements ICharQ<T> {    
  private final T[] q; // this array holds the queue    
  private int putloc, getloc; // the put and get indices
  private boolean empty;
    
  // Construct an empty queue given its size.   
  public CircularQueue(T[] q) {    
    this.q = q;
    putloc = getloc = 0;    
    empty = true;
  }    
   
  // Put a characer into the queue.
  @Override
  public void put(T t) {    
    /* Queue is full if either putloc is one less than 
       getloc, or if putloc is at the end of the array 
       and getloc is at the beginning. */ 
    if(((putloc == getloc) && !empty) || ((getloc == 0) && (putloc == q.length))) {    
      System.out.println(" -- Queue is full.");    
      return;    
    }
    q[putloc++] = t;
    if(putloc == q.length) {
      putloc = 0;
    }
    empty = false;
  }    
    
  // Get a character from the queue.   
  @Override
  public T get() {    
    if(empty) {
      System.out.print("\n -- Queue is empty.");    
      return null;
    }
    T t = q[getloc++];
    if(getloc == q.length) {
      getloc = 0;
    } // loop back 
    if (getloc == putloc) {
      empty = true;
    }
    return t;
  }    
}
