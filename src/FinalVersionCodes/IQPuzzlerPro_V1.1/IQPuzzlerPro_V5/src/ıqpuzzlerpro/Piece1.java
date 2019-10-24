package ıqpuzzlerpro;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author elif
 */
public class Piece1 extends  Pieces {
   
    public Circle createCircle( double radius, double centerX, double centerY, Color color, int id )
    {
        PieceCircle circle1 = new PieceCircle( radius, centerX, centerY, color, id ); 
        return circle1;
    }
    
    public PieceCircle[] createPiece( int id, int boardId, double xCoor, double yCoor, boolean flag ) {
        PieceCircle piece1[] = null;
        int circleNumber;
        
        // piece1
        if ( id == 1 )
        {
            circleNumber = 5;
            piece1 = new PieceCircle[circleNumber];
            
            piece1[0] = new PieceCircle(30,xCoor+60,  yCoor, Color.RED, 1);
            piece1[1] = new PieceCircle(30,xCoor+120, yCoor, Color.RED, 1);
            piece1[2] = new PieceCircle(30,xCoor+180, yCoor, Color.RED, 1);
            piece1[3] = new PieceCircle(30,xCoor+240, yCoor, Color.RED, 1);
            piece1[4] = new PieceCircle(30,xCoor + 60,     yCoor+60, Color.RED, 1);

            if(boardId == 2)
            {
                double cos135 = Math.cos(Math.toRadians(135.0));
                double sin135 = Math.sin(Math.toRadians(135.0));

                for ( int i = 1; i < circleNumber; i++ )
                {
                    double xnew = piece1[0].getCenterX() + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* cos135 - ( piece1[i].getCenterY() - piece1[0].getCenterY() )* sin135 ;
                    double ynew = piece1[0].getCenterY()  + ( piece1[i].getCenterY() - piece1[0].getCenterY() )* cos135 + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* sin135;
                    piece1[i].setCenterX(xnew);
                    piece1[i].setCenterY(ynew);
                }
            }
            if(flag)
            {
                for ( int i = 0; i < circleNumber; i++ )
                    handlerMousePressed(piece1[i]);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseDragged(piece1[i], piece1, circleNumber);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseScroll(piece1[i], piece1, circleNumber);
            
            }
        }
        // piece2
        if( id == 2 )
        {
                circleNumber = 4;
                piece1 = new PieceCircle[circleNumber];

                piece1[0] = new PieceCircle(30,xCoor+60,  yCoor, Color.BLUE, 2);
                piece1[1] = new PieceCircle(30,xCoor+120, yCoor, Color.BLUE, 2);
                piece1[2] = new PieceCircle(30,xCoor+180, yCoor, Color.BLUE, 2);
                piece1[3] = new PieceCircle(30,xCoor +60, yCoor + 60, Color.BLUE, 2);
                
                if(boardId == 2)
                {
                    double cos135 = Math.cos(Math.toRadians(135.0));
                    double sin135 = Math.sin(Math.toRadians(135.0));

                    for ( int i = 1; i < circleNumber; i++ )
                    {
                        double xnew = piece1[0].getCenterX() + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* cos135 - ( piece1[i].getCenterY() - piece1[0].getCenterY() )* sin135 ;
                        double ynew = piece1[0].getCenterY()  + ( piece1[i].getCenterY() - piece1[0].getCenterY() )* cos135 + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* sin135;
                        piece1[i].setCenterX(xnew);
                        piece1[i].setCenterY(ynew);
                    }
                }
                
                if(flag)
                {
                    for ( int i = 0; i < circleNumber; i++ )
                        handlerMousePressed(piece1[i]);

                    for ( int i = 0; i < circleNumber; i++ )
                        handlerMouseDragged(piece1[i], piece1, circleNumber);

                    for ( int i = 0; i < circleNumber; i++ )
                        handlerMouseScroll(piece1[i], piece1, circleNumber);
                }
        }
        //piece3
        if( id == 3 )
        {
            circleNumber = 5;
            piece1 = new PieceCircle[circleNumber];
            
            piece1[0] = new PieceCircle(30, xCoor,        yCoor, Color.YELLOW, 3);
            piece1[1] = new PieceCircle(30, xCoor + 60,   yCoor, Color.YELLOW, 3);
            piece1[2] = new PieceCircle(30, xCoor + 120,  yCoor, Color.YELLOW, 3);
            piece1[3] = new PieceCircle(30, xCoor + 180,  yCoor, Color.YELLOW, 3);
            piece1[4] = new PieceCircle(30, xCoor + 120,  yCoor + 60, Color.YELLOW, 3);
            
            if(boardId == 2)
            {
                double cos135 = Math.cos(Math.toRadians(135.0));
                double sin135 = Math.sin(Math.toRadians(135.0));

                for ( int i = 1; i < circleNumber; i++ )
                {
                    double xnew = piece1[0].getCenterX() + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* cos135 - ( piece1[i].getCenterY() - piece1[0].getCenterY() )* sin135 ;
                    double ynew = piece1[0].getCenterY()  + ( piece1[i].getCenterY() - piece1[0].getCenterY() )* cos135 + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* sin135;
                    piece1[i].setCenterX(xnew);
                    piece1[i].setCenterY(ynew);
                }
            }
            
            if(flag)
            {
                for ( int i = 0; i < circleNumber; i++ )
                        handlerMousePressed(piece1[i]);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseDragged(piece1[i], piece1, circleNumber);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseScroll(piece1[i], piece1, circleNumber);
            }
        }
       
        // piece4
        if ( id == 4 )
        {
            circleNumber = 5;
            piece1 = new PieceCircle[circleNumber];
            
            piece1[0] = new PieceCircle(30, xCoor,          yCoor, Color.CADETBLUE, 4);
            piece1[1] = new PieceCircle(30, xCoor + 60,     yCoor, Color.CADETBLUE, 4);
            piece1[2] = new PieceCircle(30, xCoor + 120,    yCoor, Color.CADETBLUE, 4);
            piece1[3] = new PieceCircle(30, xCoor,          yCoor + 60, Color.CADETBLUE, 4);
            piece1[4] = new PieceCircle(30, xCoor + 120,    yCoor + 60, Color.CADETBLUE, 4);
            
            if(boardId == 2)
            {
                double cos135 = Math.cos(Math.toRadians(135.0));
                double sin135 = Math.sin(Math.toRadians(135.0));

                for ( int i = 1; i < circleNumber; i++ )
                {
                    double xnew = piece1[0].getCenterX() + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* cos135 - ( piece1[i].getCenterY() - piece1[0].getCenterY() )* sin135 ;
                    double ynew = piece1[0].getCenterY()  + ( piece1[i].getCenterY() - piece1[0].getCenterY() )* cos135 + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* sin135;
                    piece1[i].setCenterX(xnew);
                    piece1[i].setCenterY(ynew);
                }
            }
            
            if(flag)
            {
                for ( int i = 0; i < circleNumber; i++ )
                        handlerMousePressed(piece1[i]);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseDragged(piece1[i], piece1, circleNumber);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseScroll(piece1[i], piece1, circleNumber);
            }
        }
        
        // piece5
        if ( id == 5 )
        {
            circleNumber = 3;
            piece1 = new PieceCircle[circleNumber];
            
            piece1[0] = new PieceCircle(30, xCoor,          yCoor, Color.PINK, 5);
            piece1[1] = new PieceCircle(30, xCoor + 60,     yCoor, Color.PINK, 5);
            piece1[2] = new PieceCircle(30, xCoor + 60,     yCoor + 60, Color.PINK, 5);
            
            if(boardId == 2)
            {
                double cos135 = Math.cos(Math.toRadians(135.0));
                double sin135 = Math.sin(Math.toRadians(135.0));

                for ( int i = 1; i < circleNumber; i++ )
                {
                    double xnew = piece1[0].getCenterX() + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* cos135 - ( piece1[i].getCenterY() - piece1[0].getCenterY() )* sin135 ;
                    double ynew = piece1[0].getCenterY()  + ( piece1[i].getCenterY() - piece1[0].getCenterY() )* cos135 + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* sin135;
                    piece1[i].setCenterX(xnew);
                    piece1[i].setCenterY(ynew);
                }
            }
            
            if(flag)
            {
                for ( int i = 0; i < circleNumber; i++ )
                        handlerMousePressed(piece1[i]);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseDragged(piece1[i], piece1, circleNumber);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseScroll(piece1[i], piece1, circleNumber);
            }  
        }
        
        // piece6
        if ( id == 6 )
        {
            circleNumber = 4;
            piece1 = new PieceCircle[circleNumber];
            
            piece1[0] = new PieceCircle(30, xCoor,          yCoor, Color.CYAN, 6);
            piece1[1] = new PieceCircle(30, xCoor+60,       yCoor, Color.CYAN, 6);
            piece1[2] = new PieceCircle(30, xCoor+120,      yCoor, Color.CYAN, 6);
            piece1[3] = new PieceCircle(30, xCoor+60,       yCoor+60, Color.CYAN, 6);
            
            if(boardId == 2)
            {
                double cos135 = Math.cos(Math.toRadians(135.0));
                double sin135 = Math.sin(Math.toRadians(135.0));

                for ( int i = 1; i < circleNumber; i++ )
                {
                    double xnew = piece1[0].getCenterX() + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* cos135 - ( piece1[i].getCenterY() - piece1[0].getCenterY() )* sin135 ;
                    double ynew = piece1[0].getCenterY()  + ( piece1[i].getCenterY() - piece1[0].getCenterY() )* cos135 + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* sin135;
                    piece1[i].setCenterX(xnew);
                    piece1[i].setCenterY(ynew);
                }
            }
            
            if(flag)
            {
                for ( int i = 0; i < circleNumber; i++ )
                        handlerMousePressed(piece1[i]);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseDragged(piece1[i], piece1, circleNumber);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseScroll(piece1[i], piece1, circleNumber);
            }
        }
        
        // piece7
        if( id == 7 ) 
        {
            circleNumber = 5;
            piece1 = new PieceCircle[circleNumber];
            
            piece1[0] = new PieceCircle(30, xCoor,     yCoor, Color.MAROON, 7);
            piece1[1] = new PieceCircle(30, xCoor+60,  yCoor, Color.MAROON, 7);
            piece1[2] = new PieceCircle(30, xCoor+120, yCoor, Color.MAROON, 7);
            piece1[3] = new PieceCircle(30, xCoor+120, yCoor+60, Color.MAROON, 7);
            piece1[4] = new PieceCircle(30, xCoor+120, yCoor+120, Color.MAROON, 7);

            if(boardId == 2)
            {
                double cos135 = Math.cos(Math.toRadians(135.0));
                double sin135 = Math.sin(Math.toRadians(135.0));

                for ( int i = 1; i < circleNumber; i++ )
                {
                    double xnew = piece1[0].getCenterX() + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* cos135 - ( piece1[i].getCenterY() - piece1[0].getCenterY() )* sin135 ;
                    double ynew = piece1[0].getCenterY()  + ( piece1[i].getCenterY() - piece1[0].getCenterY() )* cos135 + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* sin135;
                    piece1[i].setCenterX(xnew);
                    piece1[i].setCenterY(ynew);
                }
            }
            
            if(flag)
            {
                for ( int i = 0; i < circleNumber; i++ )
                        handlerMousePressed(piece1[i]);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseDragged(piece1[i], piece1, circleNumber);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseScroll(piece1[i], piece1, circleNumber);
            }
        }
        
        // piece8
        if ( id == 8 )
        {
            circleNumber = 5;
            piece1 = new PieceCircle[circleNumber];
            
            piece1[0] = new PieceCircle(30, xCoor,      yCoor, Color.ORANGERED, 8);
            piece1[1] = new PieceCircle(30, xCoor+60,   yCoor, Color.ORANGERED, 8);
            piece1[2] = new PieceCircle(30, xCoor+120,  yCoor, Color.ORANGERED, 8);
            piece1[3] = new PieceCircle(30, xCoor+60,   yCoor-60, Color.ORANGERED, 8);
            piece1[4] = new PieceCircle(30, xCoor+120,  yCoor+60, Color.ORANGERED, 8);
            
            if(boardId == 2)
            {
                double cos135 = Math.cos(Math.toRadians(135.0));
                double sin135 = Math.sin(Math.toRadians(135.0));

                for ( int i = 1; i < circleNumber; i++ )
                {
                    double xnew = piece1[0].getCenterX() + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* cos135 - ( piece1[i].getCenterY() - piece1[0].getCenterY() )* sin135 ;
                    double ynew = piece1[0].getCenterY()  + ( piece1[i].getCenterY() - piece1[0].getCenterY() )* cos135 + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* sin135;
                    piece1[i].setCenterX(xnew);
                    piece1[i].setCenterY(ynew);
                }
            }
            
            if(flag)
            {
                for ( int i = 0; i < circleNumber; i++ )
                        handlerMousePressed(piece1[i]);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseDragged(piece1[i], piece1, circleNumber);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseScroll(piece1[i], piece1, circleNumber);
            }
        }
        
        // piece9
        if ( id == 9 )
        {
            circleNumber = 5;
            piece1 = new PieceCircle[circleNumber];
            
            piece1[0] = new PieceCircle(30, xCoor,      yCoor, Color.PURPLE, 9);
            piece1[1] = new PieceCircle(30, xCoor+60,   yCoor, Color.PURPLE, 9);
            piece1[2] = new PieceCircle(30, xCoor+60,   yCoor-60, Color.PURPLE, 9);
            piece1[3] = new PieceCircle(30, xCoor+120,  yCoor-60, Color.PURPLE, 9);
            piece1[4] = new PieceCircle(30, xCoor+180,  yCoor-60, Color.PURPLE, 9);
            
            if(boardId == 2)
            {
                double cos135 = Math.cos(Math.toRadians(135.0));
                double sin135 = Math.sin(Math.toRadians(135.0));

                for ( int i = 1; i < circleNumber; i++ )
                {
                    double xnew = piece1[0].getCenterX() + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* cos135 - ( piece1[i].getCenterY() - piece1[0].getCenterY() )* sin135 ;
                    double ynew = piece1[0].getCenterY()  + ( piece1[i].getCenterY() - piece1[0].getCenterY() )* cos135 + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* sin135;
                    piece1[i].setCenterX(xnew);
                    piece1[i].setCenterY(ynew);
                }
            }
            
            if(flag)
            {
                for ( int i = 0; i < circleNumber; i++ )
                        handlerMousePressed(piece1[i]);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseDragged(piece1[i], piece1, circleNumber);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseScroll(piece1[i], piece1, circleNumber);
            }
        }
        
        //piece10
        if( id == 10 )
        {
            circleNumber = 5;
            piece1 = new PieceCircle[circleNumber];
            
            piece1[0] = new PieceCircle(30, xCoor,     yCoor, Color.VIOLET, 10);
            piece1[1] = new PieceCircle(30, xCoor+60,  yCoor, Color.VIOLET, 10);
            piece1[2] = new PieceCircle(30, xCoor,     yCoor+60, Color.VIOLET, 10);
            piece1[3] = new PieceCircle(30, xCoor+60,  yCoor-60, Color.VIOLET, 10);
            piece1[4] = new PieceCircle(30, xCoor+120, yCoor-60, Color.VIOLET, 10);
            
            if(boardId == 2)
            {
                double cos135 = Math.cos(Math.toRadians(135.0));
                double sin135 = Math.sin(Math.toRadians(135.0));

                for ( int i = 1; i < circleNumber; i++ )
                {
                    double xnew = piece1[0].getCenterX() + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* cos135 - ( piece1[i].getCenterY() - piece1[0].getCenterY() )* sin135 ;
                    double ynew = piece1[0].getCenterY()  + ( piece1[i].getCenterY() - piece1[0].getCenterY() )* cos135 + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* sin135;
                    piece1[i].setCenterX(xnew);
                    piece1[i].setCenterY(ynew);
                }
            }
            
            if(flag)
            {
                for ( int i = 0; i < circleNumber; i++ )
                        handlerMousePressed(piece1[i]);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseDragged(piece1[i], piece1, circleNumber);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseScroll(piece1[i], piece1, circleNumber);
            }
        }
        
        // piece11
        if ( id == 11 )
        {
            circleNumber = 5;
            piece1 = new PieceCircle[circleNumber];
            
            piece1[0] = new PieceCircle(30, xCoor,     yCoor, Color.GREEN, 11);
            piece1[1] = new PieceCircle(30, xCoor+60,  yCoor, Color.GREEN, 11);
            piece1[2] = new PieceCircle(30, xCoor+120, yCoor, Color.GREEN, 11);
            piece1[3] = new PieceCircle(30, xCoor+60,  yCoor+60, Color.GREEN, 11);
            piece1[4] = new PieceCircle(30, xCoor+120, yCoor+60, Color.GREEN, 11);
            
            if(boardId == 2)
            {
                double cos135 = Math.cos(Math.toRadians(135.0));
                double sin135 = Math.sin(Math.toRadians(135.0));

                for ( int i = 1; i < circleNumber; i++ )
                {
                    double xnew = piece1[0].getCenterX() + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* cos135 - ( piece1[i].getCenterY() - piece1[0].getCenterY() )* sin135 ;
                    double ynew = piece1[0].getCenterY()  + ( piece1[i].getCenterY() - piece1[0].getCenterY() )* cos135 + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* sin135;
                    piece1[i].setCenterX(xnew);
                    piece1[i].setCenterY(ynew);
                }
            }
            
            if(flag)
            {
                for ( int i = 0; i < circleNumber; i++ )
                        handlerMousePressed(piece1[i]);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseDragged(piece1[i], piece1, circleNumber);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseScroll(piece1[i], piece1, circleNumber);
            }
        }
        
        // piece12
        if( id == 12 )
        {
            circleNumber = 4;
            piece1 = new PieceCircle[circleNumber];
            
            piece1[0] = new PieceCircle(30, xCoor,      yCoor, Color.CHARTREUSE, 12);
            piece1[1] = new PieceCircle(30, xCoor+60,   yCoor, Color.CHARTREUSE, 12);
            piece1[2] = new PieceCircle(30, xCoor+60,   yCoor+60, Color.CHARTREUSE, 12);
            piece1[3] = new PieceCircle(30, xCoor+120,  yCoor+60, Color.CHARTREUSE, 12);
            
            if(boardId == 2)
            {
                double cos135 = Math.cos(Math.toRadians(135.0));
                double sin135 = Math.sin(Math.toRadians(135.0));

                for ( int i = 1; i < circleNumber; i++ )
                {
                    double xnew = piece1[0].getCenterX() + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* cos135 - ( piece1[i].getCenterY() - piece1[0].getCenterY() )* sin135 ;
                    double ynew = piece1[0].getCenterY()  + ( piece1[i].getCenterY() - piece1[0].getCenterY() )* cos135 + ( piece1[i].getCenterX() - piece1[0].getCenterX()  )* sin135;
                    piece1[i].setCenterX(xnew);
                    piece1[i].setCenterY(ynew);
                }
            }
            
            if(flag)
            {
                for ( int i = 0; i < circleNumber; i++ )
                        handlerMousePressed(piece1[i]);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseDragged(piece1[i], piece1, circleNumber);

                for ( int i = 0; i < circleNumber; i++ )
                    handlerMouseScroll(piece1[i], piece1, circleNumber);
            }
        }
        return piece1;
    }
    
    public void detectIntersection( Circle[] p1, Circle c1, Board b1, int row, int col, int circleNum  ){
        handlerCollusion( p1, c1, b1, row, col , circleNum  ); 
    }
}