package com.structure;

import com.compiler.io;

public class puzzle {

    int s;
    String outString[];
    public String functionCode="";
    public position Head;//紀錄頭座標
    public String Content="";
    public position Tail; //紀錄尾座標(有變動時要更新)
    //for 變數
    public String type="";//變數，function共用
    public String varName="";//變數，function共用
    /**
     * public   =>      1
     * private  =>      2
     * protect  =>      3
     * public class =>  201
     * 
     * 字串拼圖 =>      000
     * import   =>      100
     * class    =>      200
     * function =>      300
     * for      =>      400
     * if       =>      500
     * 
     * else     =>      600
     * else if  =>      700
     * switch   =>      800
     * case     =>      801
     * default  =>      802
     * while    =>      900
     * new      =>      110 
     * 變數     =>      120
     * byte     =>      121
     * short    =>      122
     * int      =>      123
     * long     =>      124
     * float    =>      125
     * double   =>      126
     * char     =>      127
     * boolean  =>      128
     * String   =>      129 
     */
    public void readLineNumber(puzzle[] target)
    {
        int LineNum = target.length;
        outString=new String[LineNum];
    }
    public void generation(puzzle[] target)
    {
        //puzzle tt = new puzzle();
        io io = new io();
        int b = 0;
        while( b < target.length)
        {
            switch(target[b].functionCode.substring(0,1))
            {
                case "00"://字串拼圖
                
                io.content=""+target[b].Content;
                io.Writer_();
                break;
                
                case "10":
                
                break;
                
                case "20":
                
                break;
                
                case "30":
                
                break;
                
                case "40":
                
                break;
                
                case "50":
                
                break;
                
                case "60":
                
                outString[Head.y]+= "else{" ;
                outString[Tail.y]+= "}" ;
                break;
                
                case "70":
                
                outString[Head.y] += "else if(" + Content + "){" ;
                outString[Tail.y] += "}" ;
                break;
                
                case "80":
                
                switch(target[b].functionCode.substring(2))
                {
                    case "0" :
                    outString[Head.y] += "switch(" + Content + "){" ;
                    outString[Tail.y] += "}" ;
                    break;

                    case "1" :
                    outString[Head.y] += "case(" + Content + ")" ;
                    outString[Tail.y] += "break;" ;
                    break;

                    case "2":
                    outString[Head.y] += "default:" + Content + "){" ;
                    outString[Tail.y] += "break;" ;
                    break;
                }

                case "90":
                
                outString[Head.y] += "while(" + Content + "){" ;
                outString[Tail.y] += "}" ;
                break;
                
                case "11":
                
                outString[Head.y] += Content + "=new" + Content + ";" ;
                break;

                case "12":
                switch(target[b].functionCode.substring(2))
                {
                    case "1":
                    outString[Head.y] += "byte" +  Content + ";";
                    break;
                    
                    case "2":
                    outString[Head.y] += "short" +  Content + ";";
                    break;

                    case "3":
                    outString[Head.y] += "int" +  Content + ";";
                    break;

                    case "4":
                    outString[Head.y] += "long" +  Content + ";";
                    break;

                    case "5":
                    outString[Head.y] += "float" +  Content + ";";
                    break;
                    
                    case "6":
                    outString[Head.y] += "double" +  Content + ";";
                    break;

                    case "7":
                    outString[Head.y] += "char" +  Content + ";";
                    break;

                    case "8":
                    outString[Head.y] += "boolean" +  Content + ";";
                    break;

                    case "9":
                    outString[Head.y] += "String" +  Content + ";";
                    break;
                }
                
                break;
            }
            b++;
        }
    }
}



class abcde
{
    puzzle puzzle = new puzzle();
    void asd()
    {

        //4545554
        
        switch(puzzle.functionCode)
        {
            case "0"://頭座標
            //genclass();
            break;//尾座標
            case "1":
            //genvar();
            break;
        }
        
    }

}
