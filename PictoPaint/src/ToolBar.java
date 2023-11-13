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
	
	ToolBar(){
		setBounds(0,0,1280,120);
		setBackground(Color.GRAY);
		exportDrawing = new JButton();
		exportDrawing.setText("Export Drawing to PNG");
		exportDrawing.setBounds(0, 0, 80, 50);
		add(exportDrawing);
		
		exportDrawing.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exportDrawing) {
			
		}
		
	}

}
