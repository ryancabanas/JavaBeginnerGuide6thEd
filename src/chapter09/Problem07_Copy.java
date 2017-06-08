/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter09;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author Ryan Cabanas
 */
public class Problem07_Copy {
  
  public static void copyHyphenateFile(String file1, String file2) {
      int next;
    FileInputStream fis = null;
    FileOutputStream fos = null;
    
    try {
      fis = new FileInputStream(file1);
      fos = new FileOutputStream(file2);
      
      do {
        next = fis.read();
        if (next != -1) {
          if (next == ' ') {
            fos.write('-');
          } else {
            fos.write(next);
          }
        }
      } while (next != -1);
      
      System.out.println("File copied.");
    } catch (Exception e) {
      System.out.println(e);
    } finally {
      try {
        if (fis != null) {
          fis.close();
        }        
      } catch (Exception e) {
        System.out.println(e);
      }
      try {
        if (fos != null) {
          fos.close();
        }        
      } catch (Exception e) {
        System.out.println(e);
      }

    }
    
  }
}
