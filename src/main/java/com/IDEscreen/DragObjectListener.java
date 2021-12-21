package com.IDEscreen;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

public class DragObjectListener implements MouseInputListener {

    Point p = new Point(0, 0); // 座標p

    public void mouseMoved(MouseEvent e) {}

    public void mouseDragged(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            Component jl = (Component) e.getSource();
            Point newP = SwingUtilities.convertPoint(jl, e.getPoint(), jl.getParent()); // 轉換座標
            jl.setLocation(jl.getX() + (newP.x - p.x), jl.getY() + (newP.y - p.y)); // 設定物件到新位置
            p = newP; // 更改座標點
        }
    }

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
        /*Component source = (Component) e.getSource();
        ((MovePanel)source).setSelected(false);*/
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
        }
    }

}
