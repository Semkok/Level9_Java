import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JColorChooser;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        addMouseMotionListener(new PaintMouseMotionListener());
        
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw all the colored points
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

    private class PaintMouseListener implements MouseListener {
        @Override
        public void mousePressed(MouseEvent e) {
            // Check if the right mouse button is pressed
            if (e.getButton() == MouseEvent.BUTTON3) {
                // Change the brush color when right mouse button is pressed
                brushColor = JColorChooser.showDialog(DrawPanel.this, "Choose Brush Color", brushColor);
            } else {
                // Add the clicked point to the list with the current brush color
                ColoredPoint coloredPoint = new ColoredPoint(new Point(e.getX(), e.getY()), brushColor);
                coloredPoints.add(coloredPoint);
            }

            // Repaint to update the drawing
            repaint();
        }

        // Unneeded but needs to be implemented by MouseListener
        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }

    private class PaintMouseMotionListener implements MouseMotionListener {
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

    public void saveImageToFile(String filePath) {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        paint(g2d);
        g2d.dispose();

        try {
            ImageIO.write(image, "png", new File(filePath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

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
