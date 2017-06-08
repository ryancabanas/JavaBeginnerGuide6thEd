/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter09;

import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Ryan Cabanas
 */
public class Problem08_CharacterCopy {
  
public static void copyHyphenateFile(String file1, String file2) {
      int next;
    FileReader fr = null;
    FileWriter fw = null;
    
    try {
      fr = new FileReader(file1);
      fw = new FileWriter(file2);
      
      do {
        next = fr.read();
        if (next != -1) {
          if (next == ' ') {
            fw.write('-');
          } else {
            fw.write(next);
          }
        }
      } while (next != -1);
      
      System.out.println("File copied.");
    } catch (Exception e) {
      System.out.println(e);
    } finally {
      try {
        if (fr != null) {
          fr.close();
        }        
      } catch (Exception e) {
        System.out.println(e);
      }
      try {
        if (fw != null) {
          fw.close();
        }        
      } catch (Exception e) {
        System.out.println(e);
      }

    }
    
  }
}
