/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package ıqpuzzlerpro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.embed.swing.JFXPanel;

/**
 *
 * @author zeynep
 */
public class JavaFXPanelEx extends JFXPanel{
    public JavaFXPanelEx() {
        super();
    }
    
    private ActionListener listener;
    
    public void addActionListener(ActionListener listener)
    {
        this.listener = listener;
    }
      
    public void actionPerformed(Object source){
        listener.actionPerformed(new ActionEvent(source, -100, ""));
    }
    public void closeScene(){
        this.setVisible(false);
    }
}
