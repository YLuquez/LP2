import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;
import figures.Triangle;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1, r2;
    Ellipse e1, e2;
    Triangle p1, p2;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("LP2 - 2.3.1");
        this.setSize(350, 350);
        this.r1 = new Rect(155,	236, 46, 120);
        this.r2 = new Rect(169, 48,	81, 57);
        this.e1 = new Ellipse(21, 165, 37, 100);
        this.e2 = new Ellipse(77, 221, 63,	 35);
        this.p1 = new Triangle(new int[] {15, 180, 245}, new int[] {100, 40, 100}, 3);
        this.p2 = new Triangle(new int[] {44, 193, 150}, new int[] {300, 90, 300}, 3);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.p1.paint(g);
        this.p2.paint(g);
    }
}