/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yenilik;

/**
 *
 * @author user
 */


import javafx.geometry.Bounds;
import javafx.geometry.Point3D;
import javafx.scene.Cursor;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

/**
 *
 * @author elif
 */
public class PİECE3D  {
       private double mouseX, mouseY , mouseZ= 0;
       private int count = 0;
       Group blue = null;
       Group pink = null;
       boolean  bol = false;
        boolean  bool = false;
       Bounds boundBlue , boundPink = null;
       double parameterXB , parameterYB , parameterZB = 0;
        double parameterXP , parameterYP , parameterZP = 0;
    public Group createUnion(Color color , int sphereNumX, int xCoordinate, int sphereNumY, int yCoordinate, int sphereNumZ, int zCoordinate, int addingX, int axCoordinate, int ayCoordinate,  int startPointX )
    {
         Group union = new Group();
         int radius = 30 ;
         int diameter = radius + radius ;
         int distanceZ  = zCoordinate;
         int distanceX = xCoordinate;
         int distanceY = yCoordinate;
         int distance =0;
         for(int i = 0 ; i < sphereNumZ  ;i++)
         {
            final Sphere box = new Sphere(radius);
            box.setMaterial(new PhongMaterial(color));
            box.setTranslateZ(distanceZ);
            distanceZ = distanceZ + diameter ;
            union.getChildren().add(box);
        
         }
         distanceZ = 0;
         for(int i = 0 ; i < sphereNumX  ;i++)
         {
            final Sphere box = new Sphere(radius);
            box.setMaterial(new PhongMaterial(color));
            box.setTranslateX(distanceX);
            distanceX = distanceX + diameter ;
            union.getChildren().add(box);
         }
        
        distanceX = 0;
        for(int i = 0 ; i < sphereNumY  ;i++)
        {
            final Sphere box = new Sphere(radius);
            box.setMaterial(new PhongMaterial(color));
            box.setTranslateY(distance);
            box.setTranslateX(distanceY);
            union.getChildren().add(box);
            distance = distance + diameter ;
            
        }
        distance=0;
        for(int i = 0 ; i < addingX  ;i++)
        {
            final Sphere box = new Sphere(radius);
            box.setMaterial(new PhongMaterial(color));
            box.setTranslateY(ayCoordinate+diameter);
            box.setTranslateX(axCoordinate+diameter);
            union.getChildren().add(box);
            ayCoordinate = ayCoordinate + diameter ;
            
        }
           
        return union;
    }
         
         
         
         
    
     public void handlerELİF (Color color ,Group union , Box floor, Rectangle rectangle)
     {
        floor.setDepthTest(DepthTest.DISABLE);
         union.setOnMousePressed(t -> {
       union.setOnDragDetected((MouseEvent event)-> {
        union.setMouseTransparent(true);
        floor.setMouseTransparent(false);
        union.setCursor(Cursor.MOVE);
        union.startFullDrag();
    });
    union.setOnMouseReleased((MouseEvent event)-> {
        union.setMouseTransparent(false);
        floor.setMouseTransparent(true);
        union.setCursor(Cursor.DEFAULT); 
        
       mouseX =event.getSceneX();
       mouseY =event.getSceneY();
       mouseZ = Math.hypot(mouseX, mouseY);
       Bounds boundsInScene = union.localToScene(union.getBoundsInLocal());
       
   
        bool = false;
        if(color == Color.PURPLE)
           {
             boundBlue = boundsInScene ;

             bool = intersect( boundPink , boundBlue );
             blue = union;
             if(bool == true && pink != null && bol == false ){
             translationAndUnify( union ,  pink , boundPink , boundBlue );
             bol = true ;
             }
           }
          if(color == Color.ORANGE)
          {
           boundPink = boundsInScene ;
           pink = union;
           bool = intersect( boundPink , boundBlue  );
           if(bool == true && blue != null && bol == false){
           translationAndUnify( union ,  blue , boundPink , boundBlue );
           bol = true;
           }}
        
        
    });  
     floor.setOnMouseDragOver((MouseDragEvent event)-> {
        Point3D coords = event.getPickResult().getIntersectedPoint();
        coords = floor.localToParent(coords);
       union.setTranslateX(coords.getX());
      // System.out.println("coords.getX()" + Math.abs(coords.getX()));
        union.setTranslateY(coords.getY());
        union.setTranslateZ(coords.getZ());

    });

        union.setOnScroll((ScrollEvent event) -> {
            
            double deltaY = event.getDeltaY();
            if(deltaY > 0)
            {
                if(count <= 2)
                {
                 Translate translate = new Translate();
                 union.getTransforms().add(new Rotate(45 , Rotate.X_AXIS));
                 union.getTransforms().add(translate);
                 count++ ;
                }else if (count <= 4)
                {
                  Translate translate = new Translate();
                 union.getTransforms().add(new Rotate(45 , Rotate.Z_AXIS));
                 union.getTransforms().add(translate);
                 count++ ;
                }else if (count <= 6)
                {
                  Translate translate = new Translate();
                 union.getTransforms().add(new Rotate(45 , Rotate.Y_AXIS));
                 union.getTransforms().add(translate);
                 count=0;
                
                }
                
            }
            if (deltaY < 0){
           union.setRotate((union.getRotate()) + 90);
       }
    
        });
   });
  
     }
     
     public boolean intersect(Bounds boundPink ,Bounds boundBlue  )
     {     if(boundPink != null && boundBlue != null ){
            parameterXB = (  boundBlue.getMaxX() );
            parameterYB = (  boundBlue.getMaxY() );
            parameterZB = (boundBlue.getMaxZ() );

            parameterXP = ( boundPink.getMaxX()  );
            parameterYP = ( boundPink.getMaxY() );
            parameterZP = ( boundPink.getMaxZ() );

            //Z EKLEEE KAMERA OLUNCA
            if((Math.abs(parameterXP - parameterXB) <= 60) )
            {
             System.out.println("İNTERSECTTT " + Math.abs(parameterXB - parameterXP));
              return true;

            }
            }
     return false;
     }
     public void translationAndUnify(Group union , Group pink , Bounds boundPink , Bounds boundBlue )
      {
      union.setTranslateX(0) ;
      pink.setTranslateX(0) ;
      union.setTranslateY(0) ;
      pink.setTranslateY(0) ;
      union.setTranslateZ(0) ;
      pink.setTranslateZ(0) ;
      union.getChildren().add( pink);
      union.setTranslateX(0);
      union.setTranslateY(0);
      union.setTranslateZ(0);
      }
     
     
}
