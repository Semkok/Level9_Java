import java.awt.BorderLayout;

import javax.swing.JScrollPane;

public class SwitchablePanel extends BasicPanel{
	
	SwitchablePanel(){
		setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(new RemoveToDoItemPanel());
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane,BorderLayout.CENTER);
		
	}
}
