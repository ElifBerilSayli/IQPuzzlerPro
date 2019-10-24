/*
 * Main Class
 */

package ıqpuzzlerpro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class IQPuzzlerPro extends Application  {  

    int     boardNo;
    double  orgSceneX = 0, orgSceneY = 0;
    double  orgTranslateX, orgTranslateY;
    int     scrollCount = 0;
    int     newY = 0, newX = 0;
    int     hintTimer;
    int     hintCounter = 1;
    int     moveCount = 0;
    int     score;
    
    //  CHALLENGE
    int     challengeMoveCount  = 7;
    long    challengeTime       = 10;
    
    //  TIME
    long elapsedMillis2;
    long elapsedMillis;
    
    //  PRESSED CIRCLE
    PieceCircle activeCircle = null;
    
    //  ALL CIRCLES
    Circle[][] circleArrays;
    
    //  VIEW
    ImageView imgViewer;
    Image image;
    
    Board board;
    BoardViewerPanel boardViewer;
    
    Scene   scene;
    JPanel  currentJPanel;
    JFrame  frame = new JFrame();
    
    MenuViewer menu;
    static Menu1 mainMenu;
    
    //  DATABASE
    DataManager dataManager;
    
    //  PIECES
    Piece1 piece1;
    Piece1 piece2;
    Piece1 piece3;
    Piece1 piece4;
    Piece1 piece5;
    Piece1 piece6;
    Piece1 piece7;
    Piece1 piece8;
    Piece1 piece9;
    Piece1 piece10;
    Piece1 piece11;
    Piece1 piece12;
    Rectangle rec1;
    
    //  LABELS
    Label timeLabel     = new Label();
    Label moveLabel     = new Label("Move Counter : " + moveCount);
    Label scoreLabel    = new Label();
    Label loserLabel     = new Label(" GAME OVER!!! ");
    
    //  BUTTONS
    Button menuButton   = new Button("Menu");
    Button backButton   = new Button("Back");
    Button exitButton   = new Button("Exit");
    Button hintButton   = new Button("Hint");
    JavaFXButtonEx finishButton;
    
    
    private RadioButton nightMode;
    
    //  VBOXS
    VBox pauseScreen = new VBox(10);
    VBox finishScreen= new VBox(10);
    VBox hintBox     = new VBox();
    VBox blackBGR    = new VBox();
    VBox loserScreen = new VBox(10);
    
    //  BOOLEAN
    boolean menuPressed      = false;
    boolean nightModePressed = false;
    boolean isGameLosed      = false;
    boolean hintPressed      = false;
    boolean flag             = false;
    boolean challengeFlag    = false;
    
    //  SOUND
    static Clip clip;
    static Clip clip2;
    static String filePath;
    
    Stage stage;
    
    Dimension d1;
    
    @Override 
    public void start(Stage primaryStage) throws FileNotFoundException
    {  
        menu = new MenuViewer();
        this.stage = primaryStage;
    }
    
    //  CREATE GAME
    JFXPanel createGame(int modeNo, int boardNo, DataManager dataManager, int playerId, int difficultyNo )
    {
        
        Group root  = new Group();
        scene       = new Scene(root, 1368, 600);
        
        JavaFXPanelEx gamePanel;
        gamePanel   = new JavaFXPanelEx();
        
        d1 = Toolkit.getDefaultToolkit().getScreenSize();
        
        this.boardNo = boardNo;
        board = new Board(boardNo);
        boardViewer = new BoardViewerPanel( board );
        nightMode = new RadioButton( " Night Mode");
        
        piece1 = new Piece1();
        piece2 = new Piece1();
        piece3 = new Piece1();
        piece4 = new Piece1();
        piece5 = new Piece1();
        piece6 = new Piece1();
        piece7 = new Piece1();
        piece8 = new Piece1();
        piece9 = new Piece1();
        piece10 = new Piece1();
        piece11 = new Piece1();
        piece12 = new Piece1();
        
        //  ADDING ELEMENTS INTO ROOT
        root.getChildren().addAll(timeLabel, moveLabel, menuButton, nightMode, hintButton);
        root.getChildren().add( boardViewer.createBoard());
        
        if(board.id == 1)
        {
            root.getChildren().get(5).setLayoutX( 130);
            root.getChildren().get(5).setLayoutY( 134);
        }
        else
        {
            boardViewer.setRotate(135);
            root.getChildren().get(5).setLayoutX( 100);
            root.getChildren().get(5).setLayoutY( 50);
        }
        
        BlackLevels bl = new BlackLevels(difficultyNo, boardNo);
        
        PieceCircle[] piece1Circles = piece1.createPiece(1, board.id, bl.XCoor[0], bl.YCoor[0], bl.flag[0]) ;
        for ( int i = 0; i < 5; i++ )
                root.getChildren().add(piece1Circles[i]);
        
        PieceCircle[] piece2Circles = piece2.createPiece(2,board.id, bl.XCoor[1], bl.YCoor[1], bl.flag[1]) ;
        for ( int i = 0; i < 4; i++ )
                root.getChildren().add(piece2Circles[i]);
        
        PieceCircle[] piece3Circles = piece3.createPiece(3,board.id, bl.XCoor[2], bl.YCoor[2], bl.flag[2]) ;
        for ( int i = 0; i < 5; i++ )
                root.getChildren().add(piece3Circles[i]);
        
        PieceCircle[] piece4Circles = piece4.createPiece(4,board.id, bl.XCoor[3], bl.YCoor[3], bl.flag[3]) ;
        for ( int i = 0; i < 5; i++ )
                root.getChildren().add(piece4Circles[i]);
        
        PieceCircle[] piece5Circles = piece5.createPiece(5,board.id, bl.XCoor[4], bl.YCoor[4], bl.flag[4]) ;
        for ( int i = 0; i < 3; i++ )
                root.getChildren().add(piece5Circles[i]);
        
        PieceCircle[] piece6Circles = piece6.createPiece(6,board.id, bl.XCoor[5], bl.YCoor[5], bl.flag[5]) ;
        for ( int i = 0; i < 4; i++ )
                root.getChildren().add(piece6Circles[i]);
        
        PieceCircle[] piece7Circles = piece7.createPiece(7,board.id, bl.XCoor[6], bl.YCoor[6], bl.flag[6]) ;
        for ( int i = 0; i < 5; i++ )
                root.getChildren().add(piece7Circles[i]);
        
        PieceCircle[] piece8Circles = piece8.createPiece(8,board.id, bl.XCoor[7], bl.YCoor[7], bl.flag[7]) ;
        for ( int i = 0; i < 5; i++ )
                root.getChildren().add(piece8Circles[i]);
        
        PieceCircle[] piece9Circles = piece9.createPiece(9,board.id, bl.XCoor[8], bl.YCoor[8], bl.flag[8]) ;
        for ( int i = 0; i < 5; i++ )
                root.getChildren().add(piece9Circles[i]);
        
        PieceCircle[] piece10Circles = piece10.createPiece(10,board.id, bl.XCoor[9], bl.YCoor[9], bl.flag[9]) ;
        for ( int i = 0; i < 5; i++ )
                root.getChildren().add(piece10Circles[i]);
        
        PieceCircle[] piece11Circles = piece11.createPiece(11,board.id, bl.XCoor[10], bl.YCoor[10], bl.flag[10] );
        for ( int i = 0; i < 5; i++ )
                root.getChildren().add(piece11Circles[i]);
        
        PieceCircle[] piece12Circles = piece12.createPiece(12,board.id, bl.XCoor[11], bl.YCoor[11], bl.flag[11] );
        for ( int i = 0; i < 4; i++ )
                root.getChildren().add(piece12Circles[i]);
        
        
        ArrayList<PieceCircle[]> pieces = new ArrayList<PieceCircle[]>();
        pieces.add(piece1Circles);
        pieces.add(piece2Circles);
        pieces.add(piece3Circles);
        pieces.add(piece4Circles);
        pieces.add(piece5Circles);
        pieces.add(piece6Circles);
        pieces.add(piece7Circles);
        pieces.add(piece8Circles);
        pieces.add(piece9Circles);
        pieces.add(piece10Circles);
        pieces.add(piece11Circles);
        pieces.add(piece12Circles);
        
        finishButton = new JavaFXButtonEx("Menu");
        
        timeLabel.setLayoutX(550);
        timeLabel.setLayoutY(40);
        timeLabel.setFont(Font.font ("Tahoma", 29));

        moveLabel.setLayoutX(250);
        moveLabel.setLayoutY(40);
        moveLabel.setFont(Font.font ("Tahoma", 29));
        
        scoreLabel.setFont(Font.font ("Tahoma", 29));

        menuButton.setLayoutX(40);
        menuButton.setLayoutY(40);
        menuButton.setFont(Font.font("Tahoma", 20));
        menuButton.setStyle("-fx-background-radius: 20");
        
        exitButton.setFont(Font.font("Tahoma", 20));
        exitButton.setStyle("-fx-background-radius: 20");
        
        nightMode.setLayoutX(10);
        nightMode.setLayoutY(130);
        nightMode.setFont(Font.font("Tahoma", 16));
        
        hintButton.setLayoutX(700);
        hintButton.setLayoutY(40);
        hintButton.setFont(Font.font("Tahoma", 20));
        hintButton.setStyle("-fx-background-radius: 20");
        
        hintButton.setOnMouseClicked(t ->{
            hintTimer = (int)elapsedMillis / 1000;
            
            hintCounter++;
            
            if( hintCounter <= 3)
            {
                blackBGR = new VBox();
                
                if(difficultyNo == 1 || difficultyNo == 2 || difficultyNo == 3  )
                {
                    if(!hintPressed)
                    {
                        hintPressed = true;

                        imgViewer = new ImageView();

                        root.getChildren().addAll(hintBox, blackBGR);
                        
                        if( boardNo == 1)
                        {
                            blackBGR.setLayoutX(135);
                            blackBGR.setLayoutY(139);
                            blackBGR.setPrefSize(650, 290);
                            blackBGR.setStyle("-fx-background-color: black");
                            
                            hintBox.setLayoutX(board.getbCenterArrayX()[0][0] + 15);
                            hintBox.setLayoutY(board.getbCenterArrayY()[0][0] + 15);

                            hintBox.setPrefHeight(227);
                            hintBox.setPrefWidth(500);

                            hintBox.getChildren().addAll(imgViewer);
                            blackBGR.getChildren().add(hintBox);
                            hintBox.setAlignment(Pos.BOTTOM_CENTER);
                            
                            if(difficultyNo == 1)
                            {
                                try {
                                    image       = new Image( new FileInputStream(".\\src\\ıqpuzzlerpro\\Images\\black_board_easy.PNG"));
                                    imgViewer.setImage(image);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(IQPuzzlerPro.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            else if(difficultyNo == 2)
                            {
                                try {
                                    image       = new Image( new FileInputStream(".\\src\\ıqpuzzlerpro\\Images\\black_board_medium.PNG"));
                                    imgViewer.setImage(image);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(IQPuzzlerPro.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            else if( difficultyNo == 3)
                            {
                                try {
                                    image   = new Image( new FileInputStream(".\\src\\ıqpuzzlerpro\\Images\\black_board_medium.PNG"));
                                    imgViewer.setImage(image);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(IQPuzzlerPro.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        else if( boardNo == 2)
                        {
                            hintBox.setPrefHeight(300);
                            hintBox.setPrefWidth(500);

                            hintBox.setLayoutX(900);
                            hintBox.setLayoutY(40);

                            hintBox.setStyle("-fx-border-color: red;\n" +
                                             "-fx-border-insets: 1;\n" +
                                             "-fx-border-width: 1;\n");


                            hintBox.getChildren().addAll(imgViewer);

                            if(difficultyNo == 1)
                            {
                                try {
                                    image       = new Image( new FileInputStream(".\\src\\ıqpuzzlerpro\\Images\\gray_board_easy.PNG"));
                                    imgViewer.setImage(image);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(IQPuzzlerPro.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            else if(difficultyNo == 2)
                            {
                                try {
                                    image       = new Image( new FileInputStream(".\\src\\ıqpuzzlerpro\\Images\\gray_board_medium.PNG"));
                                    imgViewer.setImage(image);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(IQPuzzlerPro.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            else if( difficultyNo == 3)
                            {
                                try {
                                    image   = new Image( new FileInputStream(".\\src\\ıqpuzzlerpro\\Images\\gray_board_medium.PNG"));
                                    imgViewer.setImage(image);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(IQPuzzlerPro.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        
                        hintBox.toFront();
                        hintBox.setVisible(true);
                        
                        blackBGR.setVisible(true);
                    }
                }
            }
        });
        
        nightMode.setOnMouseClicked( t -> {
            if(nightModePressed != true)
            {
                nightModePressed = true;
                rec1= new Rectangle( d1.getWidth(), d1.getHeight());
                rec1.setFill(javafx.scene.paint.Color.BLACK);
                root.getChildren().add(rec1);
                moveLabel.setTextFill(javafx.scene.paint.Color.WHITE);
                timeLabel.setTextFill(javafx.scene.paint.Color.WHITE);
                nightMode.setTextFill(javafx.scene.paint.Color.WHITE);
                rec1.toBack();
            }
            else
            {
                root.getChildren().remove(rec1);
                moveLabel.setTextFill(javafx.scene.paint.Color.BLACK);
                timeLabel.setTextFill(javafx.scene.paint.Color.BLACK);
                nightMode.setTextFill(javafx.scene.paint.Color.BLACK);
                nightModePressed = false;
            }
        });
        
        menuButton.setOnMousePressed(t -> {
            if(menuPressed == false)
            {
                if( board.getBoardId() == 1)
                {
                    menuPressed = true;
                
                    menuButton.setText("Return Game!");

                    pauseScreen.getChildren().add(exitButton);
                    root.getChildren().addAll(pauseScreen);

                    pauseScreen.setLayoutX(135);
                    pauseScreen.setLayoutY(139);

                    pauseScreen.setPrefHeight(290);
                    pauseScreen.setPrefWidth(650);

                    pauseScreen.setStyle("-fx-background-color: black");
                    pauseScreen.setCursor(Cursor.WAIT);
                    pauseScreen.toFront();

                    exitButton.setAlignment(Pos.BOTTOM_CENTER);
                    pauseScreen.setAlignment(Pos.CENTER);
                    pauseScreen.setVisible(true);
                    
                    exitButton.setOnMousePressed(y -> {
                        System.exit(0);
                            
                    });
                }
                else if (board.getBoardId() == 2)
                {
                    menuPressed = true;
                    
                    menuButton.setText("Return Game!");
                    
                    pauseScreen.getChildren().add(exitButton);
                    root.getChildren().addAll(pauseScreen);

                    pauseScreen.setLayoutX(25);
                    pauseScreen.setLayoutY(100);
                    
                    pauseScreen.setPrefHeight(450);
                    pauseScreen.setPrefWidth(695);
                    
                    pauseScreen.setStyle("-fx-background-color: black");
                    pauseScreen.setCursor(Cursor.WAIT);
                    pauseScreen.toFront();

                    exitButton.setAlignment(Pos.BOTTOM_CENTER);
                    pauseScreen.setAlignment(Pos.CENTER);
                    pauseScreen.setVisible(true);
                    
                    exitButton.setOnMousePressed(y -> {
                        System.exit(0);
                    });
                }
            }
            else
            {
                menuPressed = false;
                menuButton.setText("Menu");
                
                pauseScreen.getChildren().remove(exitButton);
                root.getChildren().remove(pauseScreen);
            }
        });
        
        
        
        root.setOnMousePressed(t -> {
                activeCircle = (PieceCircle)t.getTarget();
        });
        
        root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) 
            {
                clickSound();
                if(board.getBoardId() == 1)
                {
                    if( !isGameOver())
                    {
                        for (int row = 0; row < 5; row++) 
                        {
                            for (int col = 0; col < 11; col++) 
                            {
                                if ( activeCircle.id == 1 )
                                    piece1.detectIntersection(piece1Circles, activeCircle, board, row, col, 5 );
                                else if ( activeCircle.id == 2 )
                                    piece2.detectIntersection(piece2Circles, activeCircle, board, row, col, 4 );
                                else if ( activeCircle.id == 3 )
                                    piece3.detectIntersection(piece3Circles, activeCircle, board, row, col, 5 );
                                else if ( activeCircle.id == 4 )
                                    piece4.detectIntersection(piece4Circles, activeCircle, board, row, col, 5 );
                                else if ( activeCircle.id == 5 )
                                    piece5.detectIntersection(piece5Circles, activeCircle, board, row, col, 3 );
                                else if ( activeCircle.id == 6 )
                                    piece6.detectIntersection(piece6Circles, activeCircle, board, row, col, 4 );
                                else if ( activeCircle.id == 7 )
                                    piece7.detectIntersection(piece7Circles, activeCircle, board, row, col, 5 );
                                else if ( activeCircle.id == 8 )
                                    piece8.detectIntersection(piece8Circles, activeCircle, board, row, col, 5 );
                                else if ( activeCircle.id == 9 )
                                    piece9.detectIntersection(piece9Circles, activeCircle, board, row, col, 5 );
                                else if ( activeCircle.id == 10 )
                                    piece10.detectIntersection(piece10Circles, activeCircle, board, row, col, 5 );
                                else if ( activeCircle.id == 11 )
                                    piece11.detectIntersection(piece11Circles, activeCircle, board, row, col, 5 );
                                else if ( activeCircle.id == 12 )
                                    piece12.detectIntersection(piece12Circles, activeCircle, board, row, col, 4 );
                           }
                        }
                        isBoardFull( board, pieces );
                    }
                }
                else if( board.getBoardId() == 2)
                {
                    for (int row = 0; row < 5; row++) 
                    {
                        for (int col = 0; col < 11; col++) 
                        {
                            if ( activeCircle.id == 1 )
                                piece1.detectIntersection(piece1Circles, activeCircle, board, row, col, 5 );
                            else if ( activeCircle.id == 2 )
                                piece2.detectIntersection(piece2Circles, activeCircle, board, row, col, 4 );
                            else if ( activeCircle.id == 3 )
                                piece3.detectIntersection(piece3Circles, activeCircle, board, row, col, 5 );
                            else if ( activeCircle.id == 4 )
                                piece4.detectIntersection(piece4Circles, activeCircle, board, row, col, 5 );
                            else if ( activeCircle.id == 5 )
                                piece5.detectIntersection(piece5Circles, activeCircle, board, row, col, 3 );
                            else if ( activeCircle.id == 6 )
                                piece6.detectIntersection(piece6Circles, activeCircle, board, row, col, 4 );
                            else if ( activeCircle.id == 7 )
                                piece7.detectIntersection(piece7Circles, activeCircle, board, row, col, 5 );
                            else if ( activeCircle.id == 8 )
                                piece8.detectIntersection(piece8Circles, activeCircle, board, row, col, 5 );
                            else if ( activeCircle.id == 9 )
                                piece9.detectIntersection(piece9Circles, activeCircle, board, row, col, 5 );
                            else if ( activeCircle.id == 10 )
                                piece10.detectIntersection(piece10Circles, activeCircle, board, row, col, 5 );
                            else if ( activeCircle.id == 11 )
                                piece11.detectIntersection(piece11Circles, activeCircle, board, row, col, 5 );
                            else if ( activeCircle.id == 12 )
                                piece12.detectIntersection(piece12Circles, activeCircle, board, row, col, 4 );
                       }
                        isBoardFull( board, pieces);
                    }
                }

                if( modeNo == 2)
                {
                    // MOVE COUNT CHANLLENGE
                    challengeFlag = true;
                    if(moveCount == challengeMoveCount)
                        moveCountChallenge( moveCount);
                }
                    
                if(!menuPressed)
                {
                    if( !isGameOver())
                    {
                        moveCount++;
                        moveLabel.setText("Move Counter : " + moveCount);
                    }
                }
            }
        });
        
        long startTime = System.currentTimeMillis();
        
        new AnimationTimer(){
             @Override
                public void handle(long now) {
                if(!menuPressed)
                {
                    elapsedMillis = System.currentTimeMillis() - startTime - elapsedMillis2;

                    if((elapsedMillis / 1000) == 20 )
                        timeLabel.setText( "Time : " + Long.toString(elapsedMillis / 1000));
                    else if((elapsedMillis / 1000) == 25 )
                        timeLabel.setText("Time : " + Long.toString(elapsedMillis / 1000));
                    else if((elapsedMillis / 1000) == 30 )
                        timeLabel.setText("Time : " + Long.toString(elapsedMillis / 1000));
                    else
                        timeLabel.setText("Time : " + Long.toString(elapsedMillis / 1000));
                    
                    if( modeNo == 1)
                    {
                        if( (elapsedMillis / 1000) >= challengeTime)
                            timeChallenge( elapsedMillis / 1000);
                    }
                    
                    if( (elapsedMillis / 1000) - hintTimer == 3)
                    {
                        hintPressed = false;

                        hintBox.getChildren().remove(imgViewer);
                        root.getChildren().remove(blackBGR);
                        root.getChildren().remove(hintBox);
                    }
                    
                    if(isGameOver())
                    {
                        if(!challengeFlag)
                        {
                            stop();
                            moveCount = moveCount;

                            score = (int)( (difficultyNo * 100000 / ( moveCount*(elapsedMillis / 1000) )) / hintCounter);

                            finishButton.setFont(Font.font("Tahoma", 20));

                            finishScreen.getChildren().addAll(moveLabel, timeLabel, scoreLabel, finishButton, exitButton);

                            finishButton.setOnMousePressed(t -> {
                                try {
                                    menu = new MenuViewer();
                                    Platform.exit();  
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(IQPuzzlerPro.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            });

                            timeLabel.setText("Time : " + Long.toString(elapsedMillis / 1000) );

                            scoreLabel.setText("Score : "+(int)score);
                            scoreLabel.setFont(Font.font("Tahoma", 20));

                            finishScreen.setLayoutX(boardViewer.getBoardWidth() / 3 );
                            finishScreen.setLayoutY(boardViewer.getBoardHeight() / 3);

                            finishScreen.setPrefHeight(300);
                            finishScreen.setPrefWidth(350);

                            finishScreen.setStyle("-fx-background-color: cadetblue");
                            finishScreen.toFront();

                            finishScreen.setAlignment(Pos.CENTER);
                            finishScreen.setVisible(true);

                            menuButton.setDisable(isGameOver());
                            
                            exitButton.setOnMousePressed(y -> {
                                System.exit(0);
                            });
                            
                            root.getChildren().add(finishScreen);

                            List<Player> pL = dataManager.getArrayInJSON();
                            Player p1 = pL.get(playerId);

                            if( boardNo == 1 )
                                p1.setgetBlackBoardCount();
                            else
                                p1.setGrayBoardCount();
                            
                            p1.setScore(score);
                            pL.set(playerId, p1);
                            dataManager.setArrayInJSON(pL);
                        }
                        else
                        {
                            stop();
                            
                            exitButton.setOnMousePressed(y -> {
                                System.exit(0);
                            });
                            
                            loserLabel.setLayoutX(250);
                            loserLabel.setLayoutY(40);
                            loserLabel.setFont(Font.font ("Tahoma", 70));
                            loserScreen.getChildren().addAll(loserLabel, exitButton);

                            loserScreen.setLayoutX(boardViewer.getBoardWidth() / 3 );
                            loserScreen.setLayoutY(boardViewer.getBoardHeight() / 3);

                            loserScreen.setPrefHeight(300);
                            loserScreen.setPrefWidth(350);

                            loserScreen.setStyle("-fx-background-color: red");
                            loserScreen.setPrefHeight(500);
                            loserScreen.setPrefWidth(1000);
                            loserScreen.toFront();

                            loserScreen.setAlignment(Pos.CENTER);
                            loserScreen.setVisible(true);

                            root.getChildren().add(loserScreen);
                        }
                    }
                }
                else
                {
                    elapsedMillis2 = (System.currentTimeMillis() - startTime) - elapsedMillis;
                }
            }
        }.start();
        
        gamePanel.setScene(scene);
        gamePanel.setVisible(true);
        
        return gamePanel;
    }

    public void isBoardFull( Board b1, ArrayList<PieceCircle[]> circlesArray )
    {
        if ( b1.id == 1 )
        {
            boolean ifTrue = false;
            
            for (int row = 0; row < 5; row++) 
            {
                for (int col = 0; col < 11; col++) 
                {    
                    Rectangle rec1 = b1.getRectangle( row, col );
                    
                    for ( int i = 0; i < 12; i++ )
                    {
                        PieceCircle[] circleArray = circlesArray.get(i);
                        int index = 0;

                        if ( i == 0 || i == 2 ||i == 3 ||i == 6 || i == 7 ||i == 8 ||i == 9 ||i == 10 )
                        {
                            index = 5;
                        }
                        else if ( i == 1 || i == 5 || i == 11)
                        {
                            index = 4;
                        }
                        else if ( i == 4)
                        {
                            index = 3;
                        }

                        for ( int j = 0; j < index; j++ )
                        {
                            Shape shape1 = rec1;
                            Shape shape2 = circleArray[j];
                            Shape intersect = Shape.intersect(shape1, shape2);

                            if (intersect.getBoundsInLocal().getWidth() != -1) 
                            {
                                flag    = true;
                                ifTrue  = true;
                                break;
                            }
                            else
                            {
                                flag = false;
                            }
                        }
                        if( ifTrue == true)
                            break;
                    }
                    b1.bFullArray[row][col] = flag;
                    ifTrue = false;
                }
            }
        }
        if (b1.id == 2)
        {
            boolean ifTrue = false;
            
            for (int row = 0; row < 9; row++) 
            {
                for (int col = 0; col < 11; col++) 
                {    
                    Rectangle rec1 = b1.getgRectangle( row, col );
                    
                    if ( rec1 != null )
                    {
                        for ( int i = 0; i < 12; i++ )
                        {
                            PieceCircle[] circleArray = circlesArray.get(i);
                            int index = 0;

                            if ( i == 0 || i == 2 ||i == 3 ||i == 6 || i == 7 ||i == 8 ||i == 9 ||i == 10 )
                            {
                                index = 5;
                            }
                            else if ( i == 1 || i == 5 || i == 11)
                            {
                                index = 4;
                            }
                            else if ( i == 4)
                            {
                                index = 3;
                            }

                            for ( int j = 0; j < index; j++ )
                            {
                                Shape shape1 = rec1;
                                Shape shape2 = circleArray[j];
                                Shape intersect = Shape.intersect(shape1, shape2);

                                if (intersect.getBoundsInLocal().getWidth() != -1) 
                                {
                                    flag    = true;
                                    ifTrue  = true;
                                    break;
                                }
                                else
                                {
                                    flag = false;
                                }
                            }
                            if( ifTrue == true)
                                break;
                        }
                        b1.gFullArray[row][col] = flag;
                        ifTrue = false;
                    }
                    else
                        b1.gFullArray[row][col] = false;
                }
            }
        }
    }
    
    public boolean isGameOver()
    {
        int flagCheck = 0;
        
        if ( boardNo == 1 )
        {
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 11; col++) {
                    if ( board.bFullArray[row][col] == true )    
                        flagCheck++;
                }
            }
        }
        else if ( boardNo == 2 )
        {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 11; col++) {
                    if ( board.gFullArray[row][col] == true )    
                        flagCheck++;
                }
            }             
        }
        return flagCheck == 55;
    }
    
    public void timeChallenge(long time)
    {
        if( time >= challengeTime)
        {
            challengeFlag = true;
            
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 11; col++) {
                    board.bFullArray[row][col] = true;
                }
            }
            isGameLosed = true;
            isGameOver();
        }
    }
    
    public void moveCountChallenge(int count)
    {
        if( count == challengeMoveCount)
        {
            challengeFlag = true;
            
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 11; col++) {
                    board.bFullArray[row][col] = true;
                }
            }
            isGameLosed = true;
            isGameOver();
        }
    }
    
    public void stopMusic()
    {
        clip.stop();
    }
    
    public void startMusic()
    {
        clip.start();
    }
    
    public JavaFXButtonEx getFinishButton()
    {
        return finishButton;
    }
    
    public void clickSound()
    {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(".\\src\\ıqpuzzlerpro\\Sound\\mouse.wav").getAbsoluteFile());
            clip2 = AudioSystem.getClip();
            clip2.open(audioInputStream);
            clip2.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String args[]) throws UnsupportedAudioFileException, LineUnavailableException
    {
        try {
            filePath = ".\\src\\ıqpuzzlerpro\\Sound\\Music.wav";
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            AudioFormat format = inputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(inputStream);
            clip.start();
        }
        catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("Error with playing sound.");
        }
        launch(args);
    }
}