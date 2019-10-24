package ıqpuzzlerpro;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


/**
 *
 * @author elif
 */
public class Pieces  {
  
    int scrollCount = 0;
    boolean collisionDetected = false;
    double orgSceneX, orgSceneY ,orgTranslateX,orgTranslateY= 0 ;
    
    public Circle createCircle(double radius ,double centerX,double centerY  )
    {
    Circle circle1 = new Circle(); 
    circle1.setRadius(radius); 
    circle1.setCenterX(centerX); 
    circle1.setCenterY(centerY); 
    return circle1;
    }
    
    public Shape createUnion(Circle[] arrayofcircles)
    {
     Shape shape2 =null;
     Shape shape = Shape.union(arrayofcircles[0], arrayofcircles[1]);
    for(int i=0;i<= arrayofcircles.length-1;i++)
    {
       shape2 = Shape.union(shape, arrayofcircles[i]);
       shape = shape2;
    }
    return shape2;
    }
   
    public void handlerELİF (Shape shape3,Circle[] arrayofcircles ){
        shape3.setOnMousePressed((t) -> {
        orgSceneX = t.getSceneX();
        orgSceneY = t.getSceneY();
        orgTranslateX = ((Shape)(t.getSource())).getTranslateX();
        orgTranslateY = ((Shape)(t.getSource())).getTranslateY();
    
    });
        
     shape3.setOnMouseDragged((t) -> {
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;
             
            ((Shape)(t.getSource())).setTranslateX(newTranslateX);
            ((Shape)(t.getSource())).setTranslateY(newTranslateY);
         
      });
     
      shape3.setOnScroll((ScrollEvent event) -> {
       double deltaY = event.getDeltaY();
       
       if (deltaY < 0){
           shape3.setRotate((shape3.getRotate()) + 90);
       }
       
       if (deltaY > 0){
           scrollCount = scrollCount + 1;
           if(( scrollCount % 2) != 0)
           {
               shape3.setScaleY(-1);
           }else{
                shape3.setScaleY(1);
           }
       }
      });
      
    }
    
    public void handlerZeynepHande (Shape shape3, Circle[] arrayofcircles, Rectangle rec1, 
                                    double[][] arx, double[][] ary, int rowA, int colA, boolean[][] arf ){
        
         
        ArrayList<Shape> nodes;
        nodes = new ArrayList<>();
        nodes.addAll(Arrays.asList(arrayofcircles));
        nodes.add(rec1);
         for (Shape static_bloc : nodes) {
         if (static_bloc != shape3) {
           Shape intersect = Shape.intersect(shape3, rec1);
           if (intersect.getBoundsInLocal().getWidth() != -1) {
             collisionDetected = true;
             arf[rowA][colA] = true;
           }
           else{
               collisionDetected = false;
               arf[rowA][colA] = false;
           }
         }
       }
       
       if (collisionDetected) {
             shape3.setOnMouseReleased((MouseEvent t) -> {
                 
                 Point2D p1 = new Point2D(t.getSceneX(), t.getSceneY());
                 double minDistance = Double.MAX_VALUE;
                 double minX = 0;
                 double minY = 0;
                 for (int row = 0; row < 5; row++) {
                     for (int col = 0; col < 11; col++) {
                         Point2D p2 = new Point2D( arx[row][col], ary[row][col]);
                         double dis = p1.distance( p2 );
                         if ( dis <= minDistance )
                         {
                             minDistance = dis;
                             minX = arx[row][col];
                             minY = ary[row][col];
                         }
                         
                     }
                 }
                 double offsetX = minX - orgSceneX;
                 double offsetY = minY - orgSceneY;
                 double newTranslateX = orgTranslateX + offsetX;
                 double newTranslateY = orgTranslateY + offsetY;
                 
                 ((Shape)(t.getSource())).setTranslateX(newTranslateX);
                 ((Shape)(t.getSource())).setTranslateY(newTranslateY);
             });
    }
   
   }    
    
   
}
