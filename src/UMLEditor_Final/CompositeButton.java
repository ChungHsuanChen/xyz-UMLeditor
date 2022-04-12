package UMLEditor_Final;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UMLEditor_Final.GeneralizeButton.btnlistener;
import UMLEditor_mode.CreateLineMode;

public class CompositeButton extends Button{
	private final int INDEX_OF_BUTTON=3;
	public CompositeButton() {
		super("Composition");
		setBounds(0,260,80,80);
		setBackground(null);	
		addActionListener(new btnlistener());
		
	}
	class btnlistener implements ActionListener{
	
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			setBackground(Color.BLACK);
			mypanel.resetButtoncolor(INDEX_OF_BUTTON);
			mypanel.setMode(new CreateLineMode("composite"));
	}
	}
}
