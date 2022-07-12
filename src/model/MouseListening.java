package model;

import view.gui.GuiWindow;
import view.gui.PaintCanvas;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.MouseListener;

public class MouseListening extends PaintCanvas implements MouseListener {
    PaintCanvas canvas;
    public MouseListening(PaintCanvas canvas) {
        this.canvas = canvas;
    }

    /*
        MouseListening() {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(500, 500);
            this.setLayout(null);

            label = new JLabel();
            label.setBounds(0, 0, 100, 100);
            label.setBackground(Color.red);
            label.setOpaque(true);
            label.addMouseListener(this);

            this.add(label);
            this.setVisible(true);
        }
        */
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("You clicked the mouse");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
