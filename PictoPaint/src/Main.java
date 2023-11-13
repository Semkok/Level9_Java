class Main{
	public static void main(String[] args) {
		
		
		ApplicationWindow applicationWindow = new ApplicationWindow();
		
		DrawPanel drawPanel = new DrawPanel();
		ToolBar toolBar = new ToolBar(drawPanel);
		applicationWindow.add(toolBar);
		applicationWindow.add(drawPanel);
	}
}