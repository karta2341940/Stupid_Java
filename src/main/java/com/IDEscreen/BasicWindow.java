package com.IDEscreen;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class BasicWindow extends JFrame
{
    public int QuestionN;

    private JPanel lefts;
    private JScrollPane leftScroll;
    private JPanel up;
    protected JPanel right;
    public JLayeredPane middle;
    private JPanel down;

    public JButton btns;
    //protected String CodeStr="<html><head></head><body><p>public class HelloWorld{</p><br/><p>public static main(){</p><br/><p>System.out.println(\"Hello World\");</p><p>}<br>}</p> </body></html>";
    protected JLabel Questionlbl;
    private JLabel resultlbl;

    protected ImageIcon icon;

    ArrayList<Object> puzzleAL = new ArrayList<Object>();

    private String selectedStr = "";
    private JButton tempButton = null;

    public BasicWindow()
    {
        // 設定ide基本視窗
        this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
        this.addKeyListener(new KeyAdapter(){ // 拖移時將拼圖改成最上層
            @Override
            public void keyReleased(KeyEvent e) 
            {
                System.out.println(e.getKeyChar());
            }
        });

        up = new JPanel();
        up.setLayout(new FlowLayout(FlowLayout.LEFT));
        up.setBackground(Color.WHITE);
        up.setBounds(0,0,1280,50);

        
        lefts = new JPanel();
        lefts.setBackground(Color.gray);
        lefts.setPreferredSize(new Dimension(190,1000));
        //ImageIcon icon = new ImageIcon("src\\main\\java\\com\\IDEscreen\\for.png");
        LeftBtnEvent();
        leftScroll = new JScrollPane(lefts,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        leftScroll.getVerticalScrollBar().setUnitIncrement(15);
        leftScroll.setBounds(0,56,195,621);

        middle = new JLayeredPane(); // 層級面板
        middle.setBounds(200,56,595,480);
        middle.setOpaque(true);
        middle.setBackground(Color.gray);
        middle.setLayout(null);
        middle.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e) { // 滑鼠放開，新增拼圖
                if(selectedStr != "") // 如果有選擇拼圖
                {
                    MovePanel movePanel = new MovePanel(selectedStr, e.getPoint());
                    puzzleAL.add(movePanel); // 新增拼圖到ArrayList  
                    middle.add(movePanel);
                    System.out.println("puzzle amount:" + puzzleAL.size());
                    middle.revalidate(); // 更新panel
                    middle.repaint();
                }
            }
        });

        right = new JPanel();
        right.setBackground(Color.gray);
        right.setBounds(800,56,460,480);

        down = new JPanel();
        down.setBackground(Color.gray);
        down.setBounds(200,545,1060,132);
        resultlbl = new JLabel("Hello World");
        down.add(resultlbl);

        btns = new JButton("implement"); // test

        this.add(up);
        this.add(leftScroll);
        this.add(middle);
        this.add(right);
        this.add(down);

        this.up.add(btns);
    }

    private void LeftBtnEvent()
    {
        int BtnAmount = 20;
        JButton[] buttons = new JButton[20];

        for(int i=0;i<BtnAmount;i++)
        {
            buttons[i] = new JButton();
            buttons[i].setPreferredSize(new Dimension(140, 30));
            switch(i)
            {
                case 0:
                    buttons[i].setText("for");
                    break;
                case 1:
                    buttons[i].setText("print");
                    break;
                case 2:
                    buttons[i].setText("println");
                    break;
                case 3:
                    buttons[i].setText("public class");
                    break;
                case 4:
                    buttons[i].setText("public static void");
                    break;
                case 5:
                    buttons[i].setText("int");
                    break;
                case 6:
                    buttons[i].setText(" ");
                    break;
                case 7:
                    buttons[i].setText("if");
                    break;
                case 8:
                    buttons[i].setText("else if");
                    break;
                case 9:
                    buttons[i].setText("else");
                    break;
                case 10:
                    buttons[i].setText("byte");
                    break;
                case 11:
                    buttons[i].setText("short");
                    break;
                case 12:
                    buttons[i].setText("char");
                    break;
                case 13:
                    buttons[i].setText("long");
                    break;
                case 14:
                    buttons[i].setText("float");
                    break;
                case 15:
                    buttons[i].setText("double");
                    break;
                case 16:
                    buttons[i].setText("switch");
                    break;
                case 17:
                    buttons[i].setText("case");
                    break;
                case 18:
                    buttons[i].setText("break");
                    break;
                case 19:
                    buttons[i].setText("while");
                    break;
            }
            lefts.add(buttons[i]);
        }
        ActionListener btnlistener = new ActionListener() { // 按鈕監聽器
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JButton source = (JButton)e.getSource();
                if(source==tempButton) // 按到重複的按鈕，清除當前框框與selectedStr
                {
                    selectedStr = "";
                    source.setBorder(null);
                    tempButton = null;
                }
                else // 按到不重複按鈕
                {
                    if(tempButton!=null) //直接切換按鈕，清除上次按鈕框框
                        tempButton.setBorder(null);

                    source.setBorder(new LineBorder(Color.red)); // 畫框框
                    if     (source==buttons[0]) // 是否按到 for_btn
                        selectedStr = "for";
                    else if(source==buttons[1])
                        selectedStr = "print";
                    else if(source==buttons[2])
                        selectedStr = "println";
                    else if(source==buttons[3])
                        selectedStr = "public_class";
                    else if(source==buttons[4])
                        selectedStr = "public_static_void";
                    else if(source==buttons[5])
                        selectedStr = "int";
                    else if(source==buttons[6])
                        selectedStr = "  ";
                    else if(source==buttons[7])
                        selectedStr = "if";
                    else if(source==buttons[8])
                        selectedStr = "elseif";
                    else if(source==buttons[9])
                        selectedStr = "else";
                    else if(source==buttons[10])
                        selectedStr = "byte";
                    else if(source==buttons[11])
                        selectedStr = "short";
                    else if(source==buttons[12])
                        selectedStr = "char";
                    else if(source==buttons[13])
                        selectedStr = "long";
                    else if(source==buttons[14])
                        selectedStr = "float";
                    else if(source==buttons[15])
                        selectedStr = "double";
                    else if(source==buttons[16])
                        selectedStr = "switch";
                    else if(source==buttons[17])
                        selectedStr = "case";
                    else if(source==buttons[18])
                        selectedStr = "break";
                    else if(source==buttons[19])
                        selectedStr = "while";
                    
                    tempButton = (JButton)source; // 按鈕儲存給下次點擊比對用
                }
            }
        };
        for(int i=0;i<BtnAmount;i++)
        {
            buttons[i].addActionListener(btnlistener);
        }
        /*JButton for_btn = new JButton("for");
        JButton print_btn = new JButton("print");
        JButton println_btn = new JButton("println");
        JButton public_class_btn = new JButton("public class");
        JButton public_static_void_btn = new JButton("public static void");
        JButton int_btn = new JButton("int");
        JButton _btn = new JButton("  ");
        JButton if_btn = new JButton("if");
        JButton elseif_btn = new JButton("else if");
        JButton else_btn = new JButton("else");
        JButton byte_btn = new JButton("byte");
        JButton short_btn = new JButton("short");
        JButton char_btn = new JButton("char");
        JButton long_btn = new JButton("long");
        JButton float_btn = new JButton("float");
        JButton double_btn = new JButton("double");
        JButton switch_btn = new JButton("switch");
        JButton case_btn = new JButton("case");
        JButton break_btn = new JButton("break");
        JButton while_btn = new JButton("while");
        lefts.add(public_class_btn);
        lefts.add(public_static_void_btn);
        lefts.add(int_btn);
        lefts.add(for_btn);
        lefts.add(print_btn);
        lefts.add(println_btn);
        lefts.add(_btn);
        lefts.add(if_btn);
        lefts.add(elseif_btn);
        lefts.add(else_btn);
        lefts.add(byte_btn);
        lefts.add(short_btn);
        lefts.add(char_btn);
        lefts.add(long_btn);
        lefts.add(float_btn);
        lefts.add(double_btn);
        lefts.add(switch_btn);
        lefts.add(case_btn);
        lefts.add(break_btn);
        lefts.add(while_btn);
        // 按鈕新增監聽器
        for_btn.addActionListener(btnlistener);
        print_btn.addActionListener(btnlistener);
        println_btn.addActionListener(btnlistener);
        public_class_btn.addActionListener(btnlistener);
        public_static_void_btn.addActionListener(btnlistener);
        int_btn.addActionListener(btnlistener);
        _btn.addActionListener(btnlistener);
        if_btn.addActionListener(btnlistener);
        elseif_btn.addActionListener(btnlistener);
        else_btn.addActionListener(btnlistener);
        byte_btn.addActionListener(btnlistener);
        short_btn.addActionListener(btnlistener);
        char_btn.addActionListener(btnlistener);
        long_btn.addActionListener(btnlistener);
        float_btn.addActionListener(btnlistener);
        double_btn.addActionListener(btnlistener);
        switch_btn.addActionListener(btnlistener);
        case_btn.addActionListener(btnlistener);
        break_btn.addActionListener(btnlistener);
        while_btn.addActionListener(btnlistener);*/
    }

    protected String Question(int n) // 題目設定
    {
        String questionStr = "";
        switch(n)
        {
            case 1:
                questionStr = "題目一：請試著做出Hello World";
                break;
            case 2:
                questionStr = "題目二：請試著做出加減法";
                break;
        }
        return questionStr;
    }
}