/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yenilik;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Cursor;
import javafx.scene.DepthTest;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 *
 * @author elif
 */

public class ONE3D extends PİECE3D  {
    //Bir eksiği kadar ilerliyor
 
    public Group olay(Box floor, Rectangle rectangle ) {
      Group union = createUnion(Color.PINK,2,0,2,0,1,0,0,0,0,1);
      handlerELİF( Color.PINK , union ,  floor, rectangle);
      union.setDepthTest(DepthTest.DISABLE);
      return union ;
    }
 
    public Group olay2(Box floor, Rectangle rectangle  ) {
     Group union = createUnion(Color.BLUE,3,0,3,0,1,0,0,0,0,1);
    handlerELİF(Color.BLUE, union ,  floor, rectangle);
    union.setDepthTest(DepthTest.DISABLE);
    return union ;
    }
    
     public Group olay3(Box floor, Rectangle rectangle  ) {
     Group union = createUnion(Color.YELLOW,4,0,2,60,1,0,0,0,0,1);
     handlerELİF( Color.YELLOW ,union ,  floor, rectangle);
     union.setDepthTest(DepthTest.DISABLE);
     return union ;
    }
     
     public Group olay4(Box floor, Rectangle rectangle  ) {
     Group union = createUnion(Color.RED,3,0,2,120,1,0,1,120,0,1);
     handlerELİF(Color.RED, union ,  floor, rectangle);
     union.setDepthTest(DepthTest.DISABLE);
     return union ;
    }
    
     public Group olay5(Box floor, Rectangle rectangle  ) {
     Group union = createUnion(Color.GREEN,3,0,2,60,1,0,1,60,0,1);
     handlerELİF(Color.GREEN, union ,  floor, rectangle);
     union.setDepthTest(DepthTest.DISABLE);
     return union ;
    }
     
    public Group olay6(Box floor, Rectangle rectangle  ) {
     Group union = createUnion(Color.ORANGE,3,0,2,0,1,0,1,60,0,1);
     handlerELİF(Color.ORANGE ,union ,  floor, rectangle);
     union.setDepthTest(DepthTest.DISABLE);
     return union ;
    }
    
    public Group olay7(Box floor, Rectangle rectangle  ) {
     Group union = createUnion(Color.SNOW,3,0,2,60,1,0,2,60,-120,1);
     handlerELİF(Color.SNOW, union ,  floor, rectangle);
     union.setDepthTest(DepthTest.DISABLE);
     return union ;
    }
    
    public Group olay8(Box floor, Rectangle rectangle  ) {
     Group union = createUnion(Color.VIOLET,4,0,2,0,1,0,0,0,0,1);
     handlerELİF(Color.VIOLET, union ,  floor, rectangle);
     union.setDepthTest(DepthTest.DISABLE);
     return union ;
    }
    
    public Group olay9(Box floor, Rectangle rectangle  ) {
     Group union = createUnion(Color.PAPAYAWHIP,2,0,2,0,1,0,1,0,-120,1);
     handlerELİF(Color.PAPAYAWHIP, union ,  floor, rectangle);
     union.setDepthTest(DepthTest.DISABLE); 
     return union ;
    }
    
    public Group olay10(Box floor, Rectangle rectangle  ) {
     Group union = createUnion(Color.PURPLE,3,0,2,0,1,0,0,0,0,1);
     handlerELİF(Color.PURPLE, union ,  floor, rectangle);
     union.setDepthTest(DepthTest.DISABLE); 
     return union ;
    }
    
     public Group olay11(Box floor, Rectangle rectangle  ) {
     Group union = createUnion(Color.ROYALBLUE,3,0,2,60,1,0,0,0,0,1);
     handlerELİF( Color.ROYALBLUE ,union ,  floor, rectangle);
     union.setDepthTest(DepthTest.DISABLE);
      return union ;
    }
}

