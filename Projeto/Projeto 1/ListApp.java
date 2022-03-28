import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;
import handlers.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Handlers Handler = new Handlers();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        
        this.addMouseListener (
            new MouseAdapter() {
                public void mouseMoved(MouseEvent evt) {

                }
            }

        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed(KeyEvent evt) {
                    Figure fig = Handler.HandleWithKey(evt);

                    if (fig != null) {
                        figs.add(fig);
                    }
                    repaint();
                }
            }
        );

        this.setTitle("Projeto 1/2");
        this.setSize(500, 500);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
