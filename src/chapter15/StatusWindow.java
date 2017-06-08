/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter15;

// Using the Status Window. 
import java.awt.*; 
import java.applet.*; 
 
public class StatusWindow extends Applet{ 
  // Display msg in applet window. 
  @Override
  public void paint(Graphics g) { 
    g.drawString("This is in the applet window.", 10, 20); 
    showStatus("This is shown in the status window."); 
  } 
}