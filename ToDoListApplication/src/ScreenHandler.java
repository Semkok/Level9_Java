import java.awt.BorderLayout;

import javax.swing.JScrollPane;

public class ScreenHandler {
	
	SwitchablePanel appPanel;
	
	ScreenHandler(SwitchablePanel appPanel){
		this.appPanel = appPanel;
	}
	
	public void setNewPanel(BasicPanel newPanel) {
		repaintPanel(appPanel);
		appPanel.add(newPanel);
	}
	
	public void setNewPanel(JScrollPane newPanel) {
		repaintPanel(appPanel);
		newPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		appPanel.add(newPanel, BorderLayout.CENTER);
	}
	
	
	
	private void repaintPanel(SwitchablePanel switchablePanel) {
		switchablePanel.removeAll();
		switchablePanel.repaint();
		switchablePanel.revalidate();
	}
}
