package _00_Intro_To_ArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */

	
	

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	ArrayList<String> names = new ArrayList<String>();
	 void run() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button1.setText("Add Names");
		button2.setText("View Names");
		
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String list = "";
		
		if (arg0.getSource().equals(button1)) {
			names.add(JOptionPane.showInputDialog("Put Name Here"));
		}
		if (arg0.getSource().equals(button2)) {
			for (int i = 0; i < names.size(); i++) {
				list = list + "Guest #" + i + ": " + names.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null,list);
		}
	}
}
