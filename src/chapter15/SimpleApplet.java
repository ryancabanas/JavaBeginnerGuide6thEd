/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter15;

// A minimal AWT-based applet. 
import java.awt.*; 
import java.applet.*;

public class SimpleApplet extends Applet { 
  @Override
  public void paint(Graphics g) { 
    g.drawString("Java makes applets easy.", 20, 20); 
  } 
}
