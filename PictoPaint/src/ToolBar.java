import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * TOOLBAR JPANEL USED FOR OPTION MENU FOR THE APPLICATIONWINDOW
 *  */
public class ToolBar extends JPanel implements ActionListener{
	
	JButton exportDrawing;
	JButton changeBackgroundButton;
	JPanel mainPanel;
	
	Color[] useableColors = {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, Color.WHITE};
	
	private int currentBackground = 0;
	
	
	
	Dimension appWindowSize = ApplicationWindow.screenSize;
	
	Dimension toolBarSize = new Dimension((int)appWindowSize.getWidth(),(int)appWindowSize.getHeight());
	
	
	
	
	ToolBar(JPanel drawPanel){
		this.mainPanel = drawPanel;
		setMaximumSize(toolBarSize);
		setBackground(new Color(0,6,47));
		
		JLabel title = new JLabel("PictoPaint!");
		title.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		title.setForeground(new Color(255,255,255));
		title.setBounds(-10,0,50,10);
		
		add(title);
		
		exportDrawing = new JButton();
		exportDrawing.setText("Export Drawing to PNG");
		exportDrawing.setBounds(0, 0, 50, 10);
		add(exportDrawing);
		
		changeBackgroundButton = new JButton();
		changeBackgroundButton.setText("Change background");
		changeBackgroundButton.setBounds(ApplicationWindow.WIDTH / 2, 0, 50, 10);
		add(changeBackgroundButton);
		
		exportDrawing.addActionListener(this);
		changeBackgroundButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exportDrawing) {
			saveImageToFile("image.png");
		}
		
		if(e.getSource()==changeBackgroundButton) {
			
			mainPanel.setBackground(useableColors[currentBackground]);
			currentBackground++;
			if(currentBackground == useableColors.length) {
				currentBackground = 0;
			}
			
		}
		
	}
	
	// function for saving the DrawPanel its contents
	public void saveImageToFile(String filePath) {
		
	    BufferedImage image = new BufferedImage(mainPanel.getWidth(), mainPanel.getHeight(), BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2d = image.createGraphics();
	    
	    // Draw the content of mainPanel onto the BufferedImage
	    System.out.println(mainPanel);
	    mainPanel.paint(g2d);
	    
	    g2d.dispose();

	    try {
	        ImageIO.write(image, "png", new File(filePath));
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}

}
