/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13.circularqueue;

// A fixed-size queue class for characters.    
class FixedQueue<T> implements ICharQ<T> {    
  private final T[] q; // this array holds the queue    
  private int putloc, getloc; // the put and get indices    
    
  // Construct an empty queue given its size.   
  public FixedQueue(T[] q) {    
    this.q = q;
    putloc = getloc = 0;    
  }    
   
  // Put a characer into the queue.    
  @Override
  public void put(T t) {    
    if(putloc == q.length) {    
      System.out.println(" -- Queue is full.");    
      return;    
    }    
        
    q[putloc++] = t;    
  }    
    
  // Get a character from the queue.   
  @Override
  public T get() {    
    if(getloc == putloc) {    
      System.out.println(" -- Queue is empty.");    
      return null;     
    }    
      
    return q[getloc++];    
  }    
}
