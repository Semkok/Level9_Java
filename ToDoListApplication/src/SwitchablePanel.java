import java.awt.BorderLayout;

import javax.swing.JScrollPane;

public class SwitchablePanel extends BasicPanel{
	
	SwitchablePanel(){
		
		setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(new ShowToDoItemPanel());
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane,BorderLayout.CENTER);
		ScreenHandler screenHandler = new ScreenHandler(this);
		
		screenHandler.setNewPanel(new RemoveToDoItemPanel());
		
		
	}
}
