package com;
import java.io.IOException;

import com.compiler.*;
//import com.Window.*;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }
    
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     * @throws IOException
     */
    
    public static void main(String[] args) throws IOException {

        compiler abc=new compiler();
        
        abc.file_path="C:/Users/User/Desktop/1/";
        abc.filename="test.java";
        abc.p();
        System.out.println("Hello World!");
        /*
        new Window(); // new 出Windows(已經繼承了Frame)
        */
    
    }
}
