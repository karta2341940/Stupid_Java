package com.compiler;


public class compiler 
{
    public compiler()
    {
        System.out.println("Hello");    
        String directoryName = System.getProperty("user.dir");
		System.out.println("Current Working Directory is = " +directoryName);
        /*
        */
        io link = new io();
        link.filename="Test1.txt";
        link.File_maker();
        link.Reader_();
        link.content="Hello world";
        link.Writer_();
        link.Reader_();
        System.out.println(link.get_path);
        
    }
}
