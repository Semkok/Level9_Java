import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * TOOLBAR JPANEL USED FOR OPTION MENU FOR THE APPLICATIONWINDOW
 *  */



public class ToolBar extends JPanel implements ActionListener{
	
	JButton exportDrawing;
	JButton exportDrawing1;
	
	JPanel mainPanel;
	
	Color[] useableColors = {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, Color.WHITE};
	
	private int currentBackground = 0;
	
	final int toolBarWidth = ApplicationWindow.WIDTH;
	final int toolBarHeight = ApplicationWindow.HEIGHT/ 6;
	
	ToolBar(JPanel drawPanel){
		this.mainPanel = drawPanel;
		
		setBounds(0,0,toolBarWidth,toolBarHeight);
		setBackground(Color.GRAY);
		
		exportDrawing = new JButton();
		exportDrawing.setText("Export Drawing to PNG");
		exportDrawing.setBounds(0, 0, 80, 50);
		add(exportDrawing);
		
		exportDrawing1 = new JButton();
		exportDrawing1.setText("2");
		exportDrawing1.setBounds(10, 0, 80, 50);
		add(exportDrawing1);
		
		exportDrawing.addActionListener(this);
		exportDrawing1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exportDrawing) {
			
		}
		
		if(e.getSource()==exportDrawing1) {
			
			mainPanel.setBackground(useableColors[currentBackground]);
			currentBackground++;
			if(currentBackground == useableColors.length) {
				currentBackground = 0;
			}
			
		}
		
	}

}
