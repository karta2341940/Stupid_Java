package com.IDEscreen;

import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class DragObjectListener implements MouseInputListener {

    Point p = new Point(0, 0); // 座標p

    public void mouseMoved(MouseEvent e) {}

    public void mouseDragged(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            MovePanel jl = (MovePanel) e.getSource();
            Point newP = SwingUtilities.convertPoint(jl, e.getPoint(), jl.getParent()); // 轉換座標
            jl.setLocation(jl.getX() + (newP.x - p.x), jl.getY() + (newP.y - p.y)); // 設定物件到新位置
            p = newP; // 更改座標點
            System.out.println(jl.MPpuzzleStructAL.indexOf(jl.tempPuzzleStructure));
            if(jl.getX()<-150)
            {
                jl.MPpuzzleStructAL.remove(jl.MPpuzzleStructAL.indexOf(jl.tempPuzzleStructure));
                jl.MPpuzzleAL.remove(jl.MPpuzzleAL.indexOf(jl.tempPuzzle));
                jl.getParent().remove(jl);
                
            }
        }
    }

    public void mouseReleased(MouseEvent e) 
    {

    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
        
        //((MovePanel)source).setSelected(false);*/

    }

    public void mouseClicked(MouseEvent e) {
        /*if (SwingUtilities.isLeftMouseButton(e)) {       
            if (e.getClickCount() == 2) {
                Component source = (Component) e.getSource();
                ((MovePanel)source).setSelected(true);
            }
        }*/
    }

    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            Component jl = (Component) e.getSource();
            p = SwingUtilities.convertPoint(jl, e.getPoint(), jl.getParent()); // 取得當前座標
            // jl.getParent().repaint();
            ((JLayeredPane)jl.getParent()).setPosition(jl,0); // 將此面板改成最上層
        }
    }

}
