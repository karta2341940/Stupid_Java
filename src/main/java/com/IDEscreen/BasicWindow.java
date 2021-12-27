package com.IDEscreen;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import com.structure.*;


public class BasicWindow extends JFrame
{
    public int QuestionN;

    private JPanel lefts;
    private JScrollPane leftScroll;
    private JPanel up;
    protected JPanel right;
    public JLayeredPane middle;
    private JPanel down;

    private JButton Compile_btn;
    private JButton View_btn;
    //protected String CodeStr="<html><head></head><body><p>public class HelloWorld{</p><br/><p>public static main(){</p><br/><p>System.out.println(\"Hello World\");</p><p>}<br>}</p> </body></html>";
    protected JLabel Questionlbl;
    private JLabel resultlbl;

    protected ImageIcon icon;

    ArrayList<MovePanel> puzzleAL = new ArrayList<MovePanel>();
    ArrayList<puzzleStructure> puzzleStructAL = new ArrayList<puzzleStructure>();

    private String selectedStr = "";
    private JButton tempButton = null;

    int size = 0;

    public BasicWindow()
    {
        // 設定ide基本視窗
        this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
        

        up = new JPanel();
        up.setLayout(new FlowLayout(FlowLayout.LEFT));
        up.setBackground(Color.GRAY);
        up.setBounds(0,0,1280,50);
        Compile_btn = new JButton("Compile");
        Compile_btn.setPreferredSize(new Dimension(140, 30));
        View_btn = new JButton("View Code");
        View_btn.setPreferredSize(new Dimension(140, 30));
        ActionListener upbtnlistener = new ActionListener() { // 按鈕監聽器
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JButton source = (JButton)e.getSource();
                if(source==Compile_btn)
                { 
                    puzzleStructure[] temp = new puzzleStructure[puzzleStructAL.size()];
                    for(int i=0;i<puzzleStructAL.size();i++)
                    {
                        position head = new position(puzzleAL.get(i).getX(),puzzleAL.get(i).getY());
                        position tail = new position(puzzleAL.get(i).getX(),puzzleAL.get(i).getY()+puzzleAL.get(i).getHeight());
                        String type = puzzleAL.get(i).typeTextArea.getText();
                        String name = puzzleAL.get(i).nameTextArea.getText();
                        String content = puzzleAL.get(i).contentTextArea.getText();
                        puzzleStructAL.get(i).set(head, tail, type, name, content);
                        
                        temp[i] = puzzleStructAL.get(i);
                    }
                    puzzle testPuzzle = new puzzle();
                    testPuzzle.generation(temp);
                }
                else if(source==View_btn)
                {
                    new Code();
                }
            }
        };
        Compile_btn.addActionListener(upbtnlistener);
        View_btn.addActionListener(upbtnlistener);
        up.add(Compile_btn);
        up.add(View_btn);

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
                    puzzleStructure pzs = new puzzleStructure();
                    puzzleStructAL.add(pzs);
                    System.out.println("index: " + puzzleStructAL.indexOf(pzs));
                    MovePanel movePanel = new MovePanel(selectedStr, e.getPoint(), puzzleStructAL.indexOf(pzs), puzzleStructAL, puzzleAL);
                    puzzleAL.add(movePanel); // 新增拼圖到ArrayList  
                    middle.add(movePanel);
                    System.out.println("puzzle amount:" + puzzleAL.size() + " " + puzzleStructAL.size());
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

        this.add(up);
        this.add(leftScroll);
        this.add(middle);
        this.add(right);
        this.add(down);
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
    }
//Push test
    protected String Question(int n) // 題目設定
    {
        String questionStr = "";
        switch(n)
        {
            case 1:
                questionStr = "題目一 : 請試著做出Hello World";
                break;
            case 2:
                questionStr = "題目二 : 請試著做出加減法";
                break;
        }
        return questionStr;
    }
}