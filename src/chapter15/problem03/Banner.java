/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter15.problem03;

/*  
   Try This 15-1 
 
   A simple banner applet. 
 
   This applet creates a thread that scrolls 
   the message contained in msg right to left 
   across the applet's window. 
*/ 
import java.awt.*; 
import java.applet.*; 
/* 
<applet code="Banner" width=300 height=50> 
</applet> 
*/ 
 
public class Banner extends Applet implements Runnable { 
  String msg;
  long delay;
  Thread t; 
  boolean stopFlag; 
 
  // Initialize t to null.  
  @Override
  public void init() { 
    t = null; 
    msg = getParameter("bannerString");
    delay = Long.parseLong(getParameter("bannerDelay"));
  } 
 
  // Start thread 
  @Override
  public void start() { 
    t = new Thread(this); 
    stopFlag = false; 
    t.start(); 
  } 
 
  // Entry point for the thread that runs the banner. 
  @Override
  public void run() { 
 
    // Display banner  
    for( ; ; ) { 
      try { 
        repaint(); 
        Thread.sleep(delay); 
        if(stopFlag)
          break; 
      } catch(InterruptedException exc) {} 
    } 
  } 
 
  // Pause the banner. 
  public void stop() { 
    stopFlag = true; 
    t = null; 
  } 
 
  // Display the banner. 
  public void paint(Graphics g) { 
    char ch; 

    ch = msg.charAt(0); 
    msg = msg.substring(1, msg.length()); 
    msg += ch; 
    g.drawString(msg, 50, 30); 
  } 
}