package ıqpuzzlerpro;
import javafx.geometry.Point2D;
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
    boolean deneme = false;
   
    public void handlerMousePressed( Circle circle )
    {
        circle.setOnMousePressed((t) -> {
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();
            orgTranslateX = ((Circle)(t.getSource())).getTranslateX();
            orgTranslateY = ((Circle)(t.getSource())).getTranslateY();
        });
    }
    public void handlerMouseDragged( Circle circle, Circle[] piece, int circleNumber )
    {
        circle.setOnMouseDragged((t) -> {
            double[] centerArrayX = new double[circleNumber];
            double[] centerArrayY = new double[circleNumber];
            
            for ( int i = 0; i < circleNumber; i++ )
            {
                   centerArrayX[i] = piece[i].getCenterX() - circle.getCenterX(); 
                   centerArrayY[i] = piece[i].getCenterY() - circle.getCenterY();
            }
             
            for ( int i = 0; i < circleNumber; i++ )
            {
                   piece[i].setCenterX(t.getSceneX() + centerArrayX[i] );
                   piece[i].setCenterY(t.getSceneY() + centerArrayY[i] ); 
            }
      });
    }
    
    public void handlerMouseScroll(Circle circle, Circle[] piece, int circleNumber)
    {
        circle.setOnScroll((ScrollEvent event) -> {
            double deltaY = event.getDeltaY();

            double centerX = piece[0].getCenterX();
            double centerY = piece[0].getCenterY();
            
            double cos90 = Math.cos(Math.toRadians(90.0));
            double sin90 = Math.sin(Math.toRadians(90.0));
            double cos180 = Math.cos(Math.toRadians(180.0));
            double sin180 = Math.sin(Math.toRadians(180.0));

            if (deltaY < 0)
            {
                scrollCount = scrollCount + 1;

                for ( int i = 1; i < circleNumber; i++ )
                {
                    double xnew = centerX + ( piece[i].getCenterX() - centerX )* cos90 - ( piece[i].getCenterY() - centerY )* sin90 ;
                    double ynew = centerY + ( piece[i].getCenterY() - centerY )* cos90 + ( piece[i].getCenterX() - centerX )* sin90;
                    piece[i].setCenterX(xnew);
                    piece[i].setCenterY(ynew);
                }
            }

            if (deltaY > 0)
            {
                if(( scrollCount % 2) != 0)
                {
                    for ( int i = 1; i < circleNumber; i++ )
                    {
                       double ynew = centerY + ( piece[i].getCenterY() - centerY )* cos180 + ( piece[i].getCenterX() - centerX )* sin180;
                       piece[i].setCenterY(ynew);
                    }
                } else
                {
                    for ( int i = 1; i < circleNumber; i++ )
                    {
                       double xnew = centerX + ( piece[i].getCenterX() - centerX )* cos180 - ( piece[i].getCenterY() - centerY )* sin180;
                       piece[i].setCenterX(xnew);
                    }
                }
            }
        });
    }
    
    public void handlerCollusion ( Circle[] pi1, Circle c1, Board b1, int rowB, int colB, int circleNumber )
    {
        if(b1.getBoardId() == 1)
        {
            Rectangle rec1 = b1.getRectangle( rowB, colB ); 
            Shape shape1 = rec1;
            Shape shape2 = c1;
            Shape intersect = Shape.intersect(shape1, shape2);

            if (intersect.getBoundsInLocal().getWidth() != -1) {
                collisionDetected = true;
            }
            else{
                collisionDetected = false;
            }

            if (collisionDetected) 
            {
                Point2D p1 = new Point2D(c1.getCenterX(), c1.getCenterY());
                double minDistance = Double.MAX_VALUE;
                double minX = 0;
                double minY = 0;

                for (int row = 0; row < 5; row++) 
                {
                    for (int col = 0; col < 11; col++) 
                    {
                        Point2D p2 = new Point2D( b1.bCenterArrayX[row][col], b1.bCenterArrayY[row][col]);
                        double dis = p1.distance( p2 );
                        if ( dis <= minDistance )
                        {
                            minDistance = dis;
                            minX = b1.bCenterArrayX[row][col];
                            minY = b1.bCenterArrayY[row][col];
                        }
                    }
                }
                
                double[] centerArrayX = new double[circleNumber];
                double[] centerArrayY = new double[circleNumber];

                for ( int i = 0; i < circleNumber; i++ )
                {
                    centerArrayX[i] = pi1[i].getCenterX() - c1.getCenterX(); 
                    centerArrayY[i] = pi1[i].getCenterY() - c1.getCenterY();
                }
                for ( int i = 0; i < circleNumber; i++ )
                {
                    pi1[i].setCenterX(minX + centerArrayX[i] );
                    pi1[i].setCenterY(minY + centerArrayY[i] );
                }
            }
        }
        else if (b1.getBoardId() == 2)
        {
            if( 50 <= c1.getCenterX() && c1.getCenterX() <= 780 &&
                100<= c1.getCenterY() && c1.getCenterY() <= 500)
            {
                rowB = 9;
                colB = 9;

                Point2D p1 = new Point2D(c1.getCenterX(), c1.getCenterY());
                double minDistance = Double.MAX_VALUE;
                double minX = 0;
                double minY = 0;

                for (int row = 0; row < 9; row++) 
                {
                    for (int col = 0; col < 9; col++) 
                    {
                        Point2D p2 = new Point2D( b1.gCenterArrayX[row][col], b1.gCenterArrayY[row][col]);
                        double dis = p1.distance( p2 );
                        if ( dis <= minDistance )
                        {
                            minDistance = dis;
                            minX = b1.gCenterArrayX[row][col];
                            minY = b1.gCenterArrayY[row][col];
                        }
                    }
                }

                double[] centerArrayX = new double[circleNumber];
                double[] centerArrayY = new double[circleNumber];

                for ( int i = 0; i < circleNumber; i++ )
                {
                    centerArrayX[i] = pi1[i].getCenterX() - c1.getCenterX(); 
                    centerArrayY[i] = pi1[i].getCenterY() - c1.getCenterY();
                }

                for ( int i = 0; i < circleNumber; i++ )
                {
                    pi1[i].setCenterX(minX + centerArrayX[i] );
                    pi1[i].setCenterY(minY + centerArrayY[i] );
                }
            }
        }
    }
}