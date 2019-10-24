import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 *
 * @author user
 */

public class class3d extends Application {
    
    private double mouseOldX, mouseOldY = 0;
    private Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
    private Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
    private Rotate rotateZ = new Rotate(0, Rotate.Z_AXIS);
    private Rotate rotateX2 = new Rotate(0, Rotate.X_AXIS);
    private Rotate rotateY2 = new Rotate(0, Rotate.Y_AXIS);
    private Rotate rotateZ2 = new Rotate(0, Rotate.Z_AXIS);
    @Override
    public void start(Stage stage) {
        final PerspectiveCamera cam = new PerspectiveCamera();
        cam.setFieldOfView(20);
        cam.setFarClip(10000);
        cam.setNearClip(0.01);
        cam.getTransforms().addAll(new Rotate(60,Rotate.X_AXIS),new Translate(-200,-200,300));
        final Group root = new Group();
        final Group union = new Group();
        //Floor
         final Box floor = new Box(500, 850, 1);
         floor.setTranslateX(200);
         floor.setTranslateY(200);
         floor.setTranslateZ(50);
         floor.setMaterial(new PhongMaterial(Color.YELLOW));
         root.getChildren().add(floor);
        
         final Sphere box = new Sphere(50);
         box.setMaterial(new PhongMaterial(Color.RED));
         final Sphere box3 = new Sphere(50);
         box3.setMaterial(new PhongMaterial(Color.AQUA));
         box3.setTranslateY(100);
         final Sphere box2 = new Sphere(50);
         box2.setTranslateX(100);
         box2.setMaterial(new PhongMaterial(Color.PINK));
         union.getChildren().addAll(box,box2,box3);
      root.getChildren().add(union);
          final Scene scene = new Scene(root, 1000, 1000, true);
         union.setOnDragDetected((MouseEvent event)-> {
        union.setMouseTransparent(true);
          
       // rectangle.setMouseTransparent(false);
        union.setCursor(Cursor.MOVE);
        union.startFullDrag();   
    });
    union.setOnMouseReleased((MouseEvent event)-> {
        union.setMouseTransparent(false);
        //rectangle.setMouseTransparent(true);
        union.setCursor(Cursor.DEFAULT); 
    });  
          
          
    // While D&D, only confined to the rectangle
      floor.setOnMouseDragOver((MouseDragEvent event)-> {
        Point3D coords = event.getPickResult().getIntersectedPoint();
       // System.out.println(coords.getX());
        coords = floor.localToParent(coords);
       union.setTranslateX(Math.abs(coords.getX()));
       System.out.println("coords.getX()" + Math.abs(coords.getX()));
        union.setTranslateY(Math.abs(  coords.getY()) );
       // g.setTranslateZ(Math.abs( coords.getZ()));
       
    });
     //ROTATİNG ***
        rotateX.setPivotX(100);
        rotateX.setPivotY(100);
        rotateX.setPivotZ(100);
        rotateY.setPivotX(100);
        rotateY.setPivotY(100);
        rotateY.setPivotZ(100);
        rotateZ.setPivotX(100);
        rotateZ.setPivotY(100);
        rotateZ.setPivotZ(100);
        /*
       Group subRoot = new Group();
       SubScene subScene = new SubScene(subRoot, 500, 850 , true, SceneAntialiasing.BALANCED);
       subRoot.getChildren().add(union);
       Camera camera = new PerspectiveCamera(false);
       camera.getTransforms().addAll (rotateX, rotateY,rotateZ, new Translate(0,0,0));
       camera.setRotate(240);  
       subScene.setCamera(camera);
       root.getChildren().addAll(subScene);
        */
       
       union.setOnMousePressed(event -> {
            mouseOldX = event.getSceneX();
            mouseOldY = event.getSceneY();
           // mouseOldZ =  Math.hypot(mouseOldX, mouseOldY);
        });
 
        union.setOnScroll((ScrollEvent event) -> {
            double deltaY = event.getDeltaY();
            if(deltaY > 0)
            {
                rotateX.setAngle(rotateX.getAngle() - (event.getSceneY() ));
                rotateY.setAngle(rotateY.getAngle() + (event.getSceneX() ));
                mouseOldX = event.getSceneX();
                mouseOldY = event.getSceneY();
               
            }
        });
         
       
        
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