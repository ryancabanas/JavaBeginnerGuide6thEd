/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13.circularqueue;

// A dynamic queue. 

import java.lang.reflect.Array;

class DynQueue<T> implements ICharQ<T> {
  private T[] q; // this array holds the queue    
  private T[] temp; // this is a temp array that will be used when auto-growth kicks in
  private int putloc, getloc; // the put and get indices    
    
  // Construct an empty queue given its size.   
  public DynQueue(T[] q) {
    this.q = q; // allocate memory for queue    
    putloc = getloc = 0;    
  }    
   
  // Put a characer into the queue.    
  @Override
  public void put(T t) {    
    if(putloc == q.length) { 
      Class<?> tClass = t.getClass();
      int size = q.length * 2;
      // increase queue size 
      temp = (T[])Array.newInstance(tClass, size);
 
      // copy elements into new queue
      System.arraycopy(q, 0, temp, 0, q.length);
      q = temp; 
    }    
    q[putloc++] = t;    
  }    
    
  // Get a character from the queue.   
  @Override
  public T get() {    
    if(getloc == putloc) {    
      System.out.print("\n -- Queue is empty.");    
      return null;     
    }
    return q[getloc++];    
  }    
}