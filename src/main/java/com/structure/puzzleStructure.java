package com.structure;

public class puzzleStructure {
    public puzzleStructure()
    {   
        functionCode="";
        varName="";
        varType="";
        Head = new position(0, 0);
        Tail = new position(0, 0);
        Content="";
    }
    /**
     * 設定puzzleStructure
     * @param fCode Function code 
     * @param headPosition 頭座標
     * @param tailPosition 尾座標
     * @param StrContent 內容
     * @param varname 變數,class或函數名稱
     * @param vType 變數或函數型態
     */
    public void set(String fCode , position headPosition , position tailPosition,String vType,String varname,String StrContent)
    {
        functionCode = fCode;
        Head = headPosition;
        Tail = tailPosition;
        Content = StrContent;
        varName = varname;
        varType=vType;
    }
    /**
     * 設定puzzleStructure 
     * @param fCode Function code 
     * @param headPosition 頭座標
     * @param tailPosition 尾座標
     * @param vType 變數或函數型態
     * @param varname 變數,class或函數名稱
     */
    public void set(String fCode , position headPosition , position tailPosition,String vType,String varname)
    {
        functionCode = fCode;
        Head = headPosition;
        Tail = tailPosition;
        varName = varname;
        varType=vType;
    }
    /**
     * 設定puzzleStructure for import,字串拼圖
     * @param fCode Function code
     * @param headPosition 頭座標
     * @param tailPosition 尾座標
     * @param StrContent 內容
     */
    public void set(String fCode , position headPosition , position tailPosition,String StrContent)
    {
        functionCode = fCode;
        Head = headPosition;
        Tail = tailPosition;
        Content = StrContent;
    }
    /**
     * <p>這個變數決定印出來的是哪個指令
     * <li>字串拼圖     =>00
     * <li>import       =>10
     * <li>class        =>20
     * <ul>
     * <li>public class =>20.1
     * <li>private class=>20.2
     * <li>protect class=>20.3
     * </ul>
     * <li>function     =>30
     * <li>function指令結構 =>
     * <ul>
     * <li>30.保護層級(註1).static與否(註2)
     * <li>註1:保護層級:
     * <ul>
     * <li>public => 30.1
     * <li>private => 30.2
     * <li>protect =>30.3
     * </ul>
     * <li>註2:如果為1則有為static ,否則0
     * <li><p>註2:</p><ul><li><p>需自行填入函數回傳值型態至varType</p>
     * <p>以及函數名稱至varName</p><ul>
     * </ul>
     * </ul>
     * </ul>
     * <li>for          =>40
     * <li>if           =>50
     * <li>else         =>60
     * <li>else if      =>70
     * <li>switch       =>80
     * <ul>
     * <li> case         =>80.1
     * <li> default      =>80.2
     * </ul>
     * <li>while        =>90
     * <li>new          =>11 
     * <li>變數         =>12
     * <li>變數指令結構 =>
     * <li>12.<b>保護層級(註1)</b>.<b>(註2)</b>
     * <ul>
     * <li>註1:保護層級:
     * <ul
     * <li>public => 1
     * <li>private => 2
     * <li>protect =>3
     * </ul>
     * <li><p>註2:</p><ul><p>如有初始值填1並將初始值輸入 Content，如要建立新物件填2並將建立的物件內容填入content，否則為0。</p><p>範例請看file/example.txt</p></ul>
     * <li>註3:<ul>每個指令間要用 . 隔開</ul>
     * </ul>
     * 
     * <li>以下需自己填
     * <li>byte         
     * <li>short        
     * <li>int          
     * <li>long         
     * <li>float        
     * <li>double       
     * <li>char         
     * <li>boolean      
     * <li>String
     * 
     */
    public String functionCode;
    /**
     * <p>紀錄頭座標position(<b>X,Y</b>)
     */
    public position Head;//紀錄頭座標
    /**
     * <p>儲存內容的字串</p>
     * <li>if ( <b>Content</b> )
     * <li>else if ( <b>Content</b> )
     * <li>字串拼圖的內容
     * <li>import <b>Content</b>
     * <li>int functionNAME ( <b> Content </b> )
     * <li>for ( <b> Content </b> )
     * <li>switch ( <b>Content</b> )
     * <li>case <b>Content</b> :
     * <li>while ( <b>Content</b> )
     * <li>new <b>Content</b>
     * <li>int i = <b>Content</b>
     * <li>Frame f = new <b>Content</b> ( )
     */
    public String Content;//if(content),字串拼圖內容,import的內容
    /**
     * <p>紀錄尾座標position(<b>X,Y</b>)
     */
    public position Tail; //紀錄尾座標(有變動時要更新)
    //for 變數,class,function
    /**
     * 變數,class,function的名字
     */
    public String varName;//變數，function,class共用
    /**
     * 變數或函數的型態
     * <li>其他自訂的型態或
     * <li>byte         
     * <li>short        
     * <li>int          
     * <li>long         
     * <li>float        
     * <li>double       
     * <li>char         
     * <li>boolean      
     * <li>String
     * <li>Object
     * <li>函數需有void的型態
     */
    public String varType;
    
    public void set(position headPosition , position tailPosition, String vType, String varname, String StrContent){
        Head = headPosition;
        Tail = tailPosition;
        varName = varname;
        varType=vType;
        Content = StrContent;
    }
    public void setFunctionCode(String fCode){
        functionCode = fCode;
    }
    public String getFunctionCode(){
        return functionCode;
    }
}
