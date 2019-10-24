/*
 * Main Class
 */
package ıqpuzzlerpro;

import java.awt.BorderLayout;

import java.awt.event.WindowEvent;
import java.io.File;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class IQPuzzlerPro extends Application  {  
   
    double orgSceneX = 0, orgSceneY = 0;
    double orgTranslateX, orgTranslateY;
    int scrollCount = 0;
    int newY = 0, newX = 0;
    int moveCount = 0;
    long elapsedMillis2;
    long elapsedMillis;
    
    Board board;
    Piece1 piece1;
    Piece2 piece2;
    Piece3 piece3;
    Piece4 piece4;
    Piece5 piece5;
    Piece6 piece6;
    Piece7 piece7;
    Piece8 piece8;
    Piece9 piece9;
    Piece10 piece10;
    Piece11 piece11;
    Piece12 piece12;
    Scene scene;
    JFrame  frame = new JFrame();
    
    static Menu1 menu;
    JFXPanel gamePanel;
    JPanel  currentJPanel;
    
    Label timeLabel = new Label();
    Label moveLabel = new Label("Move Counter : " + moveCount);
    
    Button menuButton = new Button("Menu");
    Button backButton = new Button("Back");
    
    VBox pauseScreen = new VBox(10);
    VBox finishScreen= new VBox(10);
    
    boolean menuPressed = false;
    
    static Clip clip;
    static String filePath;
    
    @Override 
    public void start(Stage primaryStage) 
    {  
        
        frame.setSize(1600,900);
        frame.setLayout(new BorderLayout());
        
        menu = new Menu1(frame);
        frame.add(menu, BorderLayout.CENTER);
        
        currentJPanel = menu;
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    JFXPanel createGame()
    {
        Group root = new Group();
        scene = new Scene(root, 1024, 1000);

        board = new Board(1);
        piece1 = new Piece1();
        piece2 = new Piece2();
        piece3 = new Piece3();
        piece4 = new Piece4();
        piece5 = new Piece5();
        piece6 = new Piece6();
        piece7 = new Piece7();
        piece8 = new Piece8();
        piece9 = new Piece9();
        piece10 = new Piece10();
        piece11 = new Piece11();
        piece12 = new Piece12();

        root.getChildren().add(timeLabel);
        root.getChildren().add(moveLabel);
        root.getChildren().add(menuButton);

        root.getChildren().add(board.selectBoard());
        root.getChildren().add(piece1.createPiece());
        root.getChildren().add(piece2.createPiece());
        root.getChildren().add(piece3.createPiece());
        root.getChildren().add(piece4.createPiece());
        root.getChildren().add(piece5.createPiece());
        root.getChildren().add(piece6.createPiece());
        root.getChildren().add(piece7.createPiece());
        root.getChildren().add(piece8.createPiece());
        root.getChildren().add(piece9.createPiece());
        root.getChildren().add(piece10.createPiece());
        root.getChildren().add(piece11.createPiece());
        root.getChildren().add(piece12.createPiece());

        Pieces piecesArray[];
        piecesArray = new Pieces[12];
        piecesArray[0] = piece1;
        piecesArray[1] = piece2;
        piecesArray[2] = piece3;
        piecesArray[3] = piece4;
        piecesArray[4] = piece5;
        piecesArray[5] = piece6;
        piecesArray[6] = piece7;
        piecesArray[7] = piece8;
        piecesArray[8] = piece9;
        piecesArray[9] = piece10;
        piecesArray[10] = piece11;
        piecesArray[11] = piece12;

        timeLabel.setLayoutX(1195);
        timeLabel.setLayoutY(110);
        timeLabel.setFont(Font.font ("Forte", 29));

        moveLabel.setLayoutX(1195);
        moveLabel.setLayoutY(150);
        moveLabel.setFont(Font.font ("Forte", 29));

        menuButton.setLayoutX(1195);
        menuButton.setLayoutY(25);
        menuButton.setFont(Font.font("Forte", 20));
        
        menuButton.setOnMousePressed(t -> {
            if(menuPressed == false)
            {
                menuPressed = true;
                
                menuButton.setText("Return Game!");
                
                root.getChildren().add(pauseScreen);

                pauseScreen.setLayoutX(5);
                pauseScreen.setLayoutY(5);

                pauseScreen.setPrefHeight(495);
                pauseScreen.setPrefWidth(1100);

                pauseScreen.setStyle("-fx-background-color: black");
                pauseScreen.setCursor(Cursor.WAIT);
                pauseScreen.toFront();

                backButton.setFont(Font.font("Forte", 20));
                pauseScreen.setAlignment(Pos.CENTER);
                pauseScreen.setVisible(true);
            }
            else
            {
                menuPressed = false;
                menuButton.setText("Menu");
                
                pauseScreen.getChildren().remove(backButton);
                root.getChildren().remove(pauseScreen);
                //pauseScreen.setVisible(false);
            }
        });

        root.setOnMouseClicked(t -> {
            if(!menuPressed)
            {
                if(isGameOver())
                {
                    moveCount = moveCount;
                }
                else
                {
                    moveCount++;
                    moveLabel.setText("Move Counter : " + moveCount);
                }
            }
        });

        scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for (int row = 0; row < 5; row++) {
                    for (int col = 0; col < 11; col++) {
                        piece1.detectIntersection(board.recArray[row][col] , board.centerArrayX, board.centerArrayY, row, col , board.fullArray );
                        piece2.detectIntersection(board.recArray[row][col] , board.centerArrayX, board.centerArrayY, row, col , board.fullArray  );
                        piece3.detectIntersection(board.recArray[row][col] , board.centerArrayX, board.centerArrayY, row, col , board.fullArray  );
                        piece4.detectIntersection(board.recArray[row][col] , board.centerArrayX, board.centerArrayY, row, col , board.fullArray  );
                        piece5.detectIntersection(board.recArray[row][col] , board.centerArrayX, board.centerArrayY, row, col , board.fullArray  );
                        piece6.detectIntersection(board.recArray[row][col] , board.centerArrayX, board.centerArrayY, row, col , board.fullArray  );
                        piece7.detectIntersection(board.recArray[row][col] , board.centerArrayX, board.centerArrayY, row, col , board.fullArray  );
                        piece8.detectIntersection(board.recArray[row][col] , board.centerArrayX, board.centerArrayY, row, col , board.fullArray  );
                        piece9.detectIntersection(board.recArray[row][col] , board.centerArrayX, board.centerArrayY, row, col , board.fullArray  );
                        piece10.detectIntersection(board.recArray[row][col] , board.centerArrayX, board.centerArrayY, row, col , board.fullArray  );
                        piece11.detectIntersection(board.recArray[row][col] , board.centerArrayX, board.centerArrayY, row, col , board.fullArray  );
                        piece12.detectIntersection(board.recArray[row][col] , board.centerArrayX, board.centerArrayY, row, col , board.fullArray  );
                   }
                }
            }
        });
        
        root.setOnMouseReleased(t ->{
            if(isGameOver())
            {
                Button finishButton = new Button("Menu");
                
                finishButton.setFont(Font.font("Forte", 20));
                
                finishScreen.getChildren().addAll(moveLabel, timeLabel, finishButton);
                
                timeLabel.setText("Time : " + Long.toString(elapsedMillis / 1000) );
                
                finishScreen.setLayoutX(500);
                finishScreen.setLayoutY(250);

                finishScreen.setPrefHeight(350);
                finishScreen.setPrefWidth(350);

                finishScreen.setStyle("-fx-background-color: cadetblue");
                finishScreen.toFront();

                finishScreen.setAlignment(Pos.CENTER);
                finishScreen.setVisible(true);
                
                menuButton.setDisable(isGameOver());
                
                finishButton.setOnMousePressed(y -> {
                    
                    //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    start(new Stage());
                    
                });
                
                root.getChildren().add(finishScreen);
            }
        });
        
        
        long startTime = System.currentTimeMillis();
        
        new AnimationTimer(){
             @Override
                public void handle(long now) {
                if(!menuPressed)
                {
                    elapsedMillis = System.currentTimeMillis() - startTime - elapsedMillis2;
                    //System.out.println("elapsedMillis : " + elapsedMillis);
                    if((elapsedMillis / 1000) == 20 )
                    timeLabel.setText( "Time : " + Long.toString(elapsedMillis / 1000)+ " Hurry Up ... ");
                    else if((elapsedMillis / 1000) == 25 )
                    timeLabel.setText("Time : " + Long.toString(elapsedMillis / 1000)+ " Come on ... ");
                    else if((elapsedMillis / 1000) == 30 )
                    timeLabel.setText("Time : " + Long.toString(elapsedMillis / 1000)+ " You can do it ... ");
                    else
                    timeLabel.setText("Time : " + Long.toString(elapsedMillis / 1000));
                    
                    if(isGameOver())
                    {
                        stop();
                    }
                    
                }
                else
                {
                    elapsedMillis2 = (System.currentTimeMillis() - startTime) - elapsedMillis ;
                    //System.out.println("elapsedMillis2 : " + elapsedMillis2);
                }
            }
        }.start();
        
        gamePanel = new JFXPanel();
        gamePanel.setScene(scene);
        gamePanel.setVisible(true);
        
        return gamePanel;
    }

    public boolean isGameOver()
    {
        if ( moveCount == 9 )
            return true;
        else
            return false;
    }
    
    public String getFilePath()
    {    
        return this.filePath;
    }
    public void setFilePath(String path)
    {
        path = null;
        path = filePath;
    }
    public Clip getClip(){
        return clip;
    }
    public void setClip(Clip clip)
    {
        clip = this.clip;
    }
    
    public void stopMusic()
    {
        getClip().stop();
    }
    
    public void startMusic()
    {
        getClip().start();
    }
    
    public static void main(String args[]){ 
        try {
            filePath = "C:\\Users\\Dervis\\Desktop\\IQPuzzlerProSon_v2\\IQPuzzlerPro\\Musics\\videoplayback.wav";
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(filePath));
            AudioFormat format = inputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(inputStream);
            clip.start();
            if(menu.getFlag2() == true)
            {   
                clip.stop();
            }
        }
        catch (Exception e) {
            System.out.println("Error with playing sound.");
            e.printStackTrace( );
        }
        launch(args);
    }
}