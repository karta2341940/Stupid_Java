package com.IDEscreen;

import java.awt.Color;

import javax.swing.*;

public class Q1 extends BasicWindow
{

    public Q1()
    {
        System.out.println("Q1");
        QuestionN = 1;
        QuestionTA = new JTextArea(Question(QuestionN));
        QuestionTA.setBackground(Color.gray);
        right.add(QuestionTA);
    }
}
