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
import java.util.ArrayList;
/* 
  <applet code="MouseEvents" width=300 height=100> 
  </applet> 
*/ 
 
public class DrawLine extends Applet
  implements MouseListener, MouseMotionListener {

  String msg = "";
  XYLineCoordinatesArray array;
  ArrayList<XYLineCoordinatesArray> arrayList = new ArrayList();

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
    array = new XYLineCoordinatesArray();
    array.addStartPoint(me.getX(), me.getY());
    arrayList.add(array);
  }

  // Handle button released.
  @Override
  public void mouseReleased(MouseEvent me) {
    repaint();
  }
  
  // Handle mouse dragged.
  @Override
  public void mouseDragged(MouseEvent me) {
    array.addEndPoint(me.getX(), me.getY());
    arrayList.set(arrayList.size()-1, array);
    repaint();
  }

  // Handle mouse moved.
  @Override
  public void mouseMoved(MouseEvent me) {

  }

  @Override
  public void paint(Graphics g) {
    g.setColor(Color.RED);
    arrayList.forEach((x) -> g.drawLine(x.array[0], x.array[1], x.array[2], x.array[3]));
  }
  
  class XYLineCoordinatesArray{
    Integer[] array;

    XYLineCoordinatesArray() {
      array = new Integer[4];
    }

    void addStartPoint(int x, int y) {
      array[0] = x;
      array[1] = y;
    }

    void addEndPoint(int x, int y) {
      array[2] = x;
      array[3] = y;
    }
  }
}

