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
        this.setBounds(200,56,595,480);
        LineBorder blackline = new LineBorder(Color.BLACK);
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