package ıqpuzzlerpro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import javafx.event.EventHandler;
import javax.swing.JOptionPane;




public class MenuController implements ActionListener 
{
        
    private final MenuViewer    menuViewer;
    private final Menu1         mainMenuPanel;
    private final LeaderPanel   leaderPanel;
    private final SettingsPanel settingsPanel;
    private final HowToPlay     howToPlay;
    private final IQPuzzlerPro  gamePanel;
    private final GameModePanel gameModePanel;
    private final SelectBoardPanel selectBoardPanel;
    private final UserSelectionPanel userPanel;
    private final DataManager dataManager;
    private final LevelPanel levelPanel;
    
    private int modeNo;
    private int boardId;
    private int playerId;
    //private int difficultyNo;
    private int levelId;
    private List<Player> playerArray;
    private Player temp;
   
    public MenuController( MenuViewer       menuViewer,
                               Menu1        mainMenuPanel,
                               LeaderPanel  leaderPanel, 
                               SettingsPanel settingsPanel,
                               HowToPlay    howToPlay,
                               GameModePanel gameModePanel,
                               SelectBoardPanel selectBoardPanel,
                               UserSelectionPanel userPanel,
                               LevelPanel levelPanel,
                               IQPuzzlerPro gamePanel  
                            )
    {  
        this.menuViewer     = menuViewer;
        this.mainMenuPanel  = mainMenuPanel;
        this.leaderPanel    = leaderPanel;
        this.settingsPanel  = settingsPanel;
        this.howToPlay      = howToPlay;
        this.gamePanel      = gamePanel;
        this.gameModePanel  = gameModePanel;
        this.selectBoardPanel = selectBoardPanel;
        this.userPanel = userPanel;
        this.levelPanel = levelPanel;
        this.dataManager = new DataManager();
        //this.playerArray = new ArrayList<Player>();
        
        (mainMenuPanel.getStartGameButton()).addActionListener( this);
        (mainMenuPanel.getLeaderBoardButton()).addActionListener( this);
        (mainMenuPanel.getSettingsButton()).addActionListener( this);
        (mainMenuPanel.getHowToPlayButton()).addActionListener(this);
        (mainMenuPanel.getQuitButton()).addActionListener(this);
        
        (settingsPanel.getBackButton()).addActionListener( this);
        (settingsPanel.getMusicOnOffButton()).addActionListener( this);
        
        (howToPlay.getBackButton()).addActionListener( this);
        
        (leaderPanel.getBackButton()).addActionListener( this);
        //(leaderPanel.getTextField()).addActionListener( this);
        
        (gameModePanel.getBackButton()).addActionListener( this);   
        (gameModePanel.getTimeChallButton()).addActionListener( this);
        (gameModePanel.getMoveChallButton()).addActionListener( this);
        (gameModePanel.getNormalGameButton()).addActionListener( this);
        
        (selectBoardPanel.getBackButton()).addActionListener( this);   
        (selectBoardPanel.getBlackBoardButton()).addActionListener( this);
        (selectBoardPanel.getGrayBoardButton()).addActionListener( this);
        (selectBoardPanel.getb3DBoardButton()).addActionListener( this);
        
        (userPanel.addNewUserButton()).addActionListener( this);
        (userPanel.getNewUserNameField()).addActionListener( this);
        (userPanel.getUser1NameField()).addActionListener( this);
        (userPanel.getBackButton()).addActionListener( this);
        (userPanel.getUser2NameField()).addActionListener( this);
        (userPanel.getUser3NameField()).addActionListener( this);
        (userPanel.getUser4NameField()).addActionListener( this);
        (userPanel.selectUser1Button()).addActionListener( this);
        (userPanel.selectUser2Button()).addActionListener( this);
        (userPanel.selectUser3Button()).addActionListener( this);
        (userPanel.selectUser4Button()).addActionListener( this);
        (userPanel.deleteUser1Button()).addActionListener( this);
        (userPanel.deleteUser2Button()).addActionListener( this);
        (userPanel.deleteUser3Button()).addActionListener( this);
        (userPanel.deleteUser4Button()).addActionListener( this);
        
        (levelPanel.getBackButton()).addActionListener( this);
        (levelPanel.getLevel1Button()).addActionListener( this);
        (levelPanel.getLevel2Button()).addActionListener( this);
        (levelPanel.getLevel3Button()).addActionListener( this);
        
        
        
        playerArray = dataManager.getArrayInJSON();
        //System.out.println( dataManager.getPlayer(0) );
        
        if ( playerArray == null )
        {
            userPanel.getUser1NameField().setText("Empty");
            userPanel.getUser2NameField().setText("Empty");
            userPanel.getUser3NameField().setText("Empty");
            userPanel.getUser4NameField().setText("Empty");
        }
        else
        {
            switch (playerArray.size()) {
                case 1:
                    userPanel.getUser1NameField().setText(playerArray.get(0).getName());
                    break;
                case 2:
                    userPanel.getUser1NameField().setText(playerArray.get(0).getName());
                    userPanel.getUser2NameField().setText(playerArray.get(1).getName());
                    break;
                case 3:
                    userPanel.getUser1NameField().setText(playerArray.get(0).getName());
                    userPanel.getUser2NameField().setText(playerArray.get(1).getName());
                    userPanel.getUser3NameField().setText(playerArray.get(2).getName());
                    break;
                case 4:
                    userPanel.getUser1NameField().setText(playerArray.get(0).getName());
                    userPanel.getUser2NameField().setText(playerArray.get(1).getName());
                    userPanel.getUser3NameField().setText(playerArray.get(2).getName());
                    userPanel.getUser4NameField().setText(playerArray.get(3).getName());
                    break;
                default:
                    break;
            }
        }
        
        userPanel.getUser1NameField().setEditable(false); 
        userPanel.getUser2NameField().setEditable(false); 
        userPanel.getUser3NameField().setEditable(false); 
        userPanel.getUser4NameField().setEditable(false); 
        
        //(gamePanel.getFinishButton()).setOnAction(this);
        
    }
    
       
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        
        if( e.getSource().equals(mainMenuPanel.getStartGameButton()))
        {
            menuViewer.remove();
            menuViewer.add( userPanel);
        }
       
        else if( e.getSource().equals(mainMenuPanel.getLeaderBoardButton()))
        {
            String str = "";
            
            List<Player> playerArray = dataManager.getArrayInJSON();
            if( playerArray == null )
                (leaderPanel.getTextField()).setText("");
            else
            {
                for(int i = 0; i < playerArray.size(); i++)
                str = str + playerArray.get(i).getName()+ " -> " + playerArray.get(i).getScore() +"\n";
                (leaderPanel.getTextField()).setText(str);
                
            }
            menuViewer.remove();
            menuViewer.add( leaderPanel );
        }
     
        else if( e.getSource().equals(mainMenuPanel.getSettingsButton()))
        {
            menuViewer.removeAll();
            menuViewer.add(settingsPanel);
        }
       
        else if( e.getSource().equals(mainMenuPanel.getHowToPlayButton()))
        {
            menuViewer.removeAll();
            menuViewer.add(howToPlay);
        }
      
        else if( e.getSource().equals(mainMenuPanel.getQuitButton()))
        {
             menuViewer.dispatchEvent(new WindowEvent(menuViewer, WindowEvent.WINDOW_CLOSING));
        }
       
        //***************************************************************
        else if(e.getSource().equals(settingsPanel.getBackButton()))
        {
            menuViewer.remove();
            menuViewer.add( mainMenuPanel);
        }
        else if(e.getSource().equals(settingsPanel.getMusicOnOffButton()))
        {
            if(settingsPanel.getMusicOnOffButton().isSelected())
            {   
                gamePanel.stopMusic();
            }
            else
            {
                gamePanel.startMusic();
            }
        }
      
        //***************************************************************
        else if( e.getSource().equals(howToPlay.getBackButton()))
        {
           menuViewer.remove();
           menuViewer.add( mainMenuPanel);
        }
        
        //***************************************************************
        else if( e.getSource().equals(leaderPanel.getBackButton()))
        {
           menuViewer.remove();
           menuViewer.add( mainMenuPanel);
        }
        
        
        //***************************************************************
        else if( e.getSource().equals(gameModePanel.getBackButton()))
        {
           menuViewer.remove();
           menuViewer.add( userPanel);
        }
        else if( e.getSource().equals(gameModePanel.getNormalGameButton()))
        {
           modeNo = 0;
           menuViewer.remove();
           menuViewer.add( selectBoardPanel);
        }
        else if( e.getSource().equals(gameModePanel.getTimeChallButton()))
        {
           modeNo = 1;
           menuViewer.remove();
           menuViewer.add( gamePanel.createGame( modeNo, 1, dataManager, playerId,4 ));
        }
        else if( e.getSource().equals(gameModePanel.getMoveChallButton()))
        {
           modeNo = 2;
           menuViewer.remove();
           menuViewer.add( gamePanel.createGame( modeNo, 1, dataManager, playerId,4 ));
        }
        
        //***************************************************************
        else if( e.getSource().equals(selectBoardPanel.getBackButton()))
        {
           menuViewer.remove();
           menuViewer.add( gameModePanel);
        }
        else if( e.getSource().equals(selectBoardPanel.getBlackBoardButton()))
        {
           boardId = 1;
           List<Player> pL = dataManager.getArrayInJSON();
           Player temp = pL.get(playerId);
           int counter = 0;
           counter = temp.getBlackBoardCount();
           System.out.println("Counter ne oldu: "+ counter + "isim ne peki" + temp.getName() + "peki user count ne" + temp.getBlackBoardCount() );
           if( counter == 1 )
           {   //System.out.println( " BURDAAA  1 ");
               levelPanel.getLevel2Button().setEnabled(false);
               levelPanel.getLevel3Button().setEnabled(false);
           }
           else if( counter == 2)
           {   //System.out.println( " BURDAAA  2 ");
               levelPanel.getLevel2Button().setEnabled(true);
               levelPanel.getLevel3Button().setEnabled(false);
           }
           else
           {
               levelPanel.getLevel2Button().setEnabled(true);
               levelPanel.getLevel3Button().setEnabled(true);
           }
           menuViewer.remove();
           menuViewer.add( levelPanel );
        }
        else if( e.getSource().equals(selectBoardPanel.getGrayBoardButton()))
        {
           boardId = 2;
           menuViewer.remove();
           menuViewer.add( levelPanel );
        }
        else if( e.getSource().equals(selectBoardPanel.getb3DBoardButton()))
        {
           //menuViewer.remove();
           //menuViewer.add( levelPanel );
            //!!!!!!!!!!!!3D
        }
        //***************************************************************
        else if( e.getSource().equals(userPanel.addNewUserButton()))
        {
           if ( "Empty".equals((userPanel.getUser1NameField()).getText()))
           {
               playerId = 0;
               String name = userPanel.getNewUserNameField().getText();
               temp = dataManager.addPlayer(name, playerId);
               //playerArray[playerId] = temp;
                if ( dataManager.sameName == false && dataManager.isFull == false  )
               {
                    userPanel.getUser1NameField().setText(name);
                    menuViewer.remove();
                    menuViewer.add( gameModePanel);
               }
               else if ( dataManager.sameName == true )
                    JOptionPane.showMessageDialog(null, "This name is already entered, please enter another name.", "InfoBox: " + "", JOptionPane.INFORMATION_MESSAGE);
               else if ( dataManager.isFull == true )
                    JOptionPane.showMessageDialog(null, "There is no space for new entry, please remove at least one user.", "InfoBox: " + "", JOptionPane.INFORMATION_MESSAGE);
              
           }
           else if ( "Empty".equals((userPanel.getUser2NameField()).getText())  )
           {
               playerId = 1;
               String name = userPanel.getNewUserNameField().getText();
               temp = dataManager.addPlayer(name, playerId);
               //playerArray[playerId] = temp;
                if ( dataManager.sameName == false && dataManager.isFull == false  )
               {
                    userPanel.getUser2NameField().setText(name);
                    menuViewer.remove();
                    menuViewer.add( gameModePanel);
               }
               else if ( dataManager.sameName == true )
                    JOptionPane.showMessageDialog(null, "This name is already entered, please enter another name.", "InfoBox: " + "", JOptionPane.INFORMATION_MESSAGE);
               else if ( dataManager.isFull == true )
                    JOptionPane.showMessageDialog(null, "There is no space for new entry, please remove at least one user.", "InfoBox: " + "", JOptionPane.INFORMATION_MESSAGE);
              
           }
           else if ( "Empty".equals((userPanel.getUser3NameField()).getText())  )
           {
               playerId = 2;
               String name = userPanel.getNewUserNameField().getText();
               temp = dataManager.addPlayer(name, playerId);
               //playerArray[playerId] = temp;
                if ( dataManager.sameName == false && dataManager.isFull == false  )
               {
                    userPanel.getUser3NameField().setText(name);
                    menuViewer.remove();
                    menuViewer.add( gameModePanel);
               }
               else if ( dataManager.sameName == true )
                    JOptionPane.showMessageDialog(null, "This name is already entered, please enter another name.", "InfoBox: " + "", JOptionPane.INFORMATION_MESSAGE);
               else if ( dataManager.isFull == true )
                    JOptionPane.showMessageDialog(null, "There is no space for new entry, please remove at least one user.", "InfoBox: " + "", JOptionPane.INFORMATION_MESSAGE);
              
           }
           else if ( "Empty".equals((userPanel.getUser4NameField()).getText())  )
           {
               playerId = 3;
               String name = userPanel.getNewUserNameField().getText();
               temp = dataManager.addPlayer(name, playerId);
               //playerArray[playerId] = temp;
               if ( dataManager.sameName == false && dataManager.isFull == false  )
               {
                    userPanel.getUser4NameField().setText(name);
                    menuViewer.remove();
                    menuViewer.add( gameModePanel);
               }
                   
               else if ( dataManager.sameName == true )
                    JOptionPane.showMessageDialog(null, "This name is already entered, please enter another name.", "InfoBox: " + "", JOptionPane.INFORMATION_MESSAGE);
               else if ( dataManager.isFull == true )
                    JOptionPane.showMessageDialog(null, "There is no space for new entry, please remove at least one user.", "InfoBox: " + "", JOptionPane.INFORMATION_MESSAGE);
               
           }
           else
           {
               JOptionPane.showMessageDialog(null, "There is no space for new entry, please remove at least one user.", "InfoBox: " + "", JOptionPane.INFORMATION_MESSAGE);
           }
        }
        else if( e.getSource().equals(userPanel.getBackButton()))
        {
           menuViewer.remove();
           menuViewer.add( mainMenuPanel);
        }
        else if( e.getSource().equals(userPanel.selectUser1Button()))
        {
           playerId = 0;
           if ( !userPanel.getUser1NameField().getText().equals("Empty")  ) 
           {
               System.out.println("Birinci kısma girdi " + userPanel.getUser1NameField());
                menuViewer.remove();
                menuViewer.add( gameModePanel);
           }
        }
        else if( e.getSource().equals(userPanel.selectUser2Button()))
        {
           playerId = 1;
           if ( !userPanel.getUser2NameField().getText().equals("Empty")  ) 
           {
               System.out.println("İkinci kısma girdi " + userPanel.getUser2NameField());
                menuViewer.remove();
                menuViewer.add( gameModePanel);
           }
        }
        else if( e.getSource().equals(userPanel.selectUser3Button()))
        {
           playerId = 2;
           if ( !userPanel.getUser3NameField().getText().equals("Empty")  ) 
           {
               System.out.println("Üçüncü kısma girdi " + userPanel.getUser3NameField());
                menuViewer.remove();
                menuViewer.add( gameModePanel);
           }
        }
        else if( e.getSource().equals(userPanel.selectUser4Button()))
        {
           playerId = 3;
           if ( !userPanel.getUser4NameField().getText().equals("Empty")  ) 
           {
               System.out.println("Dördüncü kısma girdi " + userPanel.getUser4NameField());
                menuViewer.remove();
                menuViewer.add( gameModePanel);
           }
        }
        else if( e.getSource().equals(userPanel.deleteUser1Button()))
        {
           dataManager.removePlayer(userPanel.getUser1NameField().getText());
           //playerArray[0] = null;
           userPanel.getUser1NameField().setText("Empty");
        }
        else if( e.getSource().equals(userPanel.deleteUser2Button()))
        {
           dataManager.removePlayer(userPanel.getUser2NameField().getText());
           //playerArray[1] = null;
           userPanel.getUser2NameField().setText("Empty");
        }
        else if( e.getSource().equals(userPanel.deleteUser3Button()))
        {
           dataManager.removePlayer(userPanel.getUser3NameField().getText());
           //playerArray[2] = null;
           userPanel.getUser3NameField().setText("Empty");
        }
        else if( e.getSource().equals(userPanel.deleteUser4Button()))
        {
           dataManager.removePlayer(userPanel.getUser4NameField().getText());
           //playerArray[3] = null;
           userPanel.getUser4NameField().setText("Empty");
        }
        //*****************************************************************
         else if( e.getSource().equals(levelPanel.getBackButton()))
        {
           menuViewer.remove();
           menuViewer.add( selectBoardPanel);
        }
         else if( e.getSource().equals(levelPanel.getLevel1Button()))
        {
            levelId = 1;
            menuViewer.remove();
            menuViewer.add( gamePanel.createGame( modeNo, boardId, dataManager, playerId,  levelId ));
            (gamePanel.getFinishButton()).addActionListener(this);
        (gamePanel.getFinishButton()).setOnMousePressed(t -> { (gamePanel.getFinishButton()).actionPerformed((gamePanel.getFinishButton())); });
        }
         else if( e.getSource().equals(levelPanel.getLevel2Button()))
        {
            levelId = 2;
            menuViewer.remove();
            menuViewer.add( gamePanel.createGame( modeNo, boardId, dataManager, playerId,levelId ));
            (gamePanel.getFinishButton()).addActionListener(this);
        (gamePanel.getFinishButton()).setOnMousePressed(t -> { (gamePanel.getFinishButton()).actionPerformed((gamePanel.getFinishButton())); });
        }
         else if( e.getSource().equals(levelPanel.getLevel3Button()))
        {
            levelId = 3;
            menuViewer.remove();
            menuViewer.add( gamePanel.createGame( modeNo, boardId, dataManager, playerId,levelId ));
            (gamePanel.getFinishButton()).addActionListener(this);
        (gamePanel.getFinishButton()).setOnMousePressed(t -> { (gamePanel.getFinishButton()).actionPerformed((gamePanel.getFinishButton())); });
        }
        //***********************************************************************
         /*else if( e.getSource().equals (  gamePanel.getFinishButton()))
         {
             System.out.println("Button çalışıyo sanırım");
         }*/
         
        /*
         (levelPanel.getBackButton()).addActionListener( this);
        (levelPanel.getLevel1Button()).addActionListener( this);
        (levelPanel.getLevel2Button()).addActionListener( this);
        (levelPanel.getLevel3Button()).addActionListener( this);
        */
        else if( e.getSource().equals((gamePanel.getFinishButton()))) {
             JavaFXPanelEx e1 = menuViewer.getCurrentPanel2();
             e1.closeScene();
             e1.setOpaque(false);
             mainMenuPanel.setOpaque(true);
             // gamePanel.stage.close();//setVisible(false);
             //Platform.exit();
             //mainMenuPanel.toFront();
        }
    }
    
}

