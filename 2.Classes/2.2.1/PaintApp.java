import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}
class PaintFrame extends JFrame {
    Rect r1;
    Rect r2;
    Rect r3;
    Rect r4;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("LP2 - 2.2.1");
        this.setSize(500, 500);
        this.r1 = new Rect(50,50, 100,250);
        this.r2 = new Rect(100,200, 150,200);
        this.r3 = new Rect(150,250, 200,150);
        this.r4 = new Rect(240,120, 250,100);
        this.getContentPane().setBackground(Color.PINK);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint2(g);
        this.r3.paint3(g);
        this.r4.paint4(g);
    }
}

class Rect {
    int x, y;
    int w, h;

    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(new Color(145, 218, 0));
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.magenta);
        g2d.drawRect(this.x,this.y, this.w,this.h);
    } 
    
    void paint2 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(new Color(48, 156, 168));
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.white);
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }

    void paint3 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
            
        g.setColor(new Color(238, 255, 0));
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.green);
        g2d.drawRect(this.x,this.y, this.w,this.h);    
    }

    void paint4 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
            
        g.setColor(new Color(118, 112, 185));
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setPaint(Color.orange);
        g2d.drawRect(this.x,this.y, this.w,this.h);    
    }

}
