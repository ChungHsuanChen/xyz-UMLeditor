package UMLEditor_Final;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UMLEditor_Final.associationButton.btnlistener;
import UMLEditor_mode.CreateLineMode;

public class GeneralizeButton extends Button{
	private final int INDEX_OF_BUTTON=2;
	public GeneralizeButton() {
		super("Generalization");
		setBounds(0,180,80,80);
		setBackground(null);	
		addActionListener(new btnlistener());
	}
	class btnlistener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			setBackground(Color.BLACK);
			mypanel.resetButtoncolor(INDEX_OF_BUTTON);
			mypanel.setMode(new CreateLineMode("generalize"));
	}
		}
}

