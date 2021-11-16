package com.structure;



public class test {

    String [] functionCode = {
        "30.1",
        "12.1.0",
        "12.1.0",
        "40",
        "00",
        "50",
        "00",
        "70",
        "00",
        "60",
        "00"
    };
    position[] head = {
        new position(0,0),
        new position(1,1),
        new position(1,2),
        new position(1,3),
        new position(1,4),
        new position(2,5),
        new position(2,6),
        new position(3,7),
        new position(2,9),
        new position(3,10),
        new position(2,12),
        new position(3,13),
    };
    position[] tail ={
        new position(0,15),
        new position(1,1),
        new position(1,2),
        new position(1,3),
        new position(1,14),
        new position(2,5),
        new position(2,8),
        new position(3,7),
        new position(2,11),
        new position(3,10),
        new position(2,14),
        new position(1,13)
    };
    String [] typeStr = {
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    };
    String [] nameString = {
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    };
    String [] ContentString = {
        "",
        "",
        "",
        "",
        "i= 0; i <10 ; i++ ",
        "a++;",
        "a == i",
        "println(\"\"+a);",
        "",
        "printfln(a+\"?\");"
    };
    
    puzzleStructure[] pzs = new puzzleStructure[15];

    public test()
    {
        for(int i = 0 ; i < pzs.length ; i ++ )
        {
            pzs[i]= new puzzleStructure();
        }
        run ();
    }
    void run ()
    {
        for(int i = 0 ; i < pzs.length ; i ++ )
        {
            pzs[i].set(functionCode[i], head[i], tail[i], typeStr[i], nameString[i], ContentString[i]); 
        }
    }
    public puzzleStructure[] get()
    {
        return pzs;
    }
    
}
