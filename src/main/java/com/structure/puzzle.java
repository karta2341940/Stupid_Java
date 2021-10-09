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
     * case     =>        1
     * default  =>        2
     * while    =>      900
     * new      =>      110 
     * 變數     =>      120
     * byte     =>        1
     * short    =>        2
     * int      =>        3
     * long     =>        4
     * float    =>        5
     * double   =>        6
     * char     =>        7
     * boolean  =>        8
     * String   =>        9 
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
            String[] funCode = target[b].functionCode.split(".");
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
                
                case "60":  //else
                
                outString[target[b].Head.y]+= "else{" ;
                outString[target[b].Tail.y]+= "}" ;
                break;
                
                case "70":  //else if
                
                outString[target[b].Head.y] += "else if(" + Content + "){" ;
                outString[target[b].Tail.y] += "}" ;
                break;
                
                case "80":  //switch
                
                switch(funCode[1])
                {
                    case "0" :  // switch本體
                    outString[target[b].Head.y] += "switch(" + Content + "){" ;
                    outString[target[b].Tail.y] += "}" ;
                    break;

                    case "1" :  // cace(含break)
                    outString[target[b].Head.y] += "case(" + Content + ")" ;
                    outString[target[b].Tail.y] += "break;" ;
                    break;

                    case "2":  // default(含break)
                    outString[target[b].Head.y] += "default:" + Content + "){" ;
                    outString[target[b].Tail.y] += "break;" ;
                    break;
                }

                case "90":  //  while
                
                outString[target[b].Head.y] += "while(" + Content + "){" ;
                outString[target[b].Tail.y] += "}" ;
                break;
                
                case "11":  //  new (__=new __;)
                
                outString[target[b].Head.y] += Content + "=new" + Content + ";" ;
                break;

                case "12":  // 變數
                switch(funCode[1])
                {
                    case "1":  // byte
                    outString[target[b].Head.y] += "byte" +  Content + ";";
                    break;
                    
                    case "2":  // short
                    outString[target[b].Head.y] += "short" +  Content + ";";
                    break;

                    case "3":  //  int
                    outString[target[b].Head.y] += "int" +  Content + ";";
                    break;

                    case "4":  //  long
                    outString[target[b].Head.y] += "long" +  Content + ";";
                    break;

                    case "5":  //  float
                    outString[target[b].Head.y] += "float" +  Content + ";";
                    break;
                    
                    case "6":  //  double
                    outString[target[b].Head.y] += "double" +  Content + ";";
                    break;

                    case "7":  //  char
                    outString[target[b].Head.y] += "char" +  Content + ";";
                    break;

                    case "8":  //  boolean
                    outString[target[b].Head.y] += "boolean" +  Content + ";";
                    break;

                    case "9":  //  String
                    outString[target[b].Head.y] += "String" +  Content + ";";
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
