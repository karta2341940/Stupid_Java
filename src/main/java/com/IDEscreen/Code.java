package com.IDEscreen;

import javax.swing.*;

import com.compiler.io;


public class Code extends JFrame
{
    public Code()
    {
        this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(720, 640);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //this.setLayout(null);

        io ioCode = new io();
        ioCode.file_path = "file\\Test1.txt";
        ioCode.filename = "";
        System.out.print(ioCode.content); 
        String tempStr = ioCode.Reader_();
        JTextArea textArea = new JTextArea(500,500);
        textArea.setText(tempStr);
        textArea.setEditable(true);
        JScrollPane codePanel = new JScrollPane(textArea);
        this.add(codePanel);
    }
}
