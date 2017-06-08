/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13.circularqueue;

// Demonstrate the ICharQ interface.    
class IQDemo {    
//  public static void main(String args[]) {    
//    Character[] q5 = new Character[5];
//    Character[] q10 = new Character[10];
//    
//    CircularQueue<Character> q1 = new CircularQueue(q10);
//    DynQueue q2 = new DynQueue(q5); 
//    CircularQueue<Character> q3 = new CircularQueue(q10);
// 
//    ICharQ<Character> iQ;
// 
//    char ch;
//    int i;
// 
//    iQ = q1;
//    // Put some characters into fixed queue.    
//    for(i=0; i < 10; i++) {
//      iQ.put((char) ('A' + i));      
//    }
//   
//    // Show the queue. 
//    System.out.print("Contents of fixed queue: ");    
//    for(i=0; i < 10; i++) {     
//      try {
//        ch = iQ.get();
//        System.out.print(ch);
//      } catch (Exception e) {
//      }
//    } 
//    System.out.println(); 
// 
//    iQ = q2;
//    
//    // Put some characters into dynamic queue.    
//    for(i=0; i < 10; i++) {
//      iQ.put((char) ('Z' - i));      
//    }
//   
//    // Show the queue. 
//    System.out.print("Contents of dynamic queue: ");    
//    for(i=0; i < 10; i++) {     
//      try {
//        ch = iQ.get();    
//        System.out.print(ch);            
//      } catch (Exception e) {
//      }
//    }    
// 
//    System.out.println(); 
// 
//    iQ = q3; 
//    // Put some characters into circular queue.    
//    for(i=0; i < 10; i++)    
//      iQ.put((char) ('A' + i));    
//   
//    // Show the queue. 
//    System.out.print("Contents of circular queue: ");    
//    for(i=0; i < 10; i++) {
//      try {
//        ch = iQ.get();
//        System.out.print(ch);
//      } catch (Exception e) {
//      }
//    }    
// 
//    System.out.println(); 
// 
//    // Put more characters into circular queue.    
//    for(i=10; i < 22; i++)    
//      iQ.put((char) ('A' + i));    
// 
//    // Show the queue. 
//    System.out.print("Contents of circular queue: ");    
//    for(i=0; i < 12; i++) {     
//      try {
//        ch = iQ.get();
//        System.out.print(ch);
//      } catch (Exception e) {
//      }
//    }
// 
//    System.out.println("\nStore and consume from" + 
//                       " circular queue."); 
// 
//    // Use and consume from circular queue. 
//    for(i=0; i < 20; i++) { 
//      iQ.put((char) ('A' + i));
//      try {
//        ch = iQ.get();
//        System.out.print(ch);
//      } catch (Exception e) {
//      }
//          }
//    System.out.println();
//  }
}
