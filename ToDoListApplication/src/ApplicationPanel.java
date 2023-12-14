import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ApplicationPanel extends JPanel {
		
	ApplicationPanel(ApplicationWindow appWindow){
		SwitchablePanel switchPanel = new SwitchablePanel();
		
		if(appWindow.currentOS.contains("win")) {
			switchPanel.setPreferredSize(new Dimension(appWindow.getWidth(),(appWindow.getHeight() / 32) * 31));
			setPreferredSize(new Dimension(appWindow.getSize()));
		}
		
		
		setVisible(true);
		add(new UpperBarPanel(appWindow,switchPanel), BorderLayout.NORTH);
		add(switchPanel);
		
	}
}
