package com.structure;

import com.compiler.io;

public class puzzle {

    int s;
    String outString[];
    /**
     * 
     */
    public String functionCode="";
    /**
     * 
     */
    public position Head;//紀錄頭座標
    /**
     * 
     */
    public String Content="";//if(content),字串拼圖內容,import的內容
    /**
     * 
     */
    public position Tail; //紀錄尾座標(有變動時要更新)
    //for 變數,class,function
    /**
     * 
     */
    public String varName="";//變數，function,class共用
    /**
     * public   =>      1
     * private  =>      2
     * protect  =>      3
     * public class =>  201
     * 
     * 字串拼圖 =>      00
     * import   =>      10
     * class    =>      20
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

     * for      =>      40
     * if       =>      50
     * 
     * else     =>      60
     * else if  =>      70
     * switch   =>      80
     * case     =>      1  (有包覆的拼圖(跟break一組))
     * default  =>      2  (有包覆的拼圖(跟break一組))
     * while    =>      90
     * new      =>      11
     * 
     * 變數     =>      12 (如果是int a => 120.3 )
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

    /**
     * 讀取陣列行數並產生出相對應的
     */
    void readLineNumber(puzzleStructure[] target)
    {
        int LineNum=0;
        
        int x= 0;
        int temp=0;
        while(target.length > x )
        {
            if( target[x].Tail.y > temp )
            {
                LineNum = target[x].Tail.y;
            }
           
            x++;
        }
        outString = new String[LineNum+1];
        for(int i = 0 ; i < outString.length ; i++)
        {
            outString[i]= "";
        }
        show("The line of outString is "+LineNum);
    }
    public void generation(puzzleStructure[] target)
    {
        readLineNumber(target);
        int b = 0;
        while( b < target.length)
        {
            
            String[]funCode = target[b].functionCode.split("\\.");

            switch(funCode[0])
            {

                case "00"://字串拼圖
                    outString[target[b].Head.y]+=target[b].Content+";";
                break;
                
                case "10"://import
                    outString[target[b].Head.y]+="import "+target[b].Content+";";
                break;
                
                case "20"://class

                    if( target[b].Head.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Head.x ; i++)
                        outString[target[b].Head.y]+="\t";
                    }
                    if( target[b].Tail.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Tail.x ; i++)
                        outString[target[b].Tail.y]+="\t";
                    }
                    switch(funCode[1])//判別public , private , protect
                    {
                        case "0":
                            outString[target[b].Head.y]+="private class "+target[b].varName.trim()+"{";
                        break;

                        case "1":
                            outString[target[b].Head.y]+="public class "+target[b].varName.trim()+"{";
                        break;
                        
                        case "2":
                            outString[target[b].Head.y]+="private class "+target[b].varName.trim()+"{";
                        break;
                        
                        case "3":
                            outString[target[b].Head.y]+="protect class "+target[b].varName.trim()+"{";
                        break;

                        default:
                            outString[target[b].Head.y]+="private class "+target[b].varName.trim()+"{";
                        break;
                    }
                    outString[target[b].Tail.y]+="};";

                break;
                
                case "30"://function

                    if( target[b].Head.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Head.x ; i++)
                        outString[target[b].Head.y]+="\t";
                    }
                    if( target[b].Tail.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Tail.x ; i++)
                        outString[target[b].Tail.y]+="\t";
                    }
                    switch(funCode[1])//判別public , private , protect
                    {
                        case "0":
                            outString[target[b].Head.y]+="private ";
                        break;

                        case "1":
                            outString[target[b].Head.y] += "public ";
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
                    outString[target[b].Head.y]+= target[b].varType.trim() +" "+ target[b].varName.trim()+ "("+target[b].Content+")"+"{";
                    outString[target[b].Tail.y]+= "}" ;
                break;
                
                case "40"://for
                    if( target[b].Head.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Head.x ; i++)
                        outString[target[b].Head.y]+="\t";
                    }
                    if( target[b].Tail.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Tail.x ; i++)
                        outString[target[b].Tail.y]+="\t";
                    }
                    outString[target[b].Head.y]+="for("+target[b].Content+"){";
                    outString[target[b].Tail.y]+="}";
                break;
                
                case "50"://if
                    if( target[b].Head.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Head.x ; i++)
                        outString[target[b].Head.y]+="\t";
                    }
                    if( target[b].Tail.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Tail.x ; i++)
                        outString[target[b].Tail.y]+="\t";
                    }
                    outString[target[b].Head.y]+="if("+target[b].Content+"){";
                    outString[target[b].Tail.y]+="}";
                break;
                
                case "60":  //else
                    if( target[b].Head.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Head.x ; i++)
                        outString[target[b].Head.y]+="\t";
                    }
                    if( target[b].Tail.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Tail.x ; i++)
                        outString[target[b].Tail.y]+="\t";
                    }
                    outString[target[b].Head.y]+= "else{" ;
                    outString[target[b].Tail.y]+= "}" ;
                break;
                
                case "70":  //else if

                    if( target[b].Head.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Head.x ; i++)
                        outString[target[b].Head.y]+="\t";
                    }
                    if( target[b].Tail.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Tail.x ; i++)
                        outString[target[b].Tail.y]+="\t";
                    }

                    outString[target[b].Head.y] += "else if(" + target[b].Content + "){" ;
                    outString[target[b].Tail.y] += "}" ;
                break;
                
                case "80":  //switch
                    if( target[b].Head.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Head.x ; i++)
                        outString[target[b].Head.y]+="\t";
                    }
                    if( target[b].Tail.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Tail.x ; i++)
                        outString[target[b].Tail.y]+="\t";
                    }
                    switch(funCode[1])
                    {
                        case "0" :  // switch本體
                        outString[target[b].Head.y] += "switch(" + target[b].Content + "){" ;
                        outString[target[b].Tail.y] += "}" ;
                        break;

                        case "1" :  // case(含break)
                        outString[target[b].Head.y] += "case " + target[b].Content + ":" ;
                        outString[target[b].Tail.y] += "break;" ;
                        break;

                        case "2":  // default(含break)
                        outString[target[b].Head.y] += "default:" ;
                        outString[target[b].Tail.y] += "break;" ;
                        break;
                        
                    }
                break;

                case "90":  //  while
                    if( target[b].Head.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Head.x ; i++)
                        outString[target[b].Head.y]+="\t";
                    }
                    if( target[b].Tail.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Tail.x ; i++)
                        outString[target[b].Tail.y]+="\t";
                    }
                    outString[target[b].Head.y] += "while(" + target[b].Content + "){" ;
                    outString[target[b].Tail.y] += "}" ;
                break;
                
                case "11":  //  new class();
                    if( target[b].Head.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Head.x ; i++)
                        outString[target[b].Head.y]+="\t";
                    }
                    if( target[b].Tail.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Tail.x ; i++)
                        outString[target[b].Tail.y]+="\t";
                    }

                    outString[target[b].Head.y] += "new" + target[b].Content + ";" ;
                break;

                case "12":  // 變數
                    if( target[b].Head.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Head.x ; i++)
                        outString[target[b].Head.y]+="\t";
                    }
                    if( target[b].Tail.x != 0 )
                    {
                        for(int i = 0 ; i < target[b].Tail.x ; i++)
                        outString[target[b].Tail.y]+="\t";
                    }
                    switch(funCode[1])
                    {
                        case "1":
                            outString[target[b].Head.y] +="public ";
                        break;
                        
                        case "2":
                            outString[target[b].Head.y] +="private ";
                        break;
                        
                        case "3":
                            outString[target[b].Head.y] +="protect ";
                        break;
                        default:
                            outString[target[b].Head.y] +="private ";
                        break;
                    }
                    
                    outString[target[b].Head.y] += target[b].varType.trim() +  target[b].varName.trim();

                    switch( funCode[2] )
                    {
                        case "0":
                            outString[target[b].Head.y] +=";";
                        break;
                        case "1":
                            outString[target[b].Head.y] += "="+target[b].Content+";";
                        break;
                        case "2":
                            outString[target[b].Head.y] += " = new "+target[b].Content+";";
                        break;
                    }
                break;
                default:
                break;
            }
            b++;
            
        }
        
        writeCode();
    }

    void writeCode()
    {
        io io = new io();
        io.content="";
        for(int i = 0 ; i < outString.length ; i++)
        {
            io.content +=outString[i]+"\n";
        }
        io.filename="Test1.txt";
        io.Writer_();
    }
    public void show(String text)
    {
        System.out.println(text);
    }
}
