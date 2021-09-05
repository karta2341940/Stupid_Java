package com.IDEscreen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicWindow extends JFrame
{
    public BasicWindow()
    {
        this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
        
        JPanel pLeft = new JPanel();
        pLeft.setBackground(Color.YELLOW);
        pLeft.setBounds(100, 100, 200, 200);
        this.add(pLeft);

    }
}