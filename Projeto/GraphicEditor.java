import java.awt.*;
import java.awt.event.*;
import java.awt.Point;
import javax.swing.*;

import java.util.ArrayList;

import figures.*;

class GraphicEditor {
    public static void main(String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {

    ArrayList<Figure> figures = new ArrayList<Figure>();
    Figure FigureFocus = null;

    Point mousePosition = new Point(0, 0);

    public ListFrame(){
        this.setFocusTraversalKeysEnabled(false);
        
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent) {
                    System.exit(0);
                }
            }
            
        );

        this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed(MouseEvent mouseEvent) {
                    FigureFocus = MouseButton.SelectFigure(mouseEvent, figures, FigureFocus);
                    mouseMoved(mouseEvent); 
                    repaint();
                }
            }

        );

        this.addMouseMotionListener (
            new MouseAdapter() {
                public void mouseMoved(MouseEvent mouseEvent) {
                    mousePosition.x = mouseEvent.getX();
                    mousePosition.y = mouseEvent.getY();
                }

                public void mouseDragged(MouseEvent mouseEvent) {
                    FigureFocus = MouseButton.SelectAndDragFigure(mouseEvent, figures, FigureFocus, mousePosition);
                    mouseMoved(mouseEvent);
                    repaint();
                    
                   
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed(KeyEvent keyEvent) {
                    FigureFocus = KeyButton.KeyButtonPressed(keyEvent, figures, FigureFocus, mousePosition);
                    repaint();
                }
            }
        );

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        int userWidth = gd.getDisplayMode().getWidth();
        int userHeight = gd.getDisplayMode().getHeight();

        this.setTitle("Vectorial Graphic Editor");
        this.setSize(userWidth, userHeight);
    }

    
    public class MouseButton {
    
        public static Figure SelectFigure(MouseEvent mouseEvent, ArrayList<Figure> figures, Figure FigureFocus) {
            FigureFocus = null;
            int MOUSE1 = 1;

            if (mouseEvent.getButton() == MOUSE1) {
                Point mousePosition = new Point(mouseEvent.getX(), mouseEvent.getY());
    
                for (Figure figure : figures) {
                    if (figure.IsInsideFigure(mousePosition) == true) {
                        FigureFocus = figure;
                    }
                }
    
                if (FigureFocus != null) {
                    figures.remove(FigureFocus);
                    figures.add(FigureFocus);
                }
            }
    
            return FigureFocus;
        }
    
        public static Figure SelectAndDragFigure(MouseEvent mouseEvent, ArrayList<Figure> figures, Figure FigureFocus, Point mousePosition) {
            if (FigureFocus != null) {
                FigureFocus.dragFigure(mousePosition, mouseEvent.getX() - mousePosition.x, mouseEvent.getY() - mousePosition.y);
            }
    
            return FigureFocus;
        }
    }

    public class KeyButton {
        private static final int defaultSize = 100;
        public class KeyButtons {
            public static final int DEL = 127;
            public static final int TAB = 9; 
            public static final int UP = 38;
            public static final int DOWN = 40;
            public static final int LEFT = 37;
            public static final int RIGHT = 39;
            public static final int PAGEUP = 33;
            public static final int PAGEDOWN = 34;
            public static final int PERIOD = 46;
            public static final int COMMA = 44;
        }
        
        public static Figure KeyButtonPressed(KeyEvent keyEvent, ArrayList<Figure> figures, Figure FigureFocus, Point mousePosition) {
            if (keyEvent.getKeyChar() == 'r') {
                Rect rectangle = new Rect(mousePosition.x, mousePosition.y, defaultSize, defaultSize);
                figures.add(rectangle);
        
            } else if (keyEvent.getKeyChar() == 'e') {
                Ellipse ellipse = new Ellipse(mousePosition.x, mousePosition.y, defaultSize, defaultSize);
                figures.add(ellipse);
        
            } else if (keyEvent.getKeyChar() == 't') {
                Triangle triangle = new Triangle(mousePosition.x, mousePosition.y, defaultSize, defaultSize);
                figures.add(triangle);
        
            } else if (keyEvent.getKeyChar() == 'l') {
                Line line = new Line(mousePosition.x, mousePosition.y);
                figures.add(line);
        
            } else if (keyEvent.getKeyCode() == KeyButtons.TAB) {
                if (FigureFocus != null) {
                    if (figures.size() > 0) {
                        int index = figures.indexOf(FigureFocus);
                        if (index != figures.size() - 1) {
                            FigureFocus = figures.get(index + 1);
                       
                        } else {
                            FigureFocus = figures.get(0);
                        }
                    }
        
                } else {
                    FigureFocus = figures.get(0);
                }
                figures.remove(FigureFocus);
                figures.add(FigureFocus);
        
            } else if (FigureFocus != null) {
                if (keyEvent.getKeyCode() == KeyButtons.UP) {
                    FigureFocus.move(0, -5);
        
                } else if (keyEvent.getKeyCode() == KeyButtons.DOWN) {
                    FigureFocus.move(0, 5);
        
                } else if (keyEvent.getKeyCode() == KeyButtons.LEFT) {
                    FigureFocus.move(-5, 0);
        
                } else if (keyEvent.getKeyCode() == KeyButtons.RIGHT) {
                    FigureFocus.move(5, 0);
        
                } else if (keyEvent.getKeyCode() == KeyButtons.DEL) {
                    figures.remove(FigureFocus);        
                    FigureFocus = null; 
        
                } else if (keyEvent.getKeyCode() == KeyButtons.PAGEUP) {
                    FigureFocus.fillColorIndex++;
    
                    if (FigureFocus.fillColorIndex > 10) {
                        FigureFocus.fillColorIndex %= 11;
                    }
    
                    FigureFocus.applyFillColorChange();
                } else if (keyEvent.getKeyCode() == KeyButtons.PAGEDOWN) {
                    FigureFocus.fillColorIndex--;
    
                    if (FigureFocus.fillColorIndex < 0) {
                        FigureFocus.fillColorIndex += 11;
                    }
    
                    FigureFocus.applyFillColorChange();
                } else if (keyEvent.getKeyCode() == KeyButtons.PERIOD) {
                    FigureFocus.borderColorIndex++;
    
                    if (FigureFocus.borderColorIndex > 10) {
                        FigureFocus.borderColorIndex %= 11;
                    }
    
                    FigureFocus.applyBorderColorChange();
                } else if (keyEvent.getKeyCode() == KeyButtons.COMMA) {
                    FigureFocus.borderColorIndex--;
    
                    if (FigureFocus.borderColorIndex < 0) {
                        FigureFocus.borderColorIndex += 11;
                    }
    
                    FigureFocus.applyBorderColorChange();
                }
            }
        
            return FigureFocus;
        }

        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Figure figure: this.figures) {
            figure.Paint(g);
        }

        if (FigureFocus != null) {
            FigureFocus.applyRedSelection(g);
        }

    }

}
