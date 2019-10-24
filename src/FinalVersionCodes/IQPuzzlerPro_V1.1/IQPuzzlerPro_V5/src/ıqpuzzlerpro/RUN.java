/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yenilik;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class RUN extends Application {
    Scene scene;
    @Override
    public void start(Stage stage) {
         final PerspectiveCamera cam = new PerspectiveCamera();
        cam.setFieldOfView(20);
        cam.setFarClip(10000);
        cam.setNearClip(0.01);
        cam.getTransforms().addAll(new Rotate(60,Rotate.X_AXIS),new Translate(-200,-200,300));
        final Group root = new Group();
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        final Rectangle rectangle = new Rectangle(5000, 10000, Color.RED);
        rectangle.setMouseTransparent(true);
        //rectangle.setDepthTest(DepthTest.DISABLE);
        
        //rectangle.setZ(50);
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Floor
         final Box floor = new Box(500, 850, 1);
         floor.setTranslateX(200);
         floor.setTranslateY(200);
         floor.setTranslateZ(50);
         floor.setMaterial(new PhongMaterial(Color.YELLOW));
         root.getChildren().add(floor);
         //root.getChildren().add(rectangle);
            Group one = new Group();
            Group two = new Group();
            Group three = new Group();
            Group four = new Group();
            Group five = new Group();
            Group six = new Group();
            Group seven = new Group();
            Group eight = new Group();
            Group nine = new Group();
            Group ten = new Group();
            Group eleven = new Group();
            /*Group twelve = new Group();
            */
            
       ONE3D first = new ONE3D( );
        one = first.olay(floor, rectangle);
        two = first.olay2(floor, rectangle);
        three =first.olay3(floor, rectangle);
        four = first.olay4(floor, rectangle);
        five = first.olay5(floor, rectangle);
        six = first.olay6(floor, rectangle);
        seven = first.olay7(floor, rectangle);
        eight =first.olay8(floor, rectangle);
        nine = first.olay9(floor, rectangle);
        ten = first.olay10(floor, rectangle);
        eleven = first.olay11(floor, rectangle);
        /*twelve = first.olay12(floor);*/
       root.getChildren().addAll(one,two,three, four,five, six, seven, eight, nine, ten,eleven);
       scene = new Scene(root, 1000, 1000, true);
       
        scene.setCamera(cam);
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}