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
        linker link = new linker();
        link.filename="Test1.txt";
        link.File_maker();
        link.Reader_();
        link.content="Hello \n th   is is a test2 txt \nworld";
        link.Writer_();
        link.Reader_();
        
    }
}
