/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter17.problem13;

import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


/*
     Try This 16-1 modified

     A JavaFX-based file comparison utility.

     Requires JDK 7 or later.
*/

public class JavaFXFileCompare extends Application {

  TextField tfFirst;  // holds the first file name
  TextField tfSecond; // holds the second file name

  Button btnComp; // button to compare the files

  Label labFirst, labSecond; // displays prompts
  Label labResult; // displays results and error messages

  public static void main(String[] args) { 
 
    // Start the JavaFX application by calling launch(). 
    launch(args);   
  }
  
  @Override
  public void start(Stage myStage) {
    
    // Give the stage a title. 
    myStage.setTitle("Compare Files"); 

    // Use a FlowPane for the root node. In this case, 
    // vertical and horizontal gaps of 10. 
    FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);
 
    // Center the controls in the scene. 
    rootNode.setAlignment(Pos.CENTER); 
 
    // Create a scene. 
    Scene myScene = new Scene(rootNode, 200, 200);
 
    // Set the scene on the stage. 
    myStage.setScene(myScene);
    
    //Instantiate controls
    labFirst = new Label("First file:");
    labSecond = new Label("Second file:");
    tfFirst = new TextField();
    tfSecond = new TextField();
    btnComp = new Button("Compare");
    labResult = new Label();
    
    //Fire the "Compare" button when hitting "Enter" while in a TextField.
    tfFirst.setOnAction((a) -> btnComp.fire());
    tfSecond.setOnAction((a) -> btnComp.fire());
    
    //Add button event handler
    btnComp.setOnAction((a) -> {
      int i=0, j=0;

      // First, confirm that both file names have
      // been entered.
      if(tfFirst.getText().equals("")) {
        labResult.setText("First file name missing.");
        return;
      }
      if(tfSecond.getText().equals("")) {
        labResult.setText("Second file name missing.");
        return;
      }

      // Compare files. Use try-with-resources to manage the files.
      try (FileInputStream f1 = new FileInputStream(tfFirst.getText());
           FileInputStream f2 = new FileInputStream(tfSecond.getText()))
      {
        // Check the contents of each file.
        do {
          i = f1.read();
          j = f2.read();
          if(i != j) break;
        } while(i != -1 && j != -1);

        if(i != j)
          labResult.setText("Files are not the same.");
        else
          labResult.setText("Files compare equal.");
      } catch(IOException exc) {
        labResult.setText("File Error");
      }
    });
    
    // Add the label and buttons to the scene graph. 
    rootNode.getChildren().addAll(labFirst, tfFirst, labSecond, tfSecond, btnComp, labResult);
 
    // Show the stage and its scene. 
    myStage.show(); 
  }
}