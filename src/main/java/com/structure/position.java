package com.structure;

public class position {
    public int x;
    public int y;
    public position()
    {
        x=0;
        y=0;
    }
    public position(int X,int Y)
    {
        x=X;
        y=Y;
    }
    public position set (int X,int Y)
    {
        return new position(X,Y);
    }
}
