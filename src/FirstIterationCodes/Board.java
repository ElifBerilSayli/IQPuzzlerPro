package ıqpuzzlerpro;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Board class
 * @author hande
 */
public class Board extends GridPane {

    int id;
    Rectangle recArray[][];
    double centerArrayX[][];
    double centerArrayY[][];
    boolean fullArray[][];

    public Board( int idO ){

        // if id = 1, contruct first board
        if ( idO == 1 ){
            id = 1;
        }

    }

    public GridPane selectBoard()  {

        int rowNum = 5;
        int colNum = 11;
        recArray = new Rectangle[rowNum][colNum];
        centerArrayX = new double[rowNum][colNum];
        centerArrayY = new double[rowNum][colNum];
        fullArray = new boolean[rowNum][colNum];

        double x = 50.0;
        double y = 50.0;
        GridPane board1 = new GridPane();
            for (int row = 0; row < rowNum; row++) {
              for (int col = 0; col < colNum; col++) {
                  Rectangle rec = new Rectangle();
                  rec.setWidth(100);
                  rec.setHeight(100);
                  rec.setFill(Color.GRAY);
                  rec.setStroke(Color.BLACK);
                  GridPane.setRowIndex(rec, row);
                  GridPane.setColumnIndex(rec, col);
                  board1.getChildren().addAll(rec);
                  recArray[row][col] = rec;
                  centerArrayX[row][col] = x;
                  centerArrayY[row][col] = y;
                  fullArray[row][col] = false;
                  x = x + 100.0;
              }
              x = 50.0;
              y = y + 100.0;
            }

         return board1;
    }
}
