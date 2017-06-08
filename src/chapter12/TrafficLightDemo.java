/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

// Try This 12-1

// A simulation of a traffic light that uses 
// an enumeration to describe the light's color. 
 
// An enumeration of the colors of a traffic light. 
enum TrafficLightColor {  
  RED(12000), GREEN(10000), YELLOW(2000);

  private long delay;
  
  private TrafficLightColor(long delay) {
    this.delay = delay;
  }
  
  long getDelay() {
    return delay;
  }
} 
 
// A computerized traffic light. 
class TrafficLightSimulator implements Runnable { 
  private final Thread thrd; // holds the thread that runs the simulation 
  private TrafficLightColor tlc; // holds the current traffic light color 
  boolean stop = false; // set to true to stop the simulation 
  boolean changed = false; // true when the light has changed
 
  TrafficLightSimulator(TrafficLightColor init) {  
    tlc = init; 
 
    thrd = new Thread(this); 
    thrd.start(); 
  } 
 
  TrafficLightSimulator() {  
    tlc = TrafficLightColor.RED; 
 
    thrd = new Thread(this); 
    thrd.start(); 
  } 
 
  // Start up the light. 
  @Override
  public void run() { 
    while(!stop) { 
      try { 
        Thread.sleep(tlc.getDelay());
      } catch(InterruptedException exc) { 
        System.out.println(exc); 
      } 
      changeColor(); 
    }  
  } 
 
  // Change color. 
  synchronized void changeColor() { 
    if (tlc.ordinal() < TrafficLightColor.values().length-1) {
      tlc = TrafficLightColor.values()[tlc.ordinal()+1];
    } else {
      tlc = TrafficLightColor.values()[0];
    }
 
    changed = true;
    notify(); // signal that the light has changed 
  } 
 
  // Wait until a light change occurs. 
  synchronized void waitForChange() { 
    try { 
      while(!changed) 
        wait(); // wait for light to change 
      changed = false;
    } catch(InterruptedException exc) { 
      System.out.println(exc); 
    } 
  } 
 
  // Return current color. 
  synchronized TrafficLightColor getColor() { 
    return tlc; 
  } 
 
  // Stop the traffic light. 
  synchronized void cancel() { 
    stop = true; 
  } 
}  
  
class TrafficLightDemo {  
//  public static void main(String args[]) {  
//    TrafficLightSimulator tl =
//      new TrafficLightSimulator(TrafficLightColor.GREEN); 
// 
//    for(int i=0; i < 9; i++) { 
//      System.out.println(tl.getColor()); 
//      tl.waitForChange(); 
//    } 
// 
//    tl.cancel(); 
//  }  
}
