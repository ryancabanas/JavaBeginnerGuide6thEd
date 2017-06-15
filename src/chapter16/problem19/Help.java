/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter16.problem19;

import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;


class Help {
  JFrame jframeFrame;
  JList<String> jlistTopics;
  JLabel jlabelTopicText;
  static final String[] arrayTopics;
  static final HashMap<String, String> hashTopicText;
  
  static {
    arrayTopics = new String[] {"if", "switch", "for", "while", "do-while", "break", "continue"};
    
    hashTopicText = new HashMap<>();
    
    hashTopicText.put("if", "<html>The if:"
            + "<br>if(condition) statement;"
            + "<br>else statement;</html>");
    
    hashTopicText.put("switch", "<html>The switch:"
            + "<br>switch(expression) {"
            + "<br>  case constant:"
            + "<br>    statement sequence"
            + "<br>    break;"
            + "<br>  // ..."
            + "<br>}</html>");
    
    hashTopicText.put("for", "<html>The for:"
            + "<br>for(init; condition; iteration)"
            + "<br> statement;</html>");

    hashTopicText.put("while", "<html>The while:"
            + "<br>hile(condition) statement;</html>");

    hashTopicText.put("do-while", "<html>The do-while:"
            + "<br>do {"
            + "<br>  statement;"
            + "<br>} while (condition);</html>");
    
    hashTopicText.put("break", "<html>The break:"
            + "<br>break; or break label;</html>");
    
    hashTopicText.put("continue", "<html>The continue:"
            + "<br>continue; or continue label;</html>");
  }
  
  Help()  {
    jframeFrame = new JFrame("Help Demo");
    jframeFrame.setVisible(true);
    jframeFrame.setSize(500, 200);
    jframeFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
    jframeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    jlabelTopicText = new JLabel("Choose one, or more, help topics.");
    
    jlistTopics = new JList<>(arrayTopics);
    jlistTopics.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    jlistTopics.addListSelectionListener((e) -> {
      StringBuilder topicText = new StringBuilder();

      List<String> selectionList = jlistTopics.getSelectedValuesList();
      String[] selectionArray = selectionList.toArray(new String[0]);

      if(selectionArray.length > 0) {
        for (int i = 0; i < selectionArray.length; i++) {
          String topicKey = selectionArray[i];
          String topicValue = hashTopicText.get(topicKey);
          if (i > 0) {
            topicText.append("<br><br>");
          }
          topicText.append(topicValue);
        }
        jlabelTopicText.setText(topicText.toString());
      } else {
        jlabelTopicText.setText("Choose one, or more, help topics.");         
      }
    });
    
    jframeFrame.add(jlistTopics);
    jframeFrame.add(jlabelTopicText);
  }
  
  public static void main(String args[]) {
    SwingUtilities.invokeLater(() -> new Help());
  }
}