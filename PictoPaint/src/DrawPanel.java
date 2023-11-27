import javax.swing.JPanel;
import javax.swing.JColorChooser;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/*
 * DRAWINGBOARD FOR THE PICOPAINT APPLICATION
 * */

public class DrawPanel extends JPanel {

    // integers for width and height drawpanel
    final int panelWidth = ApplicationWindow.WIDTH;
    final int panelHeight = ApplicationWindow.HEIGHT;

    // ArrayList for keeping track of where is drawn on the DrawPanel
    private List<ColoredPoint> coloredPoints = new ArrayList<>();

    // Point object for keeping track of the current point
    private Point currentPoint;

    // Brush color
    private Color brushColor = Color.RED;

    DrawPanel() {
        setBounds(0, 120, panelWidth, panelHeight);

        // Add a mouse listener for drawing when the mouse is pressed
        addMouseListener(new PaintMouseListener());

        // Add a mouse motion listener for tracking mouse movement
        addMouseMotionListener(new PaintMouseListener());
        
    }
    
    @Override 
    protected void paintComponent(Graphics g) {
    	
        super.paintComponent(g);

        // convert Graphics object to Graphics2D object
        Graphics2D g2d = (Graphics2D) g;
       
        for (ColoredPoint coloredPoint : coloredPoints) {
            g2d.setColor(coloredPoint.getColor());
            Point point = coloredPoint.getPoint();
            g2d.fillOval(point.x - 5, point.y - 5, 10, 10);
        }
        // Draw the current point when the mouse is pressed and moved
        if (currentPoint != null) {
            g2d.setColor(brushColor); // Set the current brush color
            g2d.fillOval(currentPoint.x - 5, currentPoint.y - 5, 10, 10);
        }
    }

    private class PaintMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            // Check if the right mouse button is pressed
            if (e.getButton() == MouseEvent.BUTTON3) {
                // shows a pop-up of a java color menu for the user to pick a color
                brushColor = JColorChooser.showDialog(DrawPanel.this, "Choose Brush Color", brushColor);
            } else {
                // Add the clicked point to the list with the current brush color
                ColoredPoint coloredPoint = new ColoredPoint(new Point(e.getX(), e.getY()), brushColor);
                
                // if the left mouse button is pressed it will add the drawn coloredPoint to the colordPointsArraylist
                coloredPoints.add(coloredPoint);
            }

            // Repaint to update the drawing
            repaint();
        }
        @Override 
        public void mouseDragged(MouseEvent e) {
            // Update the current point during mouse dragging
            currentPoint = new Point(e.getX(), e.getY());
            // Add the current point to the list with the current brush color
            ColoredPoint coloredPoint = new ColoredPoint(currentPoint, brushColor);
            coloredPoints.add(coloredPoint);
            // Repaint to update the drawing
            repaint();
        }
        @Override
        public void mouseMoved(MouseEvent e) {
            // Update the current point during normal mouse movement
            currentPoint = new Point(e.getX(), e.getY());
            // Repaint to update the drawing
            repaint();
        }
    }
    // ColordPoint class for retrieving the specific color and point of an drawn object where its drawn on this JPanel
    private class ColoredPoint {
        private Point point;
        private Color color;

        public ColoredPoint(Point point, Color color) {
            this.point = point;
            this.color = color;
        }

        public Point getPoint() {
            return point;
        }

        public Color getColor() {
            return color;
        }
    }
}
