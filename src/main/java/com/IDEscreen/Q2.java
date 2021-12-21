package com.IDEscreen;
import javax.swing.*;

public class Q2 extends BasicWindow
{
    public Q2()
    {
        System.out.println("Q2");
        QuestionN = 2;
        Questionlbl = new JLabel(Question(QuestionN));
        right.add(Questionlbl);
    }
}
