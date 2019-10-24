package ıqpuzzlerpro;


import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


/**
 *
 * @author Dervis
 */
public class Piece10 extends  Pieces {
    
    Circle arrayOfCircles[];
    Shape shape3;
    public Shape createPiece() {
        
        int circleNumberX = 2;
        int circleNumberY = 1;
        int circleNumber2X = 2;
        
        int subCircleNo1 = circleNumberX + circleNumberY;
        int circleNumber = circleNumberX + circleNumberY + circleNumber2X;
        
        arrayOfCircles = new Circle[circleNumber] ;
        int radius = 50 ;
        int diameter = radius + radius  ;
        int distance = diameter ;
        
        //array e ilk atılan sol alt olmalıdır
        //Yan yana cirlelar için SADECE
        for(int i=0;i<circleNumberX;i++)
        { 
            arrayOfCircles[i]=createCircle(radius,750.0f + distance,680.0f);
            distance = distance + diameter;
        }
        distance = diameter;

        for(int i=circleNumberX;i<subCircleNo1;i++)
        {
            arrayOfCircles[i]=createCircle(radius,750.0f + distance, 680.0f + distance);
            distance = distance + diameter ;
        }
        distance = diameter;

        for(int i=subCircleNo1;i<circleNumber;i++)
        {
            arrayOfCircles[i]=createCircle(radius,850.0f + distance,580.0f);
            distance = distance + diameter ;
        }
          
        shape3 = createUnion(arrayOfCircles);
        shape3.setFill(Color.VIOLET);
        handlerELİF ( shape3, arrayOfCircles );
        return shape3;
     
    }
    public void detectIntersection( Rectangle rec1, double[][] arx, double[][] ary, int row, int col, boolean[][] arf  ){
        handlerZeynepHande ( shape3, arrayOfCircles, rec1, arx, ary, row, col, arf ); 
    }
}