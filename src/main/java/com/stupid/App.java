package com.stupid;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;

//import com.Window.*;

import com.menu.menu;
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
        // UI使用FlatDarkLaf主題
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        UIManager.put( "ScrollBar.trackArc", 999 );
        UIManager.put( "ScrollBar.thumbArc", 999 );

        //new compiler();
        UIManager.put( "Button.arc" , 10 ); // 按鈕圓角弧度
        new menu();
    }
}
