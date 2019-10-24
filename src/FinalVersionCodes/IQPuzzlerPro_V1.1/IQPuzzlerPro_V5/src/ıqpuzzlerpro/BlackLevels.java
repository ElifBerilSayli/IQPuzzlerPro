/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ıqpuzzlerpro;

import java.lang.reflect.Array;
import static java.sql.Types.INTEGER;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */

public class BlackLevels {
    
    double  XCoor[]  =    new double[12];
    double  YCoor[]  =    new double[12];
    boolean flag[]   =    new boolean[12];
    int     rot[]    =    new int[12];
    
    BlackLevels( int id, int boardId)
    {
        if(boardId == 1)
        {
            if(id == 1)
            {
                easyLevel();    //  12. level
            }
            else if(id == 2)
            {
                mediumLevel();  //  5. level
            }
            else if(id == 3)
            {
                hardLevel();    //  13. level
            }
            else if(id == 4)
            {
                challengeLevel();
            }
        }
        if(boardId == 2)
        {
            if(id == 1)
            {
                greyEasy();     //  51. level
            }
            else if(id == 2)
            {
                greyMedium();   //  45. level
            }
            else if(id == 3)
            {
                greyHard();     //  46. level
            }
        }
    }
    
    public void challengeLevel()
    {
       //12. bölüm
       XCoor[0]  =  805;
       XCoor[1]  =  1050;
       XCoor[2]  =  865;
       XCoor[3]  =  40;
       XCoor[4]  =  300;
       XCoor[5]  =  950;
       XCoor[6]  =  700;
       XCoor[7]  =  900;
       XCoor[8]  =  940;
       XCoor[9]  =  450;
       XCoor[10] =  560;
       XCoor[11] =  230;
       
       YCoor[0]  =  230;
       YCoor[1]  =  600;
       YCoor[2]  =  100;
       YCoor[3]  =  500;
       YCoor[4]  =  500;
       YCoor[5]  =  300;
       YCoor[6]  =  500;
       YCoor[7]  =  700;
       YCoor[8]  =  500;
       YCoor[9]  =  600;
       YCoor[10] =  664;
       YCoor[11] =  650;
       
       flag[0] = true;
       flag[1] = true;
       flag[2] = true;
       flag[3] = true;
       flag[4] = true;
       flag[5] = true;
       flag[6] = true;
       flag[7] = true;
       flag[8] = true;
       flag[9] = true;
       flag[10] = true;
       flag[11] = true;    
    }
    
    public void easyLevel()
    {
       //12. bölüm
       XCoor[0] = 805;
       XCoor[1] = 460;
       XCoor[2] = 865;
       XCoor[3] = 40;
       XCoor[4] = 230;
       XCoor[5] = 520;
       XCoor[6] = 340;
       XCoor[7] = 340;
       XCoor[8] = 940;
       XCoor[9] = 280;
       XCoor[10] = 160;
       XCoor[11] = 230;
       
       YCoor[0] = 230;
       YCoor[1] = 164;/////
       YCoor[2] = 100;
       YCoor[3] = 500;
       YCoor[4] = 500;
       YCoor[5] = 284;/////
       YCoor[6] = 164;/////
       YCoor[7] = 344;/////
       YCoor[8] = 500;
       YCoor[9] = 284;/////
       YCoor[10] = 164;/////
       YCoor[11] = 650;
       
       flag[0] = true;
       flag[1] = false;
       flag[2] = true;
       flag[3] = true;
       flag[4] = true;
       flag[5] = false;
       flag[6] = false;
       flag[7] = false;
       flag[8] = true;
       flag[9] = false;
       flag[10] = false;
       flag[11] = true;
    }
    
    public void mediumLevel()
    {
       //5. bölüm
       XCoor[0] = 805;
       XCoor[1] = 805;
       XCoor[2] = 865;
       XCoor[3] = 580;
       XCoor[4] = 700;
       XCoor[5] = 360;
       XCoor[6] = 640;
       XCoor[7] = 740;
       XCoor[8] = 940;
       XCoor[9] = 470;
       XCoor[10] = 280;
       XCoor[11] = 230;
       
       YCoor[0] = 230;
       YCoor[1] = 360;
       YCoor[2] = 100;
       YCoor[3] = 224;
       YCoor[4] = 344;
       YCoor[5] = 500;
       YCoor[6] = 164;
       YCoor[7] = 560;
       YCoor[8] = 500;
       YCoor[9] = 650;
       YCoor[10] = 164;
       YCoor[11] = 650;
       
       flag[0] = true;
       flag[1] = true;
       flag[2] = true;
       flag[3] = false;
       flag[4] = false;
       flag[5] = true;
       flag[6] = false;
       flag[7] = true;
       flag[8] = true;
       flag[9] = true;
       flag[10] = false;
       flag[11] = true;
    }
    
    public void hardLevel()
    {
       //13. bölüm
       XCoor[0] = 805;
       XCoor[1] = 805;
       XCoor[2] = 865;
       XCoor[3] = 40;
       XCoor[4] = 230;
       XCoor[5] = 400;///////
       XCoor[6] = 550;
       XCoor[7] = 740;
       XCoor[8] = 940;
       XCoor[9] = 470;
       XCoor[10] = 580;///////
       XCoor[11] = 230;
       
       YCoor[0] = 230;
       YCoor[1] = 360;
       YCoor[2] = 100;
       YCoor[3] = 500;
       YCoor[4] = 500;
       YCoor[5] = 164;///////
       YCoor[6] = 500;
       YCoor[7] = 560;
       YCoor[8] = 500;
       YCoor[9] = 650;
       YCoor[10] = 164;///////
       YCoor[11] = 650;
       
       flag[0] = true;
       flag[1] = true;
       flag[2] = true;
       flag[3] = true;
       flag[4] = true;
       flag[5] = false;
       flag[6] = true;
       flag[7] = true;
       flag[8] = true;
       flag[9] = true;
       flag[10] = false;
       flag[11] = true;
   }
    
   public void greyEasy()
   {
       //51. bölüm
       XCoor[0] = 805;
       XCoor[1] = 805;
       XCoor[2] = 865;
       XCoor[3] = 625;/////
       XCoor[4] = 243;/////
       XCoor[5] = 400;
       XCoor[6] = 328;/////
       XCoor[7] = 370;/////
       XCoor[8] = 940;
       XCoor[9] = 470;
       XCoor[10] = 455;/////
       XCoor[11] = 230;
       
       YCoor[0] = 230;
       YCoor[1] = 360;
       YCoor[2] = 100;
       YCoor[3] = 405;/////
       YCoor[4] = 278;/////
       YCoor[5] = 764;
       YCoor[6] = 363;/////
       YCoor[7] = 150;/////
       YCoor[8] = 500;
       YCoor[9] = 650;
       YCoor[10] = 404;/////
       YCoor[11] = 650;
       
       flag[0] = true;
       flag[1] = true;
       flag[2] = true;
       flag[3] = false;
       flag[4] = false;
       flag[5] = true;
       flag[6] = false;
       flag[7] = false;
       flag[8] = true;
       flag[9] = true;
       flag[10] = false;
       flag[11] = true;
   }
   
   public void greyMedium()
   {
       //45. bölüm
       XCoor[0] = 805;
       XCoor[1] = 805;
       XCoor[2] = 865;
       XCoor[3] = 40;
       XCoor[4] = 582;///////
       XCoor[5] = 497;///////
       XCoor[6] = 550;
       XCoor[7] = 370;///////
       XCoor[8] = 940;
       XCoor[9] = 470;
       XCoor[10] = 580;
       XCoor[11] = 230;
       
       YCoor[0] = 230;
       YCoor[1] = 360;
       YCoor[2] = 100;
       YCoor[3] = 500;
       YCoor[4] = 278;///////
       YCoor[5] = 192;///////
       YCoor[6] = 500;
       YCoor[7] = 150;///////
       YCoor[8] = 500;
       YCoor[9] = 650;
       YCoor[10] = 664;
       YCoor[11] = 650;
       
       flag[0] = true;
       flag[1] = true;
       flag[2] = true;
       flag[3] = true;
       flag[4] = false;///////
       flag[5] = false;///////
       flag[6] = true;
       flag[7] = false;///////
       flag[8] = true;
       flag[9] = true;
       flag[10] = true;
       flag[11] = true;
   }
   
   public void greyHard()
   {
       //46. bölüm
       XCoor[0] = 805;
       XCoor[1] = 805;
       XCoor[2] = 865;
       XCoor[3] = 40;
       XCoor[4] = 230;
       XCoor[5] = 400;///////
       XCoor[6] = 625;
       XCoor[7] = 740;
       XCoor[8] = 940;
       XCoor[9] = 413;
       XCoor[10] = 550;///////
       XCoor[11] = 230;
       
       YCoor[0] = 230;
       YCoor[1] = 360;
       YCoor[2] = 100;
       YCoor[3] = 500;
       YCoor[4] = 500;
       YCoor[5] = 164;///////
       YCoor[6] = 404;
       YCoor[7] = 560;
       YCoor[8] = 500;
       YCoor[9] = 361;
       YCoor[10] = 500;///////
       YCoor[11] = 650;
       
       flag[0] = true;
       flag[1] = true;
       flag[2] = true;
       flag[3] = true;
       flag[4] = true;
       flag[5] = true;
       flag[6] = false;
       flag[7] = true;
       flag[8] = true;
       flag[9] = false;
       flag[10] = true;
       flag[11] = true;
   }
}