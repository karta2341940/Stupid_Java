package com.stupid;

import com.Window.*;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;
import com.menu.menu;
import com.IDEscreen.*;
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
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        UIManager.put( "Button.arc" , 10 );
        System.out.println("Hello World!");

        //new Window(); // new 出Windows(已經繼承了Frame)
        new menu();
        new test();
    }
}
