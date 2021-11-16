package com.IDEscreen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class question extends JFrame
{
    private JLabel questionlbl;
    private JPanel p1;
    private String questionStr;
    public question(int questionN)
    {
        this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800, 620);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        switch(questionN)
        {
            case 1:
                questionStr = "題目一：請試著做出Hello World";
                break;

        }
        
        
        questionlbl = new JLabel(questionStr);
        questionlbl.setFont(new Font("Dialog", 1, 30));
        p1.add(questionlbl);
        this.add(p1);


    }
}
