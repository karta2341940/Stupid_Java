package com.menu;
import com.IDEscreen.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menu extends JFrame{
    public menu()
    {
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        this.setLayout(null);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Lousu Java");
        title.setFont(new Font("Dialog", 1, 70));
        p1.add(title);
        p2.setBackground(Color.BLACK);

        int LevelNum = 25; //共?關
        // title陣列 從1開始
        String[] LevelTitle = {"", "a123456789", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        JButton btnArray[] = new JButton[LevelNum+1];
        JLabel lblArray[] = new JLabel[LevelNum+1];
        // 新增按鈕、標籤迴圈
        for(int i=0;i<(LevelNum/5)+1;i++)
        {
            p2.add(Box.createVerticalStrut(20));
            //
            Box rowBox = Box.createHorizontalBox();
            rowBox.add(Box.createRigidArea(new Dimension(20,0))); 
            int n;
            n = (i>=LevelNum/5)?LevelNum%5:5;
            for(int j=1+i*5;j<=n+i*5;j++)
            {
                btnArray[j] = new JButton(Integer.toString(j));
                btnArray[j].setFont(new Font("Dialog", 1, 30)); //字型
                btnArray[j].putClientProperty("JButton.buttonType" , "roundRect"); //外觀為圓角
                Dimension btnSize = new Dimension(70,70);  //大小
                btnArray[j].setMinimumSize(btnSize);
                btnArray[j].setPreferredSize(btnSize);
                btnArray[j].setMaximumSize(btnSize);
                // 新增按鈕listener
                btnArray[j].addActionListener
                (
                    new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            System.out.println(((JButton) e.getSource()).getText());
                            switch(((JButton) e.getSource()).getText())
                            {
                                case "1":
                                    new Q1();
                                    break;
                                case "2":
                                    new Q2();
                                    break;
                                case "3":
                                    new Q3();
                                    break;
                            }
                        }
                    }
                );
                
                lblArray[j] = new JLabel(LevelTitle[j]);
                lblArray[j].setFont(new Font("Dialog", 0, 30)); //字型
                Dimension lblSize = new Dimension(180,50); //大小
                lblArray[j].setMinimumSize(lblSize);
                lblArray[j].setPreferredSize(lblSize);
                lblArray[j].setMaximumSize(lblSize);
                
                rowBox.add(btnArray[j]);
                rowBox.add(lblArray[j]);
                
            }
            rowBox.add(Box.createHorizontalGlue());
            p2.add(rowBox);
        }

        p1.setBounds(0, 50, 1280, 100);
        p2.setBounds(0, 150, 1280, 570);

        this.add(p1);
        this.add(p2);
    }
}
