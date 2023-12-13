import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class ApplicationPanel extends JPanel {
		
	ApplicationPanel(ApplicationWindow appWindow){
		setLayout(new BorderLayout());
		setVisible(true);
		add(new UpperBarPanel(appWindow), BorderLayout.NORTH);
		add(new StartPanel(), BorderLayout.CENTER);
		ScreenHandler screenHandler = new ScreenHandler(this);
		
	}
}
