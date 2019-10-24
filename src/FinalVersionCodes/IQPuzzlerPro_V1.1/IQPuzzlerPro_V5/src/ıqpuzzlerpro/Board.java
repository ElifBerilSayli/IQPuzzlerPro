package ıqpuzzlerpro;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Board class
 * @author zeynep
 */
public class Board{
    
    int id;
    // BLACK BOARD VARIABLES
    int bRowNum;
    int bColNum;
    int bRecWidth;
    double bRecCent;
   
    Rectangle bRecArray[][];
    double bCenterArrayX[][];
    double bCenterArrayY[][];
    
    boolean bFullArray[][];
    
    
    //Point2D centerArray[][];
    //Point2D closestCenterPoint;
    
    // GREY BOARD VARIABLES
    int gRecNum;
    int gRowNum;
    int gColNum;
    int gRecWidth;
    double gRecCent;
    
    Rectangle gRecArray[][];
    double gCenterArrayX[][];
    double gCenterArrayY[][];
    
    boolean gFullArray[][];
    
    
    // CONSTRUCTOR
    public Board( int idO)
    {
        if(idO == 1)
        {
            this.id = idO;
            bRowNum     = 5;
            bColNum     = 11;
            bRecWidth   = 60;
            bRecCent    = bRecWidth / 2;

            bRecArray = new Rectangle[bRowNum][bColNum]; 
            bCenterArrayX = new double[bRowNum][bColNum];
            bCenterArrayY = new double[bRowNum][bColNum];
            bFullArray = new boolean[bRowNum][bColNum];

            double x = 30.0;
            double y = 30.0;
            for (int row = 0; row < bRowNum; row++) 
            {
                for (int col = 0; col < bColNum; col++) 
                {
                    Rectangle rec = new Rectangle();
                    bRecArray[row][col] = rec;
                    bFullArray[row][col] = false;
                    bCenterArrayX[row][col] = x + 130;
                    bCenterArrayY[row][col] = y + 134;
                    x = x + 60.0;
                }
                x = 30.0;
                y = y + 60.0;
            }
        }
        else if(idO == 2)
        {
            this.id = idO;
            bRowNum     = 5;
            bColNum     = 11;
            bRecWidth   = 60;
            bRecCent    = bRecWidth / 2;
            
            gCenterArrayX = new double[9][9];
            gCenterArrayY = new double[9][9];
            gRecArray = new Rectangle[9][11]; 
            gFullArray = new boolean [9][11];
        }
    }
    
    public int getBoardId()
    {
        return id;
    }
    
    public int getRowNo()
    {
        return bRowNum;
    }
    
    public int getColNo()
    {
        return bColNum;
    }
    
    public int getRecWidth()
    {
        return bRecWidth;
    }
    
    public double getCenter()
    {
        return bRecCent;
    }
    
    public Rectangle getRectangle(int row, int col)
    {
        return bRecArray[row][col];
    }
     public Rectangle getgRectangle(int row, int col)
    {
        return gRecArray[row][col];
    }
    
    public Rectangle[][] getRecArray()
    {
        return bRecArray;
    }
    public Rectangle[][] getgRecArray()
    {
        return gRecArray;
    }
    public double[][] getbCenterArrayX()
    {
        return bCenterArrayX;
    }
    
    public double[][] getbCenterArrayY()
    {
        return bCenterArrayY;
    }
    
    public double[][] getgCenterArrayX()
    {
        return gCenterArrayX;
    }
    
    public double[][] getgCenterArrayY()
    {
        return gCenterArrayY;
    }
    
    public boolean[][] getFullArray()
    {
        return bFullArray;
    }
    
    
}