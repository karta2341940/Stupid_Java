package com.IDEscreen;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.geom.*;
import java.awt.*;   
import java.awt.event.*;

public class MovePanel extends JPanel 
{
    MovePanel(String selectedStr, Point burnPoint) // 傳入選擇的拼圖與生成位置
    {
        this.setBounds(burnPoint.x,burnPoint.y,100,100);
        this.setBackground(Color.ORANGE);
        JTextArea textarea = new JTextArea("");
        JLabel jlabel = new JLabel("");
        textarea.setEditable(true);
        
        switch(selectedStr) // 根據選擇的拼圖更改不同拼圖的差別
        {
            case "for":
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
                jlabel.setText("public class");
                this.add(jlabel);
                this.add(textarea);
                break;
            case "public_static_void":
                jlabel.setText("public static void");
                this.add(jlabel);
                this.add(textarea);
                break;
            case "private_class":
                jlabel.setText("private class ");
                this.add(jlabel);
                this.add(textarea);
                break;
            case "protect_class":
                jlabel.setText("protect class");
                this.add(jlabel);
                this.add(textarea);
                break;
            case "int":
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
            case "import":
                jlabel.setText("import");
                this.add(jlabel);
                this.add(textarea);
                break;
            
        }
        DragObjectListener listener = new DragObjectListener(); // 拖移物件監聽器
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);
    }
    /*public void setSelected(boolean flag) {
        selected = flag;
        System.out.println(flag);
    }*/
}
