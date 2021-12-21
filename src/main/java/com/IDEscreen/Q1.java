package com.IDEscreen;
import javax.swing.*;

public class Q1 extends BasicWindow
{

    public Q1()
    {
        System.out.println("Q1");
        QuestionN = 1;
        Questionlbl = new JLabel(Question(QuestionN));
        right.add(Questionlbl);
    }
}
