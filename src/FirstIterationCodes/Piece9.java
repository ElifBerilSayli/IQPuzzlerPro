package ıqpuzzlerpro;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


/**
 *
 * @author Dervis
 */
public class Piece9 extends  Pieces {
    
    Circle arrayOfCircles[];
    Shape shape3;
    public Shape createPiece() {
        
        int circleNumberX = 2;
        int circleNumberY = 1;
        int subCircleNo = circleNumberX + circleNumberY;
        int circleNumber = circleNumberX + circleNumberY + 2;
        arrayOfCircles = new Circle[circleNumber] ;
        int radius = 50 ;
        int diameter = radius + radius  ;
        int distance = diameter ;
        //array e ilk atılan sol alt olmalıdır
        //Yan yana cirlelar için SADECE
        for(int i = 0; i < circleNumberX; i++)
        { 
            arrayOfCircles[i]=createCircle(radius,350.0f + distance,350.0f);
            distance = distance + diameter; 
            System.out.println("x"+i);
        }
        distance = diameter;

        for(int i=circleNumberX; i < subCircleNo; i++)
        {
            arrayOfCircles[i]=createCircle(radius, 550.0f, 350.0f - distance);
            distance = distance + diameter ;
            System.out.println("y"+i);
        }
          
        distance = diameter;
          
        for(int i = subCircleNo; i < circleNumber; i++)
        { 
            arrayOfCircles[i]=createCircle(radius,550.0f + distance, 250.0f);
            distance = distance + diameter; 
            System.out.println("x"+i);
        }
          
        shape3 = createUnion(arrayOfCircles);
        shape3.setFill(Color.PURPLE);
        //handlerELİF ( shape3, arrayOfCircles );
        return shape3;
    }
    public void detectIntersection( Rectangle rec1, double[][] arx, double[][] ary, int row, int col, boolean[][] arf  ){
        //handlerZeynepHande ( shape3, arrayOfCircles, rec1, arx, ary, row, col, arf ); 
    }
}