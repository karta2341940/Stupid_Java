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
        lefts.setBounds(0,50,200,720);
    
        middle = new JPanel();
        middle.setBackground(Color.black);
        middle.setBounds(200,50,600,480);
        
        right = new JPanel();
        right.setBackground(Color.blue);
        right.setBounds(800,50,500,480);

        down = new JPanel();
        down.setBackground(Color.green);
        down.setBounds(200,500,1230,200);


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