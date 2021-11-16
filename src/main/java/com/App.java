package com;
import java.io.IOException;
import com.structure.position;
//import com.Window.*;
import com.structure.puzzle;
import com.structure.puzzleStructure;
import com.structure.test;

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
        puzzleStructure[] puz = new puzzleStructure[2];
        puzzle puzzle = new puzzle();
        for(int i = 0 ; i < puz.length ; i++)
        {
            puz[i] = new puzzleStructure();
        }
        /*
        puz[0].set("30.1", 
        new position(1,1), 
        new position(1, 10), 
        "int", 
        "shlu");
        
        puz[1].set("20.1", 
        new position(0,0), 
        new position(0, 11), 
        "",
        "shlu");
        */
        puz=new test().get();
        puzzle.generation(puz);
        /*
        compiler abc=new compiler();
        
        abc.file_path="C:/Users/User/Desktop/1/";
        abc.filename="test.java";
        abc.p();
        System.out.println("Hello World!");
        */
        /*
        new Window(); // new 出Windows(已經繼承了Frame)
        */
    
    }
}
