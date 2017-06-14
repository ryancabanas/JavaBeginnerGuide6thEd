/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter16.problem18;

// Demonstrate a simple JList. 
// This program requires JDK 7 or later.
  
import javax.swing.*;  
import java.awt.*;
import java.util.List;
   
class ListDemo {  
  
  JList<String> jlst; 
  JLabel jlab; 
  JScrollPane jscrlp; 
 
  // Create an array of names. 
  String names[] = { "Sherry", "Jon", "Rachel",  
                     "Sasha", "Josselyn",  "Randy", 
                     "Tom", "Mary", "Ken", 
                     "Andrew", "Matt", "Todd" }; 
 
  ListDemo() {  
    // Create a new JFrame container.  
    JFrame jfrm = new JFrame("JList Demo");  
 
    // Specify a flow Layout. 
    jfrm.setLayout(new FlowLayout());  
 
    // Give the frame an initial size.  
    jfrm.setSize(400, 175);  
  
    // Terminate the program when the user closes the application.  
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  
    // Create a JList. 
    jlst = new JList<>(names); 
 
    // Set the list selection mode to single-selection. 
    jlst.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
 
    // Add list to a scroll pane. 
    jscrlp = new JScrollPane(jlst); 
 
    // Set the preferred size of the scroll pane. 
    jscrlp.setPreferredSize(new Dimension(120, 90)); 
 
    // Make a label that displays the selection. 
    jlab = new JLabel("Please choose a name"); 
 
    // Add list selection handler and its logic.
    jlst.addListSelectionListener((e) -> {
      // Get the index of the changed item. 
//      int idx = jlst.getSelectedIndex(); 
      List<String> selectionList = jlst.getSelectedValuesList();
      String[] selectionArray = selectionList.toArray(new String[0]);

      // Display selection, if item was selected. 
      if(selectionArray.length > 0) 
        jlab.setText("Current selection(s): " + String.join(", ", selectionArray)); 
      else // Othewise, reprompt. 
        jlab.setText("Please choose an name"); 
    }); 
 
    // Add the list and label to the content pane. 
    jfrm.add(jscrlp); 
    jfrm.add(jlab); 
  
    // Display the frame.  
    jfrm.setVisible(true);  
  }  
 
  public static void main(String args[]) {  
    // Create the frame on the event dispatching thread.  
    SwingUtilities.invokeLater(() -> {
      new ListDemo();  
    });   
  }  
}