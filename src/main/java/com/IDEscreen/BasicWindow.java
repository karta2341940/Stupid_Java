package com.IDEscreen;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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

    ArrayList<Object> puzzleAL = new ArrayList<Object>();

    private String selectedStr = "";
    private JButton tempButton = null;

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
        JButton for_btn = new JButton(icon);
        JButton print_btn = new JButton(icon);
        lefts.add(for_btn);
        lefts.add(print_btn);
        
        ActionListener btnlistener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Object source = e.getSource();
                
                if(e.getSource()==tempButton) //是否按到重複的按鈕
                {
                    selectedStr = "";
                    tempButton.setBorder(null);
                    tempButton = null;
                }
                else{
                    if(tempButton!=null) //直接切換按鈕，清除之前框框
                        tempButton.setBorder(null);

                    if(e.getSource()==for_btn)
                        selectedStr = "for";
                    else if(e.getSource()==print_btn)
                        selectedStr = "print";
                    
                    tempButton = (JButton)source;
                    tempButton.setBorder(new LineBorder(Color.red));
                }
            }
        };
        for_btn.addActionListener(btnlistener);
        print_btn.addActionListener(btnlistener);
        

        middle = new JPanel();
        middle.setBounds(200,56,595,480);
        middle.setBackground(Color.gray);
        middle.setLayout(null);
        middle.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e) {
                if(selectedStr != "")
                {
                    puzzleAL.add(new MovePanel(selectedStr, e.getPoint() )); // 新增拼圖到ArrayList  
                    middle.add((MovePanel)puzzleAL.get(puzzleAL.size()-1));
                    System.out.println("puzzle amount:" + puzzleAL.size());
                    middle.revalidate();
                    middle.repaint();
                }
            }
        });

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

        this.add(up);
        this.add(lefts);
        this.add(middle);
        this.add(right);
        this.add(down);

        this.up.add(btns);
    }
}