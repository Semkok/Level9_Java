import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ApplicationPanel extends JPanel {
		
	ApplicationPanel(ApplicationWindow appWindow){
		SwitchablePanel switchPanel = new SwitchablePanel();
		setLayout(new BorderLayout());
		setVisible(true);
		add(new UpperBarPanel(appWindow,switchPanel), BorderLayout.NORTH);
		add(switchPanel);
		
	}
}
