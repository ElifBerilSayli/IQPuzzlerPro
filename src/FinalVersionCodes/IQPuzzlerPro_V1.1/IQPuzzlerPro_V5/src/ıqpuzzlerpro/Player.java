/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ıqpuzzlerpro;

/**
 *
 * @author zeynep
 */
public class Player {
    
    String name;
    int id;
    int score;
    int blackBoardCount;
    int grayBoardCount;
    
    public Player( String name, int id )
    {
        this.name = name;
        this.id = id;
        score = 0;
        
        blackBoardCount = 1;
        grayBoardCount = 1;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getId()
    {
        return id;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void setScore( int num )
    {
        score = num;
    }
    
    public int getBlackBoardCount()
    {
        return blackBoardCount;
    }
    
    public void setgetBlackBoardCount(  )
    {
        blackBoardCount++;
    }
    
    public int getGrayBoardCount()
    {
        return grayBoardCount;
    }
    
    public void setGrayBoardCount(  )
    {
        grayBoardCount++;
    }
}