package ıqpuzzlerpro;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MenuViewer extends JFrame 
{
    // PROPERTIES   
    private final Menu1             mainMenuPanel;
    private final LeaderPanel       leaderPanel;
    private final SettingsPanel     settingsPanel;
    private final HowToPlay         howToPlay;
    private final IQPuzzlerPro      gamePanel;
    private final MenuController actionListener;
    private final GameModePanel     gameModePanel;
    private final SelectBoardPanel  selectBoardPanel;
    private final UserSelectionPanel userPanel;
    private final LevelPanel levelPanel;

    private JPanel currentPanel;
    private JavaFXPanelEx currentPanel2;
    private Dimension dimMax;
    private final int screenWidth;
    private final int screenHeigth;
    
    // CONSTRUCTOR
    public MenuViewer() throws FileNotFoundException
    {
        // this.username = username;
        // Initilazing topFixedPanel, homePage, topListPanel, loginPanel, signinPanel and actionListener
        mainMenuPanel    = new Menu1();
        leaderPanel      = new LeaderPanel();
        settingsPanel    = new SettingsPanel();
        howToPlay        = new HowToPlay();
        gamePanel        = new IQPuzzlerPro();
        gameModePanel    = new GameModePanel();
        selectBoardPanel = new SelectBoardPanel();
        userPanel        = new UserSelectionPanel();
        levelPanel       = new LevelPanel();
        currentPanel2    = new JavaFXPanelEx();
        actionListener   = new MenuController(this, mainMenuPanel, leaderPanel,
                            settingsPanel, howToPlay, gameModePanel, selectBoardPanel, userPanel, levelPanel, gamePanel);
        
        screenWidth = 1600;
        screenHeigth= 900;
        
        // Setting layout to loginPanel
        //loginPanel.setLayout(new GridBagLayout());
        dimMax = Toolkit.getDefaultToolkit().getScreenSize();
        
        int locationX = (int) (dimMax.getWidth() - screenWidth) / 2;
        
        this.setMinimumSize(new Dimension( screenWidth, screenHeigth));
        this.setPreferredSize(new Dimension( screenWidth, screenHeigth));
        //this.setBounds(WIDTH, WIDTH, 1600, 900);
        //this.setMaximumSize(new Dimension( 1600, 900));
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.add( mainMenuPanel, BorderLayout.CENTER);

        currentPanel = mainMenuPanel;
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // METHODS
    public void add(JPanel panel)
    {
        add(panel, BorderLayout.CENTER);
        repaint();
        revalidate();
        currentPanel = panel;
    }
    
    public void add2(JavaFXPanelEx panel)
    {
        add(panel, BorderLayout.CENTER);
        repaint();
        revalidate();
        currentPanel2 = panel;
    }
    
    public void remove()
    {
        remove(currentPanel);
        repaint();
        revalidate();
    }
    
    public void removeAll()
    {
        this.getContentPane().removeAll();
        repaint();
        revalidate();
    }
    
    public Menu1 getMainMenuPanel() 
    {
        return mainMenuPanel;
    }
    
    public LeaderPanel getLeaderPanel() 
    {
        return leaderPanel;
    }
    
    public SettingsPanel settingsPanel() 
    {
        return settingsPanel;
    }
    
    public HowToPlay howToPlay() 
    {
        return howToPlay;
    }
    
    public IQPuzzlerPro gamePanel() 
    {
        return gamePanel;
    }
    
    public JPanel getSelectBoardPanel() 
    {
        return selectBoardPanel;
    }
    
    public JPanel getGameModePanel() 
    {
        return gameModePanel;
    }
    
    public JPanel getCurrentPanel() 
    {
        return currentPanel;
    }
    
    public JavaFXPanelEx getCurrentPanel2() 
    {
        return currentPanel2;
    }
    
}

