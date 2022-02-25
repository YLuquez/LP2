import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RectApp {
    public static void main (String[] args) {
        RectFrame frame = new RectFrame();
    }
}

class RectFrame extends JFrame {
    public RectFrame () {
        this.addWindowListener (
                new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
        this.setTitle("LP2 - 2.2.1");
        this.setSize(500, 500);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.PINK);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(145, 218, 0));
        g2d.drawRect(50,50, 100,250);
        g2d.setColor(new Color(48, 156, 168));
        g2d.fillRect(50,50, 100,250);

        g2d.setColor(new Color(5, 18, 162));
        g2d.drawRect(100,200, 150,200);
        g2d.setColor(new Color(145, 218, 0));
        g2d.fillRect(100,200, 150,200);

        g2d.setColor(new Color(168, 150, 156));
        g2d.drawRect(150,250, 200,150);
        g2d.setColor(new Color(238, 255, 0));
        g2d.fillRect(150,250, 200,150);

        g2d.setColor(new Color(48,200, 0));
        g2d.drawRect(240,120, 250,100);
        g2d.setColor(new Color(255, 0, 238));
        g2d.fillRect(240,120, 250,100);

    }
}
