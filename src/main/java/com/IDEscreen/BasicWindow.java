package com.IDEscreen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicWindow extends JFrame
{
    private JPanel lefts;
    private JPanel up;
    private JPanel right;
    private JPanel middle;
    private JPanel down;
    public JButton btns;
    
    public BasicWindow()
    {
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);

        up = new JPanel();
        up.setLayout(new FlowLayout(FlowLayout.LEFT));
        up.setBackground(Color.WHITE);
        up.setBounds(0,0,1280,50);

        lefts = new JPanel();
        lefts.setBackground(Color.gray);
        lefts.setBounds(0,56,195,621);
    
        middle = new JPanel();
        middle.setBackground(Color.gray);
        middle.setBounds(200,56,595,480);
        
        right = new JPanel();
        right.setBackground(Color.gray);
        right.setBounds(800,56,460,480);

        down = new JPanel();
        down.setBackground(Color.gray);
        down.setBounds(200,545,1060,132);


        btns = new JButton("implement");
        

        this.add(up);
        this.add(lefts);
        this.add(middle);
        this.add(right);
        this.add(down);

        this.up.add(btns);


/* 
        
        JPanel pLeft = new JPanel();
        pLeft.setBackground(Color.YELLOW);
        pLeft.setBounds(100, 100, 200, 200);
        this.add(pLeft);
*/
    }
}