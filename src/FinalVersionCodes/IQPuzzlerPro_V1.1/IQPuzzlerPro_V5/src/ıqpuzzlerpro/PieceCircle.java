/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ıqpuzzlerpro;

import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
/**
 *
 * @author zeynep
 */
public class PieceCircle extends Circle 
{
    int id;
    
    public PieceCircle( double radius, double centerX, double centerY, Color color, int id )
    {
        super();
        this.setRadius(radius); 
        this.setCenterX(centerX); 
        this.setCenterY(centerY); 
        this.setFill(color);
        this.id = id;
    }
}