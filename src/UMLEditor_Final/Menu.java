package UMLEditor_Final;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu extends JMenuBar{
	private JMenu filemenu;
	private JMenu editmenu;
	private JMenuItem group;
	private JMenuItem ungroup;
	private JMenuItem change;
	private MyPanel mypanel;
	public Menu() {
		mypanel=MyPanel.getinstance();
		setBounds(0, 0, 75, 20);
		filemenu=new JMenu("File");
		editmenu=new JMenu("Edit");
		group=new JMenuItem("Group");
		ungroup=new JMenuItem("UnGroup");
		change=new JMenuItem("Change object name");
		editmenu.add(group);
		editmenu.add(ungroup);
		editmenu.add(change);
		
		add(filemenu);
		add(editmenu);
		filemenu.setBounds(0, 0, 35, 20);
		editmenu.setBounds(35, 0, 40, 20);
		group.addActionListener(new grouplistener());
		ungroup.addActionListener(new ungrouplistener());
		change.addActionListener(new changenamelistener());
	}
	class grouplistener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			mypanel.group();
		}
		
	}
	class ungrouplistener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			mypanel.ungroup();
		}
		
	}
	class changenamelistener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFrame ck=new JFrame("Change Object Name");
			ck.setSize(500,100);
			ck.getContentPane().setLayout(new GridLayout(0,1));
			JPanel panel=new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			JTextField Text =  new JTextField("Object Name");
			panel.add(Text);
			ck.getContentPane().add(panel);
			panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			JButton confirm = new JButton("OK");
			panel.add(confirm);
			JButton cancel = new JButton("Cancel");
			panel.add(cancel);
			ck.getContentPane().add(panel);
			ck.setLocationRelativeTo(null);		
			ck.setVisible(true);
			confirm.addActionListener(new ActionListener()	{

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					mypanel.changename(Text.getText());
					ck.dispose();
				}
				
			});
			
			cancel.addActionListener(new ActionListener()	{

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ck.dispose();
				}
				
			}
					);
		
		}
		
	}
}
