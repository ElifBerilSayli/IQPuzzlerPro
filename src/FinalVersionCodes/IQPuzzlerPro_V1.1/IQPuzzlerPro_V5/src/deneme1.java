

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.ScrollEvent;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/**
 *
 * @author user
 */

public class deneme1 extends Application {
    
    double orgSceneX, orgSceneY ,orgTranslateX,orgTranslateY= 0 ;
    int scrollCount = 0;
    @Override
    public void start(Stage stage) {
         
        Circle piece1[];
        int circleNumber;
         
        final Group root = new Group();
        
        circleNumber = 5;
        piece1 = new Circle[circleNumber];
  
        piece1[0] = createCircle(50,1150.0f+100,230.0f);
        piece1[1] = createCircle(50,1150.0f+200,230.0f);
        piece1[2] = createCircle(50,1150.0f+300,230.0f);
        piece1[3] = createCircle(50,1150.0f+400,230.0f);
        piece1[4] = createCircle(50,1250.0f,230.0f+100);
        
        
        for ( int i = 0; i < circleNumber; i++ )
            root.getChildren().add(piece1[i]);
        
        final Scene scene = new Scene(root, 1000, 1000, true);
        stage.setScene(scene);
        
        for ( int i = 0; i < circleNumber; i++ )
            handlerMousePressed(piece1[i]);
        
        for ( int i = 0; i < circleNumber; i++ )
            handlerMouseDragged(piece1[i], piece1, circleNumber);
        
        for ( int i = 0; i < circleNumber; i++ )
            handlerMouseScroll(piece1[i], piece1, circleNumber);
        
        stage.show();
    }
    
    public void handlerMousePressed( Circle circle )
    {
        circle.setOnMousePressed((t) -> {
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();
            orgTranslateX = ((Circle)(t.getSource())).getTranslateX();
            orgTranslateY = ((Circle)(t.getSource())).getTranslateY();
            //System.out.println("Algılıyo mu");
    
        });
    }
    public void handlerMouseDragged( Circle circle, Circle[] piece, int circleNumber )
    {
        circle.setOnMouseDragged((t) -> {
            
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;
             
            for ( int i = 0; i < circleNumber; i++ )
            {
                piece[i].setTranslateX(newTranslateX);
                piece[i].setTranslateY(newTranslateY);
            }
         
      });
    }
    
    public void handlerMouseScroll(Circle circle, Circle[] piece, int circleNumber)
    {
        circle.setOnScroll((ScrollEvent event) -> {
           double deltaY = event.getDeltaY();
       
       if (deltaY < 0){
        Rotate rotate = new Rotate(); 
        rotate.setAngle(90); 
        rotate.setPivotX(piece[0].getCenterX()); 
        rotate.setPivotY(piece[0].getCenterY()); 
        
        for ( int i = 0; i < circleNumber; i++ )
            piece[i].getTransforms().addAll(rotate);
       }
       
       if (deltaY > 0){
            scrollCount = scrollCount + 1;
            Scale scale = new Scale();
            scale.setPivotX(piece[0].getCenterX());
            scale.setPivotY(piece[0].getCenterY());
            
            for ( int i = 0; i < circleNumber; i++ )
                piece[i].getTransforms().add(scale);
            
           if(( scrollCount % 2) != 0)
           {
                scale.setY( -1);
            
           } else{
                scale.setY( 1);
           }
       }
      });
    }
    
    public Circle createCircle( double radius, double centerX, double centerY )
    {
        Circle circle1 = new Circle(); 
        circle1.setRadius(radius); 
        circle1.setCenterX(centerX); 
        circle1.setCenterY(centerY); 
        return circle1;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}