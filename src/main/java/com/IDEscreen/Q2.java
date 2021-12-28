package com.IDEscreen;
import javax.swing.*;
import java.awt.Color;

public class Q2 extends BasicWindow
{
    public Q2()
    {
        System.out.println("Q2");
        QuestionN = 2;
        QuestionTA = new JTextArea(Question(QuestionN));
        QuestionTA.setBackground(Color.gray);
        right.add(QuestionTA);
    }
}
