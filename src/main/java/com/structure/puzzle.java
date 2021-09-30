package com.structure;
import javax.swing.text.Position;

public class puzzle {
    public int functionCode=0;
    public Position Head;//紀錄頭座標
    public String Condition="";
    public Position Tail; //紀錄尾座標(有變動時要更新)
    //for 變數
    public String type="";
    public String varName="";
    
}
class abcde
{
    puzzle puzzle = new puzzle();
    void asd()
    {
        
        switch(puzzle.functionCode)
        {
            case 0:
            //genclass();
            break;
            case 1:
            //genvar();
            break;
        }

    }
}
/*  
class   0
int     1












*/