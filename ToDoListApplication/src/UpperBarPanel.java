import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class UpperBarPanel extends JPanel {
	UpperBarPanel(ApplicationWindow appWindow){
		setLayout(new BorderLayout());
		setBackground(new Color(37,51,71));
		add(new CloseApplicationWindowButton(appWindow), BorderLayout.EAST);
	}
}
