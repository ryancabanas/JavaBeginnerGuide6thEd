/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter16.problem17;

/*
     Try This 16-1

     A Swing-based file comparison utility.

     Requires JDK 7 or later.
*/

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class SwingFC {

  JTextField jtfFirst;  // holds the first file name
  JTextField jtfSecond; // holds the second file name

  JButton jbtnComp; // button to compare the files

  JLabel jlabFirst, jlabSecond; // displays prompts
  JLabel jlabResult; // displays results and error messages
  JLabel jlabMismatch;
  
  JCheckBox jcbShowMismatch;

  SwingFC() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("Compare Files");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(200, 240);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create the text fields for the file names..
    jtfFirst = new JTextField(14);
    jtfSecond = new JTextField(14);

    // Set the action commands for the text fields.
    jtfFirst.setActionCommand("fileA");
    jtfSecond.setActionCommand("fileB");

    // Create the Compare button.
    jbtnComp = new JButton("Compare");
    
    jcbShowMismatch = new JCheckBox("Show position of mismatch");
    jcbShowMismatch.setSelected(true);

    // Add action listener and logic for the Compare button.
    jbtnComp.addActionListener((e) -> {
      int i=0, j=0;
      int mismatchPosition = 0;

      //Reset the initial mismatch label empty for each use.
      jlabMismatch.setText("");
      
      // First, confirm that both file names have
      // been entered.
      if(jtfFirst.getText().equals("")) {
        jlabResult.setText("First file name missing.");
        return;
      }
      if(jtfSecond.getText().equals("")) {
        jlabResult.setText("Second file name missing.");
        return;
      }

      // Compare files. Use try-with-resources to manage the files.
      try (FileInputStream f1 = new FileInputStream(jtfFirst.getText());
           FileInputStream f2 = new FileInputStream(jtfSecond.getText()))
      {
        // Check the contents of each file.
        do {
          i = f1.read();
          j = f2.read();
          mismatchPosition++;
          if(i != j) break;
        } while(i != -1 && j != -1);

        if(i != j) {
          jlabResult.setText("Files are not the same.");
          if (jcbShowMismatch.isSelected()) {
            jlabMismatch.setText("Mismatch at character " + mismatchPosition + ".");
          }
        } else {
          jlabResult.setText("Files compare equal.");
        }
      } catch(IOException exc) {
        jlabResult.setText("File Error");
      }
    });

    // Create the labels.
    jlabFirst = new JLabel("First file: ");
    jlabSecond = new JLabel("Second file: ");
    jlabResult = new JLabel("");
    jlabMismatch = new JLabel("");

    // Add the components to the content pane.
    jfrm.add(jlabFirst);
    jfrm.add(jtfFirst);
    jfrm.add(jlabSecond);
    jfrm.add(jtfSecond);
    jfrm.add(jcbShowMismatch);
    jfrm.add(jbtnComp);
    jfrm.add(jlabResult);
    jfrm.add(jlabMismatch);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String args[]) {
    // Create the frame on the event dispatching thread.
    SwingUtilities.invokeLater(() -> new SwingFC());
  }
}