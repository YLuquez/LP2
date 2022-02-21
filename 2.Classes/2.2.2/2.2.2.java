import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class EllipseApp {
    public static void main (String[] args) {
        EllipseFrame frame = new EllipseFrame();
        frame.setVisible(true);
    }
}

class EllipseFrame extends JFrame {
    Ellipse e1;
    Ellipse e2;
    Ellipse e3;
    Ellipse e4;

    EllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("LP2 - 2.2.2");
        this.setSize(500, 500);
        this.e1 = new Ellipse(100,50, 250,40);
        this.e2 = new Ellipse(50,90, 80,90);
        this.e3 = new Ellipse(190,190, 90,160);
        this.e4 = new Ellipse(120,240, 90,80);
        this.getContentPane().setBackground(Color.black);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint2(g);
        this.e3.paint3(g);
        this.e4.paint4(g);
    }
}

class Ellipse {
    int x, y;
    int w, h;

    Ellipse (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(new Color(145, 218, 0));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.orange);
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }  

    void paint2 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(new Color(48, 156, 168));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.white);
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }
        
    void paint3 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
            
        g.setColor(new Color(238, 255, 0));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.magenta);
        g2d.drawOval(this.x,this.y, this.w,this.h);    
    }

    void paint4 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
            
        g.setColor(new Color(118, 112, 185));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.red);
        g2d.drawOval(this.x,this.y, this.w,this.h);    
    }

}
