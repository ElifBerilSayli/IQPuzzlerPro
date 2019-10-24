/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ıqpuzzlerpro;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class BoardViewerPanel extends GridPane
{
    Board board;
    //GridPane board1;
    Rectangle[][] bRecArray;
    Rectangle[][] gRecArray;
    
    double[][] bCenterArrayX;
    double[][] bCenterArrayY;
    double[][] gCenterArrayX;
    double[][] gCenterArrayY;
    
    int rowNum;
    int colNum;
    int recWidth;
    double recCent;
    
    public BoardViewerPanel(Board newBoard)
    {
        board = newBoard;
        rowNum = board.getRowNo();
        colNum = board.getColNo();
        recWidth= board.getRecWidth();
        bRecArray  = board.getRecArray();
        gRecArray = board.getgRecArray();
    }
    
    public GridPane createBoard()
    {
        if((board.getBoardId()) == 1)
        {
         //board1 = new GridPane();
            //  BLACK BOARD CREATION
            
            bCenterArrayX = new double[rowNum][colNum];
            bCenterArrayY = new double[rowNum][colNum];

            int counter = 0;
            for (int row = 0; row < rowNum; row++) 
            {
                for (int col = 0; col < colNum; col++) 
                {
                    Rectangle rec = board.getRectangle(row, col);
                    //Rectangle rec = bRecArray[row][col];
                    rec.setWidth(60);
                    rec.setHeight(60);
                    if ( counter % 2 == 0 )
                        rec.setFill(Color.GRAY);
                    else
                        rec.setFill(Color.DARKGRAY);

                    GridPane.setRowIndex(rec, row);
                    GridPane.setColumnIndex(rec, col);
                    this.getChildren().addAll(rec);
                    
                    counter++;
                }
            }
        }
        else if((board.getBoardId()) == 2)
        {
            // int width = 0, height = 10;
            //GRAY BOARD CREATE LOGIC 
            rowNum = 9;
            double x = 30.0;
            double y = 30.0;
            
            //gRecArray       = new Rectangle[rowNum][colNum];
            gCenterArrayX   = board.getgCenterArrayX();
            gCenterArrayY   = board.getgCenterArrayY();
            
            int[] rowNumbers = new int[]{2,4,1,5,1,7,1,7,1,9,3,7,3,7,5,5,5,4};
            
            int counter = 0;
            for(int row= 0; row<rowNum; row++)
            {
                int countRow = 0;
                
                for(int col=0;col<colNum;  col++)
                {
                    Rectangle rec = new Rectangle(col * 30,row * 30);
                
                    rec.setWidth(60);
                    rec.setHeight(60);
                    if( counter % 2 == 0 )
                        rec.setFill(Color.GRAY);
                    else
                        rec.setFill(Color.DARKGRAY);
                    counter++;
                    rec.rotateProperty();
                    if(col == 0)
                    {
                        GridPane.setMargin(rec, new Insets(0, 0, 0, 0));
                    }
                    
                    GridPane.setRowIndex(rec,row+1);
                    if(col%2 == 0) {
                        GridPane.setColumnIndex(rec, col+1);
                    }
                    if(col%2 == 1) {
                        GridPane.setColumnIndex(rec, col+1);
                    }
                    if(rowNumbers[row*2] < col && countRow < rowNumbers[row*2+1]  ) {
                        this.getChildren().addAll(rec);
                        countRow++;
                        gRecArray[row][col] = rec;
                    }
                    else
                        gRecArray[row][col] = null;
                }//for
            }//for
            setCenters( this);
        }
        return this;
    }
    
    public void setCenters(GridPane p1)
    {
        //double[][] gCenterArrayX= new double[9][9];
        gCenterArrayX[0][0] = -1; gCenterArrayX[0][1] = 90; gCenterArrayX[0][2] = 150; gCenterArrayX[0][3] = 210; gCenterArrayX[0][4] = 270; gCenterArrayX[0][5] = -1; gCenterArrayX[0][6] = -1; gCenterArrayX[0][7] = -1; gCenterArrayX[0][8] = -1;
        gCenterArrayX[1][0] = 30; gCenterArrayX[1][1] = 90; gCenterArrayX[1][2] = 150; gCenterArrayX[1][3] = 210; gCenterArrayX[1][4] = 270; gCenterArrayX[1][5] = -1; gCenterArrayX[1][6] = -1; gCenterArrayX[1][7] = -1; gCenterArrayX[1][8] = -1;
        gCenterArrayX[2][0] = 30; gCenterArrayX[2][1] = 90; gCenterArrayX[2][2] = 150; gCenterArrayX[2][3] = 210; gCenterArrayX[2][4] = 270; gCenterArrayX[2][5] = 330; gCenterArrayX[2][6] = 390; gCenterArrayX[2][7] = -1; gCenterArrayX[2][8] = -1;
        gCenterArrayX[3][0] = 30; gCenterArrayX[3][1] = 90; gCenterArrayX[3][2] = 150; gCenterArrayX[3][3] = 210; gCenterArrayX[3][4] = 270; gCenterArrayX[3][5] = 330; gCenterArrayX[3][6] = 390; gCenterArrayX[3][7] = -1; gCenterArrayX[3][8] = -1;
        gCenterArrayX[4][0] = 30; gCenterArrayX[4][1] = 90; gCenterArrayX[4][2] = 150; gCenterArrayX[4][3] = 210; gCenterArrayX[4][4] = 270; gCenterArrayX[4][5] = 330; gCenterArrayX[4][6] = 390; gCenterArrayX[4][7] = 450; gCenterArrayX[4][8] = 510;
        gCenterArrayX[5][0] = -1; gCenterArrayX[5][1] = -1; gCenterArrayX[5][2] = 150; gCenterArrayX[5][3] = 210; gCenterArrayX[5][4] = 270; gCenterArrayX[5][5] = 330; gCenterArrayX[5][6] = 390; gCenterArrayX[5][7] = 450; gCenterArrayX[5][8] = 510;
        gCenterArrayX[6][0] = -1; gCenterArrayX[6][1] = -1; gCenterArrayX[6][2] = 150; gCenterArrayX[6][3] = 210; gCenterArrayX[6][4] = 270; gCenterArrayX[6][5] = 330; gCenterArrayX[6][6] = 390; gCenterArrayX[6][7] = 450; gCenterArrayX[6][8] = 510;
        gCenterArrayX[7][0] = -1; gCenterArrayX[7][1] = -1; gCenterArrayX[7][2] = -1;  gCenterArrayX[7][3] = -1;  gCenterArrayX[7][4] = 270; gCenterArrayX[7][5] = 330; gCenterArrayX[7][6] = 390; gCenterArrayX[7][7] = 450; gCenterArrayX[7][8] = 510;
        gCenterArrayX[8][0] = -1; gCenterArrayX[8][1] = -1; gCenterArrayX[8][2] = -1;  gCenterArrayX[8][3] = -1;  gCenterArrayX[8][4] = 270; gCenterArrayX[8][5] = 330; gCenterArrayX[8][6] = 390; gCenterArrayX[8][7] = 450; gCenterArrayX[8][8] = -1;
        
        // double[][] gCenterArrayX= new double[9][9];
        gCenterArrayY[0][0] = -1;   gCenterArrayY[0][1] = 30;  gCenterArrayY[0][2] = 30;  gCenterArrayY[0][3] = 30;  gCenterArrayY[0][4] = 30; gCenterArrayY[0][5] = -1; gCenterArrayY[0][6] = -1; gCenterArrayY[0][7] = -1; gCenterArrayY[0][8] = -1;
        gCenterArrayY[1][0] = 90;   gCenterArrayY[1][1] = 90;  gCenterArrayY[1][2] = 90;  gCenterArrayY[1][3] = 90;  gCenterArrayY[1][4] = 90; gCenterArrayY[1][5] = -1; gCenterArrayY[1][6] = -1; gCenterArrayY[1][7] = -1; gCenterArrayY[1][8] = -1;
        gCenterArrayY[2][0] = 150;  gCenterArrayY[2][1] = 150; gCenterArrayY[2][2] = 150; gCenterArrayY[2][3] = 150; gCenterArrayY[2][4] = 150; gCenterArrayY[2][5] = 150; gCenterArrayY[2][6] = 150; gCenterArrayY[2][7] = -1; gCenterArrayY[2][8] = -1;
        gCenterArrayY[3][0] = 210;  gCenterArrayY[3][1] = 210; gCenterArrayY[3][2] = 210; gCenterArrayY[3][3] = 210; gCenterArrayY[3][4] = 210; gCenterArrayY[3][5] = 210; gCenterArrayY[3][6] = 210; gCenterArrayY[3][7] = -1; gCenterArrayY[3][8] = -1;
        gCenterArrayY[4][0] = 270;  gCenterArrayY[4][1] = 270; gCenterArrayY[4][2] = 270; gCenterArrayY[4][3] = 270; gCenterArrayY[4][4] = 270; gCenterArrayY[4][5] = 270; gCenterArrayY[4][6] = 270; gCenterArrayY[4][7] = 270; gCenterArrayY[4][8] = 270;
        gCenterArrayY[5][0] = -1;   gCenterArrayY[5][1] = -1;  gCenterArrayY[5][2] = 330; gCenterArrayY[5][3] = 330; gCenterArrayY[5][4] = 330; gCenterArrayY[5][5] = 330; gCenterArrayY[5][6] = 330; gCenterArrayY[5][7] = 330; gCenterArrayY[5][8] = 330;
        gCenterArrayY[6][0] = -1;   gCenterArrayY[6][1] = -1;  gCenterArrayY[6][2] = 390; gCenterArrayY[6][3] = 390; gCenterArrayY[6][4] = 390; gCenterArrayY[6][5] = 390; gCenterArrayY[6][6] = 390; gCenterArrayY[6][7] = 390; gCenterArrayY[6][8] = 390;
        gCenterArrayY[7][0] = -1;   gCenterArrayY[7][1] = -1;  gCenterArrayY[7][2] = -1;  gCenterArrayY[7][3] = -1;  gCenterArrayY[7][4] = 450; gCenterArrayY[7][5] = 450; gCenterArrayY[7][6] = 450; gCenterArrayY[7][7] = 450; gCenterArrayY[7][8] = 450;
        gCenterArrayY[8][0] = -1;   gCenterArrayY[8][1] = -1;  gCenterArrayY[8][2] = -1;  gCenterArrayY[8][3] = -1;  gCenterArrayY[8][4] = 510; gCenterArrayY[8][5] = 510; gCenterArrayY[8][6] = 510; gCenterArrayY[8][7] = 510; gCenterArrayY[8][8] = -1;
        
        double cos135 = Math.cos(Math.toRadians(135.0));
        double sin135 = Math.sin(Math.toRadians(135.0));
        
        for ( int i = 0; i < 9; i++ ) 
        {
            for ( int j = 0; j < 9; j++ )
            {
                double xnew = 270 + ( gCenterArrayX[i][j] - 270 )* cos135 - ( gCenterArrayY[i][j] - 270 )* sin135 ;
                double ynew = 270 + ( gCenterArrayY[i][j] - 270 )* cos135 + ( gCenterArrayX[i][j] - 270 )* sin135;
                gCenterArrayX[i][j] = xnew + 100;
                gCenterArrayY[i][j] = ynew + 50;
                
                //System.out.println(" X :\t row : " + i + "\tcol :" + j + "\t" + gCenterArrayX[i][j]);
                //System.out.println(" Y :\t row : " + i + "\tcol :" + j + "\t" + gCenterArrayY[i][j] + "\n");
            }
        }
    }
    
    public Board getBoard()
    {
        return board;
    }
    
    public double getBoardWidth()
    {
        return recWidth * colNum;
    }

    public double getBoardHeight()
    {
        return recWidth * rowNum;
    }
    
    //  SET METHODS
    //  SET RECTANGLE WIDTH
    public void setRecWidth(int newWidth)
    {
        for (int row = 0; row < 5; row++) 
        {
            for (int col = 0; col < 11; col++) 
            {
                board.getRectangle(row, col).setWidth(newWidth);
                board.getRectangle(row, col).setHeight(newWidth);
            }
        }
    }
    
    //  SET STROCK COLOR
    public void setBlackBoardStrockColor(Color clr)
    {
        for (int row = 0; row < 5; row++) 
        {
            for (int col = 0; col < 11; col++) 
            {
                board.getRectangle(row, col).setStroke( clr);
            }
        }
    }
    //  SET BOARD COLOR
    public void setBlackBoardColor(Color clr)
    {
        for (int row = 0; row < 5; row++) 
        {
            for (int col = 0; col < 11; col++) 
            {
                board.getRectangle(row, col).setFill( clr);
            }
        }
    }
}