/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter17.problem15;

// Demonstrate rotation, scaling, reflection, and bluring. 
  
import java.io.FileInputStream;
import javafx.application.*;  
import static javafx.application.Application.launch;
import javafx.scene.*;  
import javafx.stage.*;  
import javafx.scene.layout.*;  
import javafx.scene.control.*;  
import javafx.event.*;  
import javafx.geometry.*;  
import javafx.scene.transform.*; 
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
  
public class EffectsAndTransformsDemo extends Application {  
  
  double angle = 0.0; 
  double scaleFactor = 0.4; 
  double blurVal = 1.0;
  int translatePosition = 0;
  
 
  // Create initial effects and transforms. 
  Reflection reflection = new Reflection(); 
  BoxBlur blur = new BoxBlur(1.0, 1.0, 1); 
  BoxBlur blur2 = new BoxBlur(5.0, 5.0, 2);
  Rotate rotate = new Rotate(); 
  Scale scale = new Scale(scaleFactor, scaleFactor);
  Glow glow = new Glow(0.0);
  Translate translate = new Translate(0.0, 0.0);
  
  Image image;
  ImageView imageView;
 
  // Create push buttons.  
  Button btnRotate = new Button("Rotate");  
  Button btnBlur = new Button("Blur off"); 
  Button btnScale = new Button("Scale");
  Button btnGlow = new Button("Glow");
  Button btnTranslate = new Button("Translate");
 
  Label reflect = new Label("Reflection Adds Visual Sparkle"); 
 
  public static void main(String[] args) {  
  
    // Start the JavaFX application by calling launch().  
    launch(args);    
  }  
  
  // Override the start() method.  
  @Override
  public void start(Stage myStage) {  
  
    // Give the stage a title.  
    myStage.setTitle("Effects and Transforms Demo");  
  
    // Use a FlowPane for the root node. In this case,  
    // vertical and horizontal gaps of 20 are used. 
    FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 20, 20);  
  
    // Center the controls in the scene.  
    rootNode.setAlignment(Pos.CENTER);  
  
    // Create a scene.  
    Scene myScene = new Scene(rootNode, 265, 500);  
  
    // Set the scene on the stage.  
    myStage.setScene(myScene);
 
    //Create image
    try {
      image = new Image(new FileInputStream("C:/Users/Ryan/Pictures/Personal/me.jpg"));
    } catch (Exception e) {
    }
      
    imageView = new ImageView(image);
    imageView.setFitWidth(200);
    imageView.setPreserveRatio(true);
    
    // Add rotation to the transform list for the Rotate button. 
    btnRotate.getTransforms().add(rotate);
 
    // Add scaling to the transform list for the Scale button. 
    btnScale.getTransforms().add(scale);
    
    // Add translation
    btnTranslate.getTransforms().add(translate);
 
    // Set the reflection effect on the reflection label. 
    reflection.setTopOpacity(0.7); 
    reflection.setBottomOpacity(0.3); 
    reflect.setEffect(reflection); 
 
    // Handle the action events for the Rotate button.  
    btnRotate.setOnAction((ActionEvent ae) -> {
      // Each time button is pressed, it is rotated 30 degrees
      // around its center.
      angle -= 15.0;
      
      rotate.setAngle(angle);
      rotate.setPivotX(btnRotate.getWidth()/2);
      rotate.setPivotY(btnRotate.getHeight()/2);
      
      if (angle % 360 == 0) {
        btnRotate.setEffect(null);
      } else {
        btnRotate.setEffect(blur2);
      }
    });  
  
    // Handle the action events for the Scale button.  
    btnScale.setOnAction((ActionEvent ae) -> {
      // Each time button is pressed, the button's scale is changed.
      scaleFactor += 0.1;
      if(scaleFactor > 2.0) scaleFactor = 0.4;
      
      scale.setX(scaleFactor);
      scale.setY(scaleFactor);  
    });  
 
    // Handle the action events for the Blur button. 
    btnBlur.setOnAction((ActionEvent ae) -> {
      // Each time button is pressed, its blur status is changed.
      if(blurVal == 10.0) {
        blurVal = 1.0;
        btnBlur.setEffect(null);
        btnBlur.setText("Blur off");
      } else {
        blurVal++;
        btnBlur.setEffect(blur);
        btnBlur.setText("Blur on");
      }
      blur.setWidth(blurVal);
      blur.setHeight(blurVal);  
    });  
 
    // Handle glow button
    btnGlow.setOnAction((ae) -> {
      if (glow.getLevel() == 0.0) {
        glow.setLevel(1.0);
      } else {
        glow.setLevel(0.0);
      }
      imageView.setEffect(glow);
    });
    
    // Handle the translate button
    btnTranslate.setOnAction((ae) -> {
      switch (translatePosition) {
        case 0: case 1:
          translate.setX(translate.getX() + 5.0);
          translatePosition++;
          break;
        case 2: case 3:
          translate.setY(translate.getY() + 5.0);
          translatePosition++;
          break;
        case 4: case 5:
          translate.setX(translate.getX() - 5.0);
          translatePosition++;
          break;
        case 6: case 7:
          translate.setY(translate.getY() - 5.0);
          translatePosition++;
          break;
        default:
          throw new AssertionError();
      }
      
      if (translatePosition == 8) {
        translatePosition = 0;
      }

      System.out.println(translate.getX() + "," + translate.getY());
    });
    
    // Add the label and buttons to the scene graph.  
    rootNode.getChildren().addAll(
            imageView, btnRotate, btnScale, btnBlur, btnGlow, btnTranslate, reflect
    );  
 
    // Show the stage and its scene.  
    myStage.show();  
  }  
}