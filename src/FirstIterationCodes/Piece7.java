/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author giray-kezer
 */

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import menufirstiteration.Pieces;

/**
 *
 * @author hande
 */
public class Piece7 extends  Pieces {
    
    /**
     *
     * @return
     */
    Circle arrayOfCircles[];
    Shape shape3;
    public Shape createPiece() {
        
        int circleNumberX = 3 ;
        int circleNumberY = 2;
        int circleNumber = circleNumberX + circleNumberY ;
        Circle arrayOfCircles[] = new Circle[circleNumber] ;
        int radius = 50 ;
        int diameter = radius + radius  ;
        int distance = diameter ;
        //array e ilk atılan sol alt olmalıdır
        //Yan yana cirlelar için SADECE
         for(int i=0;i<circleNumberX;i++)
         { 
          arrayOfCircles[i]=createCircle(radius,175.0f+distance,200.0f);
          distance = distance + diameter; 
          System.out.println("x"+i);
         }
         distance = diameter;

          for(int i=circleNumberX;i<circleNumber;i++)
         {
          arrayOfCircles[i]=createCircle(radius,175.0f+distance,300.0f);
          distance = distance + diameter;
          System.out.println("y"+i);
         }

         Shape shape3 = createUnion(arrayOfCircles);
         shape3.setFill(Color.GREEN);
         handlerELİF ( shape3, arrayOfCircles );
         return shape3;
     
    }
    
    
    public void detectIntersection( Rectangle rec1 ){
        handlerZeynepHande ( shape3, arrayOfCircles, rec1 );
        
    }
    

    
}