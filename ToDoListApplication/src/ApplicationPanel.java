import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
/*
 * PARENT JPANEL FOR THE UPPERBARPANEL AND THE SWITCHPANEL
 * */

public class ApplicationPanel extends JPanel {
		
	ApplicationPanel(ApplicationWindow appWindow){
		SwitchablePanel switchPanel = new SwitchablePanel();
		
		if(appWindow.userOS.contains("win")) { // LAYOUT FOR WINDOWS
			switchPanel.setPreferredSize(new Dimension(appWindow.getWidth(),(appWindow.getHeight() / 32) * 31));
			setPreferredSize(new Dimension(appWindow.getSize()));
		}
		
		else { // LAYOUT FOR OTHER TYPE SYSTEMS
			setLayout(new BorderLayout());
		}
		setVisible(true);
		add(new UpperBarPanel(appWindow,switchPanel), BorderLayout.NORTH);
		add(switchPanel);
		
	}
}
