package ıqpuzzlerpro;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


/**
 *
 * @author elif
 */
public class Piece1 extends  Pieces {
    
    Circle arrayOfCircles[];
    Shape shape3;
    public Shape createPiece() {
        
        int circleNumberX = 4 ;
        int circleNumberY = 1;
        int circleNumber = circleNumberX + circleNumberY ;
        arrayOfCircles = new Circle[circleNumber] ;
        int radius = 50 ;
        int diameter = radius + radius  ;
        int distance = diameter ;
       
         for(int i=0;i<circleNumberX;i++)
         { 
          arrayOfCircles[i]=createCircle(radius,1150.0f+distance,230.0f);
          distance = distance + diameter; 
         }
         distance = diameter;

          for(int i=circleNumberX;i<circleNumber;i++)
         {
          arrayOfCircles[i]=createCircle(radius,1250.0f,230.0f+distance);
          distance = distance + diameter ;
         }

         shape3 = createUnion(arrayOfCircles);
         shape3.setFill(Color.RED);
         handlerELİF ( shape3, arrayOfCircles );
         return shape3;
     
    }
    
    public void detectIntersection( Rectangle rec1, double[][] arx, double[][] ary, int row, int col, boolean[][] arf ){
        handlerZeynepHande ( shape3, arrayOfCircles, rec1, arx, ary, row, col, arf  ); 
    }

}