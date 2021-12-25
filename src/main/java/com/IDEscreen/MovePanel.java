package com.IDEscreen;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import java.util.ArrayList;
import com.structure.*;

public class MovePanel extends JPanel 
{
    Object[] structure = new Object[6];
    public MovePanel(String selectedStr, Point burnPoint, int listPOS,ArrayList<puzzleStructure> puzzleStructAL) // 傳入選擇的拼圖與生成位置
    {
        System.out.println("movepanel:" + puzzleStructAL.size());

        this.setBounds(burnPoint.x,burnPoint.y,200,30);
        this.setBackground(Color.white);
        this.setLayout(new FlowLayout(0));
        this.setBorder(new LineBorder(Color.BLACK));
        JTextArea textarea = new JTextArea("");
        JLabel jlabel = new JLabel("");
        textarea.setEditable(true);

        String functionCode = "";
        position head = new position(this.getX(),this.getY());
        position tail = new position(this.getX(), this.getY()+this.getHeight());
        //System.out.println(this.getX() + "  " + (this.getX()+this.getWidth()));
        String typeStr = "";
        String nameString = "";
        String ContentString = "";
        
        switch(selectedStr) // 根據選擇的拼圖更改不同拼圖的差別
        {
            case "for":
                functionCode = "40";
                jlabel.setText("for");
                this.add(jlabel);
                this.add(textarea);
                break;
            case "print":
                jlabel.setText("print");
                this.add(jlabel);
                this.add(textarea);
                break;
            case "println":
                jlabel.setText("println");
                this.add(jlabel);
                this.add(textarea);
                break;
            case "public_class":
                functionCode = "20.1";
                jlabel.setText("public class");
                this.add(jlabel);
                this.add(textarea);
                break;
            case "public_static_void":
                jlabel.setText("public static void");
                this.add(jlabel);
                this.add(textarea);
                break;
            case "int":
                functionCode = "30.1";
                jlabel.setText("int");
                this.add(jlabel);
                this.add(textarea);
                break;
            case "  ":
                //jlabel.setText("int");
                //this.add(jlabel);
                this.add(textarea);
                break;
            case "if":
                jlabel.setText("if");
                this.add(jlabel);
                this.add(textarea);
                break;
            case "elseif":
                jlabel.setText("else if");
                this.add(jlabel);
                this.add(textarea);
                break;
            case "else":
                jlabel.setText("else");
                this.add(jlabel);
                //this.add(textarea);
                break; 
            case "byte":
                jlabel.setText("byte");
                this.add(jlabel);
                //this.add(textarea);
                break;
            case "short":
                jlabel.setText("short");
                this.add(jlabel);
                //this.add(textarea);
                break;
            case "long":
                jlabel.setText("long");
                this.add(jlabel);
                //this.add(textarea);
                break;
            case "char":
                jlabel.setText("char");
                this.add(jlabel);
                //this.add(textarea);
                break;
            case "float":
                jlabel.setText("float");
                this.add(jlabel);
                //this.add(textarea);
                break;
            case "double":
                jlabel.setText("double");
                this.add(jlabel);
                //this.add(textarea);
                break;
            case "switch":
                jlabel.setText("switch");
                this.add(jlabel);
                this.add(textarea);
                break;    
            case "case":
                jlabel.setText("case");
                this.add(jlabel);
                this.add(textarea);
                break;
            case "break":
                jlabel.setText("break");
                this.add(jlabel);
                //this.add(textarea);
                break;
            case "while":
                jlabel.setText("while");
                this.add(jlabel);
                this.add(textarea);
                break;
            
        }

        puzzleStructAL.get(listPOS).set(functionCode, head, tail, typeStr, nameString, textarea.getText());

        DragObjectListener listener = new DragObjectListener(); // 拖移物件監聽器
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);
        
    }
    /*public void setSelected(boolean flag) {
        selected = flag;
        System.out.println(flag);
    }*/
}
