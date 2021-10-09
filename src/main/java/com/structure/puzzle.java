package com.structure;
import javax.swing.text.Position;

import com.compiler.io;

public class puzzle {

    public String functionCode="";
    public Position Head;//紀錄頭座標
    public String Content="";
    public Position Tail; //紀錄尾座標(有變動時要更新)
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
     * while    =>      900
     * new      =>      110
     * 變數     =>      120
     */
    
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
                
                io.content=target[b].Content;
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
