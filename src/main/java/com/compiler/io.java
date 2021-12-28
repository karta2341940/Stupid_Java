package com.compiler;
import java.io.*;


public class io {

    public String file_path="./file/"; // 檔案位置
    public String read_content=""; //讀取的內容
    public String filename; // 檔名
    public String content;  //要寫入的內容
    public String get_path ="";

    
    public io()
    {
    }
    public String Reader_ ()
    {
        try
        {
            FileReader fileReader = new FileReader(file_path + filename);
            BufferedReader bReader = new BufferedReader(fileReader);
            String content = "";

            System.out.println("-------Read file is Starting--------");
            while(bReader.ready())
            {
                content = bReader.readLine();
                read_content += content+"\n";
                System.out.println(content);
            }
            fileReader.close();
            System.out.println("-------End--------");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return read_content;
    }
    /**
     * 
     */
    public void Writer_()
    {
        
        try 
        {
            FileWriter fWriter = new FileWriter(file_path + filename);
            fWriter.write(content);
            fWriter.flush();
            fWriter.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    public void Show_read_content()
    {
        System.out.println(read_content);
    }
    
    public void File_maker()
    {
        File fileDir = new File(file_path);
        if( !fileDir.isDirectory() )
        {
            fileDir.mkdir();//建立資料夾
        }
        File file =new File(fileDir, filename);
        if(!file.isFile())
        {
            try 
            {
                file.createNewFile();    
            }
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
        get_path =file.getPath();
    }
}
