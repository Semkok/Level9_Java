import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

public class ApplicationPanel extends JPanel {
		
	ApplicationPanel(ApplicationWindow appWindow){
		SwitchablePanel switchPanel = new SwitchablePanel();
		
		if(appWindow.currentOS.contains("win")) {
			switchPanel.setPreferredSize(new Dimension(appWindow.getWidth(),(appWindow.getHeight() / 32) * 31));
			setPreferredSize(new Dimension(appWindow.getSize()));
		}
		else {
			setLayout(new BorderLayout());
		}
		
		
		setVisible(true);
		add(new UpperBarPanel(appWindow,switchPanel), BorderLayout.NORTH);
		add(switchPanel);
		
	}
}
