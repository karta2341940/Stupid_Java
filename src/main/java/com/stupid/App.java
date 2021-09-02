package com.stupid;
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
     */
    public static void main(String[] args) {
        new compiler();
        /*
        System.out.println("Hello World!");
        new Window(); // new 出Windows(已經繼承了Frame)
        */
    
    }
}
