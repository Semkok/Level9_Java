import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

public class DrawPanel extends JPanel {
    private List<Point> clickedPoints = new ArrayList<>();
    private Point currentPoint;

    DrawPanel() {
        setBounds(0, 120, 1280, 600);

        // Add a mouse listener for drawing when the mouse is pressed
        addMouseListener(new PaintMouseListener());

        // Add a mouse motion listener for tracking mouse movement
        addMouseMotionListener(new PaintMouseMotionListener());
        
        while(true) {
			long currentTimeMillis = System.currentTimeMillis() / 1000;
			long currentTimeSeconds = currentTimeMillis % 10;
			System.out.println(currentTimeSeconds);
			if(currentTimeSeconds == 6) {
				this.saveImageToFile("image.png");
				break;
			}
			
		}
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw all the clicked points in red
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        for (Point point : clickedPoints) {
            g2d.fillOval(point.x - 5, point.y - 5, 10, 10);
        }

        // Draw the current point when the mouse is pressed and moved
        if (currentPoint != null) {
            g2d.fillOval(currentPoint.x - 5, currentPoint.y - 5, 10, 10);
        }
    }

    private class PaintMouseListener implements MouseListener {
        @Override
        public void mousePressed(MouseEvent e) {
            // Add the clicked point to the list
            Point clickedPoint = new Point(e.getX(), e.getY());
            clickedPoints.add(clickedPoint);

            // Repaint to update the drawing
            repaint();
        }

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    }

    private class PaintMouseMotionListener implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            // Update the current point during mouse dragging
            currentPoint = new Point(e.getX(), e.getY());

            // Add the current point to the list (optional)
            clickedPoints.add(currentPoint);

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
}