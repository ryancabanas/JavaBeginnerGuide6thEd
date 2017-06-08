/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter06;

/**
 *
 * @author Ryan Cabanas
 */
public class Problem04_Test {
 
  int a;
  int temp;

  public Problem04_Test(int a) {
    this.a = a;
  }
  
  public void swap(Problem04_Test obj) {
    System.out.println("This object's \'a\' value before the swap: " + this.a);
    System.out.println("Argument object\'s \'a\' value before the swap: " + obj.a);
    
    this.temp = this.a;
    this.a = obj.a;
    obj.a = this.temp;
    
    System.out.println("This object's \'a\' value after the swap: " + this.a);
    System.out.println("Argument object\'s \'a\' after the swap: " + obj.a);
  }
  
}
