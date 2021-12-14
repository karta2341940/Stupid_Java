package com.IDEscreen;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;

public class MovePanel extends JPanel {
    /*private boolean selected;
    private int positionX = 0, positionY = 0;
    private Point prevPressedPoint;*/

    MovePanel(String selectedStr, Point burnPoint) {
        this.setBounds(burnPoint.x,burnPoint.y,100,100);
        this.setBackground(Color.yellow);
        JTextArea textarea = new JTextArea("");
        JLabel jlabel = new JLabel("");
        textarea.setEditable(true);
        
        switch(selectedStr)
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
        }
        DragObjectListener listener = new DragObjectListener();
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);
    }
    public void setSelected(boolean flag) {
        /*selected = flag;
        System.out.println(flag);*/
    }
}
