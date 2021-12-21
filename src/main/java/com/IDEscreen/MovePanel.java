package com.IDEscreen;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.geom.*;
import java.awt.*;   
import java.awt.event.*;

public class MovePanel extends JPanel {
    private boolean selected;
    private int positionX = 0, positionY = 0;
    private Point prevPressedPoint;

    MovePanel() {
        this.setBounds(300,300,100,100);
        this.setBackground(Color.yellow);
        LineBorder blackline = new LineBorder(Color.red);
        this.setBorder(blackline);
        JTextArea textarea = new JTextArea("TextArea");
        textarea.setEditable(true);
        this.add(textarea);
        DragObjectListener listener = new DragObjectListener();
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);
    }
    public void setSelected(boolean flag) {
        selected = flag;
        System.out.println(flag);
    }
}
