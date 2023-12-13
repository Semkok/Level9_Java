public class ScreenHandler {
	
	SwitchablePanel appPanel;
	
	ScreenHandler(SwitchablePanel appPanel){
		this.appPanel = appPanel;
	}
	
	public void setNewPanel(BasicPanel newPanel) {
		repaintPanel(appPanel);
		appPanel.add(newPanel);
	}
	
	
	private void repaintPanel(SwitchablePanel switchablePanel) {
		switchablePanel.removeAll();
		switchablePanel.repaint();
		switchablePanel.revalidate();
	}
}
