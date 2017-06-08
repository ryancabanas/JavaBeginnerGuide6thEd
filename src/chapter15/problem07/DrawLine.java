/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter15.problem07;

// Demonstrate the mouse event handlers. 
import java.awt.*; 
import java.awt.event.*; 
import java.applet.*; 
/* 
  <applet code="MouseEvents" width=300 height=100> 
  </applet> 
*/ 
 
public class DrawLine extends Applet
  implements MouseListener, MouseMotionListener {

  String msg = "";
  int mouseX1 = 0, mouseY1 = 0;
  int mouseX2 = 0, mouseY2 = 0;

  @Override
  public void init() {
     addMouseListener(this);
     addMouseMotionListener(this);
  }

  // Handle mouse clicked.
  @Override
  public void mouseClicked(MouseEvent me) {

  }

  // Handle mouse entered.
  @Override
  public void mouseEntered(MouseEvent me) {

  }

  // Handle mouse exited.
  @Override
  public void mouseExited(MouseEvent me) {

  }

  // Handle button pressed.
  @Override
  public void mousePressed(MouseEvent me) {
    mouseX1 = me.getX();
    mouseY1 = me.getY();
  }

  // Handle button released.
  @Override
  public void mouseReleased(MouseEvent me) {
    repaint();
  }
  
  // Handle mouse dragged.
  @Override
  public void mouseDragged(MouseEvent me) {
    mouseX2 = me.getX();
    mouseY2 = me.getY();
    repaint();
  }

  // Handle mouse moved.
  @Override
  public void mouseMoved(MouseEvent me) {

  }

  @Override
  public void paint(Graphics g) {
    g.setColor(Color.RED);
    g.drawLine(mouseX1, mouseY1, mouseX2, mouseY2);
  }
}
