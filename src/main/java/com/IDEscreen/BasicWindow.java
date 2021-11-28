package com.IDEscreen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicWindow extends JFrame
{
    private JPanel lefts;
    private JPanel up;
    private JPanel right;
    public JPanel middle;
    private JPanel down;

    public JButton btns;
    protected String CodeStr="<html><head></head><body><p>public class HelloWorld{</p><br/><p>public static main(){</p><br/><p>System.out.println(\"Hello World\");</p><p>}<br>}</p> </body></html>";
    protected JLabel Codelbl;
    private JLabel resultlbl;

    protected ImageIcon icon;

    /*ImageIcon image = new ImageIcon("smile.png");
    final int WIDTH = image.getIconWidth();
    final int HEIGHT = image.getIconHeight();
    Point imageCorner;
    Point prevPt;*/
    
    public BasicWindow()
    {
        this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
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
        ImageIcon icon = new ImageIcon("src\\main\\java\\com\\IDEscreen\\for.png");
        JButton iconbutton = new JButton(icon);
        this.lefts.add(iconbutton);
        iconbutton.addActionListener
                (
                    new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            middle.add(new MovePanel());
                        }
                    }
                );

        //middle = new MovePanel();
        middle = new JPanel();
        middle.add(new MovePanel());
        middle.setBounds(200,56,595,480);
        middle.setBackground(Color.gray);
        middle.setLayout(null);
        //middle.setBounds(200,56,595,480);
        

        right = new JPanel();
        right.setBackground(Color.gray);
        right.setBounds(800,56,460,480);
        Codelbl = new JLabel(CodeStr);
        right.add(Codelbl);


        down = new JPanel();
        down.setBackground(Color.gray);
        down.setBounds(200,545,1060,132);
        resultlbl = new JLabel("Hello World");
        down.add(resultlbl);


        btns = new JButton("implement");
        
        //DragPanel dragPanel = new DragPanel();

        this.add(up);
        this.add(lefts);
        this.add(middle);
        this.add(right);
        this.add(down);

        this.up.add(btns);
        //this.lefts.add(dragPanel);

/* 
        
        JPanel pLeft = new JPanel();
        pLeft.setBackground(Color.YELLOW);
        pLeft.setBounds(100, 100, 200, 200);
        this.add(pLeft);
*/
    }
}