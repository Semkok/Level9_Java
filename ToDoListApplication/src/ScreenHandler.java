import java.awt.BorderLayout;

import javax.swing.JScrollPane;
/*
 * CLASS FOR HANDELING THE DIFFERENT SCREENS 
 * */
public class ScreenHandler {
	
	private SwitchablePanel appPanel; //  the SwitchablePanel that gets its JPanels from the ScreenHandler
	
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
		newPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		newPanel.getVerticalScrollBar().setUnitIncrement(20); // SCROLL SPEED
		appPanel.add(newPanel, BorderLayout.CENTER);
	}
	
	private void repaintPanel(SwitchablePanel switchablePanel) {
		switchablePanel.removeAll();
		switchablePanel.repaint();
		switchablePanel.revalidate();
	}
}
