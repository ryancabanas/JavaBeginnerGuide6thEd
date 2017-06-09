/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter15.problem10;

// Demonstrate the mouse event handlers. 
import java.awt.*; 
import java.awt.event.*; 
import java.applet.*; 
/* 
  <applet code="MouseEvents" width=300 height=100> 
  </applet> 
*/ 
 
public class MouseEvents extends Applet 
  implements MouseListener, MouseMotionListener, MouseWheelListener { 
 
  String msg = ""; 
  int mouseX = 0, mouseY = 0; // coordinates of mouse
  int wheelClicks = 0;
 
  @Override
  public void init() { 
     addMouseListener(this); 
     addMouseMotionListener(this); 
     addMouseWheelListener(this);
  } 
 
  // Handle mouse clicked. 
  @Override
  public void mouseClicked(MouseEvent me) { 
    mouseX = 0; 
    mouseY = 10; 
    msg = "Mouse clicked."; 
    repaint(); 
  } 
 
  // Handle mouse entered. 
  @Override
  public void mouseEntered(MouseEvent me) { 
    mouseX = 0; 
    mouseY = 10; 
    msg = "Mouse entered."; 
    repaint(); 
  } 
 
  // Handle mouse exited. 
  @Override
  public void mouseExited(MouseEvent me) { 
    mouseX = 0; 
    mouseY = 10; 
    msg = "Mouse exited."; 
    repaint(); 
  } 
 
  // Handle button pressed. 
  @Override
  public void mousePressed(MouseEvent me) { 
    // save coordinates 
    mouseX = me.getX(); 
    mouseY = me.getY(); 
    msg = "Down"; 
    repaint(); 
  } 
 
  // Handle button released. 
  @Override
  public void mouseReleased(MouseEvent me) { 
    // save coordinates 
    mouseX = me.getX(); 
    mouseY = me.getY(); 
    msg = "Up"; 
    repaint(); 
  } 
 
  // Handle mouse dragged. 
  @Override
  public void mouseDragged(MouseEvent me) { 
    // save coordinates 
    mouseX = me.getX(); 
    mouseY = me.getY(); 
    msg = "*"; 
    showStatus("Dragging mouse at " + mouseX + ", " + mouseY); 
    repaint(); 
  } 
 
  // Handle mouse moved. 
  @Override
  public void mouseMoved(MouseEvent me) { 
    // show status 
    showStatus("Moving mouse at " + me.getX() + ", " + me.getY()); 
  } 
 
  @Override
  public void mouseWheelMoved(MouseWheelEvent mwe) {
    wheelClicks += mwe.getWheelRotation();
    if (wheelClicks > 0) {
      showStatus("Mouse wheel moved " + wheelClicks + " total clicks downward.");  
    } else if (wheelClicks < 0) {
      showStatus("Mouse wheel moved " + Math.abs(wheelClicks) + " total clicks upward.");  
    } else {
      showStatus("Mouse wheel is in original position.");  
    }
  }
  
  // Display msg in applet window at current X,Y location. 
  @Override
  public void paint(Graphics g) { 
    g.drawString(msg, mouseX, mouseY); 
    
  } 
}