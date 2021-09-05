package com.Window;
import javax.swing.*;
import com.Window.EventHandler.*;


public class Window extends JFrame { // 讓Window繼承Frame
    
    public Window()
    {
        this.addWindowListener(new Window_Handler()); // 指定window Linstener的檔案
        this.setSize(500, 500);
        
        
        
        this.setVisible(true);

    }
    
}
