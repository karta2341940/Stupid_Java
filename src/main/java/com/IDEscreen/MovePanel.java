package com.IDEscreen;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import java.util.ArrayList;
import com.structure.*;

public class MovePanel extends JPanel 
{
    public JTextArea contentTextArea;
    public JTextArea typeTextArea;
    public JTextArea nameTextArea;
    public ArrayList<puzzleStructure> MPpuzzleStructAL;
    public puzzleStructure tempPuzzleStructure;
    public ArrayList<MovePanel> MPpuzzleAL;
    public MovePanel tempPuzzle;
    public MovePanel(String selectedStr, Point burnPoint, int listPOS,ArrayList<puzzleStructure> puzzleStructAL,ArrayList<MovePanel> puzzleAL) // 傳入選擇的拼圖與生成位置
    {
        MPpuzzleStructAL = puzzleStructAL;
        tempPuzzleStructure = puzzleStructAL.get(listPOS);
        MPpuzzleAL = puzzleAL;
        tempPuzzle = this;

        System.out.println("movepanel:" + puzzleStructAL.size());

        this.setBounds(burnPoint.x,burnPoint.y,200,30);
        this.setBackground(Color.white);
        this.setLayout(new FlowLayout(0));
        this.setBorder(new LineBorder(Color.BLACK));
        JLabel jlabel = new JLabel("");
        contentTextArea = new JTextArea("");
        typeTextArea = new JTextArea("");
        nameTextArea = new JTextArea("");
        contentTextArea.setEditable(true);
        typeTextArea.setEditable(true);
        nameTextArea.setEditable(true);
        
        String functionCode = "";
        
        switch(selectedStr) // 根據選擇的拼圖更改不同拼圖的差別
        {
            case "for":
                functionCode = "40";
                jlabel.setText("for");
                this.add(jlabel);
                this.add(contentTextArea);
                break;
            case "print":
                jlabel.setText("print");
                this.add(jlabel);
                this.add(contentTextArea);
                break;
            case "println":
                jlabel.setText("println");
                this.add(jlabel);
                this.add(contentTextArea);
                break;
            case "public_class":
                functionCode = "20.1";
                jlabel.setText("public class");
                this.add(jlabel);
                this.add(contentTextArea);
                break;
            case "public_static_void":
                jlabel.setText("public static void");
                this.add(jlabel);
                this.add(contentTextArea);
                break;
            case "int":
                functionCode = "12";
                jlabel.setText("int");
                this.add(jlabel);
                this.add(contentTextArea);
                break;
            case "  ":
                //jlabel.setText("int");
                //this.add(jlabel);
                this.add(contentTextArea);
                break;
            case "if":
                functionCode = "50";
                jlabel.setText("if");
                this.add(jlabel);
                this.add(contentTextArea);
                break;
            case "elseif":
                functionCode = "70";
                jlabel.setText("else if");
                this.add(jlabel);
                this.add(contentTextArea);
                break;
            case "else":
                functionCode = "60";
                jlabel.setText("else");
                this.add(jlabel);
                //this.add(contentTextArea);
                break; 
            case "byte":
                functionCode = "12";
                jlabel.setText("byte");
                this.add(jlabel);
                //this.add(contentTextArea);
                break;
            case "short":
                functionCode = "12";
                jlabel.setText("short");
                this.add(jlabel);
                //this.add(contentTextArea);
                break;
            case "long":
                functionCode = "12";
                jlabel.setText("long");
                this.add(jlabel);
                //this.add(contentTextArea);
                break;
            case "char":
                functionCode = "12";
                jlabel.setText("char");
                this.add(jlabel);
                //this.add(contentTextArea);
                break;
            case "float":
                functionCode = "12";
                jlabel.setText("float");
                this.add(jlabel);
                //this.add(contentTextArea);
                break;
            case "double":
                functionCode = "12";
                jlabel.setText("double");
                this.add(jlabel);
                //this.add(contentTextArea);
                break;
            case "switch":
                functionCode = "80";
                jlabel.setText("switch");
                this.add(jlabel);
                this.add(contentTextArea);
                break;    
            case "case":
                functionCode = "80.1";
                jlabel.setText("case");
                this.add(jlabel);
                this.add(contentTextArea);
                break;
            case "break":
                jlabel.setText("break");
                this.add(jlabel);
                //this.add(contentTextArea);
                break;
            case "while":
                functionCode = "90";
                jlabel.setText("while");
                this.add(jlabel);
                this.add(contentTextArea);
                break;
            
        }

        puzzleStructAL.get(listPOS).setFunctionCode(functionCode);

        DragObjectListener listener = new DragObjectListener(); // 拖移物件監聽器
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);
        
    }
    /*public void setSelected(boolean flag) {
        selected = flag;
        System.out.println(flag);
    }*/
}
