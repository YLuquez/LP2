import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.Rect;

import java.util.ArrayList;
import java.util.Random;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class ListApp {
    public static void main(String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    ArrayList<Ellipse> el = new ArrayList<Ellipse>();
    
    Random rand = new Random();

    private Color getRandomColor() {
        return new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
    }

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed(KeyEvent evt) {
                    if (evt.getKeyChar() == 'e') {
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
                        Color borderColor = getRandomColor();
                        Color fillColor = getRandomColor();
                        
                        el.add(new Ellipse(x, y, w, h, borderColor, fillColor)); // outer.el.add();
                        repaint(); // outer.repaint()
                    }
                }
            }
        );
        this.setTitle("Lista");
        this.setSize(350, 350);
        
    }

    public void paint(Graphics g) {
        super.paint(g);
        
        for (Ellipse e: this.el) {
            e.paint(g);
        }

    }   
        class Ellipse {
            int x, y;
            int w, h;
            Color borderColor, fillColor;
        
            Ellipse(int x, int y, int w, int h, Color borderColor, Color fillColor) {
                this.x = x;
                this.y = y;
                this.w = w;
                this.h = h;
                this.borderColor = borderColor;
                this.fillColor = fillColor;
            }
        
            void Print() {
                System.out.format("Elipse de eixos (%d,%d) na posicao (%d,%d).\n",
                    this.w, this.h, this.x, this.y);
            }
        
            void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
        
                g2d.setColor(borderColor);
                g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
        
                g2d.setColor(fillColor);
                g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
            }
        }
}
