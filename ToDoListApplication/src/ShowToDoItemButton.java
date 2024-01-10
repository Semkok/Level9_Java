import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JButton;
/*
 * BUTTON FOR SWITCHING TO THE WHOW TODOITEM PANEL
 * */
public class ShowToDoItemButton extends JButton implements ActionListener{
	
	private ScreenHandler screenHandler;
	
	ShowToDoItemButton(ScreenHandler screenHandler){
		setText("Show items");
		this.screenHandler = screenHandler;
		addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		screenHandler.setNewPanel(new JScrollPane(new ShowToDoItemPanel()));
		
	}
	
	
	
}
