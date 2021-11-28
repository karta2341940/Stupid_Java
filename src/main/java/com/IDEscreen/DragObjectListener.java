package com.IDEscreen;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

public class DragObjectListener implements MouseInputListener {

    Point p = new Point(0, 0); // 坐标点

    public DragObjectListener() {

    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        // 如果是左键则做一下操作
        if (SwingUtilities.isLeftMouseButton(e)) {
            Component jl = (Component) e.getSource();
            // 坐标转换
            Point newP = SwingUtilities.convertPoint(jl, e.getPoint(),
                    jl.getParent()); // 转换坐标系统
            jl.setLocation(jl.getX() + (newP.x - p.x), jl.getY()
                    + (newP.y - p.y)); // 设置标签的新位置
            p = newP; // 更改坐标点
            // jl.getParent().repaint();

        } else if (SwingUtilities.isRightMouseButton(e)) {// 右键操作

        } else if (SwingUtilities.isMiddleMouseButton(e)) {// 中键操作，一般鼠标没有

        }
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
        Component source = (Component) e.getSource();
        ((MovePanel)source).setSelected(false);
    }

    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {       
            if (e.getClickCount() == 2) {
                Component source = (Component) e.getSource();
                ((MovePanel)source).setSelected(true);
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            Component jl = (Component) e.getSource();
            p = SwingUtilities.convertPoint(jl, e.getPoint(), jl.getParent()); // 得到当前坐标点
            // jl.getParent().repaint();
        } else if (SwingUtilities.isRightMouseButton(e)) {// 右键操作

        } else if (SwingUtilities.isMiddleMouseButton(e)) {// 中键操作，一般鼠标没有

        }
    }

}
