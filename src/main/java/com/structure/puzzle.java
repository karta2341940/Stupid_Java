package com.structure;

import com.compiler.io;


public class puzzle {

    int s;
    String outString[];
    public String functionCode="";
    public position Head;//紀錄頭座標
    public String Content="";//if(content),字串拼圖內容,import的內容
    public position Tail; //紀錄尾座標(有變動時要更新)
    //for 變數,class,function
    public String varName="";//變數，function,class共用
    /**
     * public   =>      1
     * private  =>      2
     * protect  =>      3
     * public class =>  201
     * 
     * 字串拼圖 =>      000
     * import   =>      100
     * class    =>      200
     * function =>      30.0.0 ( functioncode . [public,private...] . type[int,string...] )
     * // public void exampleFunction =>30.1.a
     *-public   =>      1
     *-private  =>      2
     *-protect  =>      3
     *-default  =>      2

     *---byte   =>      1
     *---short  =>      2
     *---int    =>      3
     *---long   =>      4
     *---float  =>      5
     *---double =>      6
     *---char   =>      7
     *---boolean=>      8
     *---String =>      9
     *---void   =>      a

     * for      =>      400
     * if       =>      500
     * 
     * else     =>      600
     * else if  =>      700
     * switch   =>      800
     * case     =>      1  (有包覆的拼圖(跟break一組))
     * default  =>      2  (有包覆的拼圖(跟break一組))
     * while    =>      900
     * new      =>      110
     * 
     * 變數     =>      120 (如果是int a => 120.3 )
     * byte     =>      1
     * short    =>      2
     * int      =>      3
     * long     =>      4
     * float    =>      5
     * double   =>      6
     * char     =>      7
     * boolean  =>      8
     * String   =>      9
     * 
     */
    public void readLineNumber(puzzle[] target)
    {
        int LineNum = target.length;
        outString=new String[LineNum];
    }
    public void generation(puzzle[] target)
    {
        io io = new io();
        int b = 0;
        while( b < target.length)
        {
            String[] funCode = target[b].functionCode.split(".");
            switch(funCode[0])
            {

                case "00"://字串拼圖
                    outString[target[b].Head.y]+=target[b].Content+";";
                break;
                
                case "10"://import
                    outString[target[b].Head.y]+="import "+target[b].Content+";";
                break;
                
                case "20"://class

                    
                    switch(funCode[1])//判別public , private , protect
                    {
                        case "0":
                            outString[target[b].Head.y]+="private "+target[b].varName+"{";
                        break;

                        case "1":
                            outString[target[b].Head.y]+="public "+target[b].varName+"{";
                        break;
                        
                        case "2":
                            outString[target[b].Head.y]+="private "+target[b].varName+"{";
                        break;
                        
                        case "3":
                            outString[target[b].Head.y]+="protect "+target[b].varName+"{";
                        break;

                        default:
                            outString[target[b].Head.y]+="private "+target[b].varName+"{";
                        break;
                    }
                    
                    outString[target[b].Tail.y]+="};";

                break;
                
                case "30"://function

                    switch(funCode[1])//判別public , private , protect
                    {
                        case "0":
                            outString[target[b].Head.y]+="private ";
                        break;

                        case "1":
                            outString[target[b].Head.y]+="public ";
                        break;
                        
                        case "2":
                            outString[target[b].Head.y]+="private ";
                        break;
                        
                        case "3":
                            outString[target[b].Head.y]+="protect ";
                        break;

                        default:
                            outString[target[b].Head.y]+="private ";
                        break;
                    }
                    switch(funCode[2])//判斷type
                    {
                        case "1":
                            outString[target[b].Head.y]+="byte ";
                        break;
                        
                        case "2":
                            outString[target[b].Head.y]+="short ";
                        break;
                        
                        case "3":
                            outString[target[b].Head.y]+="int ";
                        break;
                        
                        case "4":
                            outString[target[b].Head.y]+="long ";
                        break;
                        
                        case "5":
                            outString[target[b].Head.y]+="float ";
                        break;
                        
                        case "6":
                            outString[target[b].Head.y]+="double ";
                        break;
                        
                        case "7":
                            outString[target[b].Head.y]+="char ";
                        break;
                        
                        case "8":
                            outString[target[b].Head.y]+="boolean ";
                        break;
                        
                        case "9":
                            outString[target[b].Head.y]+="String ";
                        break;
                        
                        case "a":
                            outString[target[b].Head.y]+="void ";
                        break;
                    }
                    outString[target[b].Head.y]+="("+target[b].Content+")"+"{";
                    outString[target[b].Tail.y]+="}";
                break;
                
                case "40"://for
                    outString[target[b].Head.y]+="for("+target[b].Content+"){";
                    outString[target[b].Tail.y]+="}";
                break;
                
                case "50"://if
                    outString[target[b].Head.y]+="if("+target[b].Content+"){";
                    outString[target[b].Tail.y]+="}";
                break;
                
                case "60":
                
                break;
                
                case "70":
                
                break;
                
                case "80":
                
                break;
                
                case "90":
                
                break;
                
                case "11":
                
                break;
                case "12":
                
                break;
            }
            b++;
        }
    }
}
