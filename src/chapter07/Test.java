/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter07;

/**
 *
 * @author Ryan Cabanas
 */
public class Test {
  //Variables
  private int x;
  private int y;
  
  //Constructors
  public Test() {
    x = 1;
    y = 2;
  }
  
  public Test(Test obj) {
    x = obj.x;
    y = obj.y;
  }
  
  public Test(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  //Accessor methods
  public void showVariables() {
    System.out.println(x + ", " + y);
  }
  
  //Methods
  public void showOtherGuysJunk(Test obj) {
    System.out.println(obj.x + ", " + obj.y);
  }
  
  public void setOtherGuysJunk(Test obj, int x, int y) {
    obj.x = x;
    obj.y = y;
  }
}
