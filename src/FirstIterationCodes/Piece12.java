/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ıqpuzzlerpro;

/**
 *
 * @author hande
 */

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


/**
 *
 * @author hande
 */
public class Piece12 extends  Pieces {

    /**
     *
     * @return
     */
    Circle arrayOfCircles[];
    Shape shape3;
    public Shape createPiece() {

        int circleNumberX = 2 ;
        int circleNumberY = 2;
        int circleNumber = circleNumberX + circleNumberY ;
        arrayOfCircles = new Circle[circleNumber] ;
        int radius = 50 ;
        int diameter = radius + radius  ;
        int distance = diameter ;
        //array e ilk atılan sol alt olmalıdır
        //Yan yana cirlelar için SADECE
         for(int i=0;i<circleNumberX;i++)
         {
          arrayOfCircles[i]=createCircle(radius,1550.0f+distance,500.0f);
          distance = distance + diameter;
          System.out.println("x"+i);
         }
         distance = diameter;

          for(int i=circleNumberX;i<circleNumber;i++)
         {
          arrayOfCircles[i]=createCircle(radius,1450.0f+distance,600.0f);
          distance = distance + diameter;
          System.out.println("y"+i);
         }

         shape3 = createUnion(arrayOfCircles);
         shape3.setFill(Color.CHARTREUSE);
         handlerELİF ( shape3, arrayOfCircles );
         return shape3;

    }


     public void detectIntersection( Rectangle rec1, double[][] arx, double[][] ary , int row, int col, boolean[][] arf ){
        handlerZeynepHande ( shape3, arrayOfCircles, rec1, arx, ary, row, col, arf );
    }

}
