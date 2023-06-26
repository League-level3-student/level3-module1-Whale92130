package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 */

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	HashMap<Integer, String> log = new HashMap<Integer, String>();
	ArrayList<Integer> IDs = new ArrayList<Integer>();
	String search;

	void Search() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);

		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);

		button1.setText("Add Entry");
		button2.setText("Search by ID");
		button3.setText("View List");
		button4.setText("Remove Entry");

		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean exists = false;
		int o=0;
		if (e.getSource().equals(button1)) {
			IDs.add(Integer.parseInt(JOptionPane.showInputDialog("Insert ID")));
			log.put(IDs.get(IDs.size() - 1), JOptionPane.showInputDialog("Insert Name"));
		} else if (e.getSource().equals(button2)) {
			search = JOptionPane.showInputDialog("Search by ID");
			int searchI = Integer.parseInt(search);
			for (int i = 0; i < IDs.size(); i++) {
				if (searchI == IDs.get(i)) {
					exists = true;
					o = i;
				}
				
					
			}
			if (exists == true) {
			JOptionPane.showMessageDialog(null, log.get(IDs.get(o)));
			}
			else {
				JOptionPane.showMessageDialog(null, "That entry does not exist");
			}
			
			
		} else if (e.getSource().equals(button3)) {
			String printList = "";
			for (int i = 0; i < log.size(); i++) {
				printList = printList + "ID: " + IDs.get(i) + " Name: " + log.get(IDs.get(i)) + "\n";
			}
			JOptionPane.showMessageDialog(null, printList);
		} else if (e.getSource().equals(button4)) {
			String search1 = JOptionPane.showInputDialog("Remove by ID");
			int searchI1 = Integer.parseInt(search1);
			for (int i = 0; i < IDs.size(); i++) {
				if (searchI1 == IDs.get(i)) {
					log.remove(IDs.get(i));
					IDs.remove(i);
				} else {
					JOptionPane.showMessageDialog(null, "That entry does not exist");
				}
			}
		}
	}

}
