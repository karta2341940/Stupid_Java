package com.compiler;
import javax.tools.*;
import java.io.*;

public class compiler 
{
    public String file_path; // 檔案位置
    public String filename; // 檔名

    public compiler()throws IOException
    {
        
        
    }
    public void p()throws IOException
    {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        int results = compiler.run(null, null, null, file_path + filename);

        System.out.println((results == 0)?"編譯成功":"編譯失敗");

        // 在程式中執行test

        Runtime run = Runtime.getRuntime();

        Process p = run.exec("java " + file_path + filename);

        BufferedInputStream in = new BufferedInputStream(p.getInputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String s;

        while ((s = br.readLine()) != null)

        System.out.println(s);
    }


}


