public class ScreenHandler {
	
	ApplicationPanel appPanel;
	
	ScreenHandler(ApplicationPanel appPanel){
		this.appPanel = appPanel;
		System.out.println(appPanel.getLayout());
	}
	
	public void setNewPanel(BasicPanel newPanel) {
		repaintPanel(appPanel);
	}
	
	
	private void repaintPanel(ApplicationPanel appPanel) {
		appPanel.removeAll();
		appPanel.repaint();
		appPanel.revalidate();
	}
}
