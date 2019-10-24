/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ıqpuzzlerpro;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 *
 * @author zeynep
 */
public class JavaFXButtonEx extends Button{
    
    public JavaFXButtonEx(String text) {
        super(text);
    }
    
    private ActionListener listener;
    
    public void addActionListener(ActionListener listener)
    {
        this.listener = listener;
    }
      
    public void actionPerformed(Object source){
        listener.actionPerformed(new ActionEvent(source, -100, ""));
    }
}
