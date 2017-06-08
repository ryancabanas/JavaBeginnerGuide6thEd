/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter15.problem04;

import java.awt.*;
import java.applet.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Ryan Cabanas
 */
public class Clock extends Applet implements Runnable {
  Thread thread;
  String time;
  
  /**
   * Initialization method that will be called after the applet is loaded into the browser.
   */
  @Override
  public void init() {
    thread = null;
    time = null;
  }
  
  @Override
  public void start() {
    thread = new Thread(this);
    thread.start();
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
      repaint();
      try {
        thread.sleep(1000);      
      } catch (Exception e) {
      }
    }
    thread = null;
  }
  
  @Override
  public void paint(Graphics g) {
    g.drawString(time, 10, 20);
  }
}

