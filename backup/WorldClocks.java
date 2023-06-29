package _09_World_Clocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/*
 * You task is to create a java program that:
 * 1. Displays the time for multiple cities around the world on one display.
 * 2. Gives the user the ability to add a city to the display. One possible
 *    way to do this is to create a HashMap of city names and their
 *    corresponding time zones, e.g. HashMap<String, TimeZone>, then use each
 *    city's TimeZone to get the current date/time every second using a
 *    Timer object (see example code below).
 * 
 * The code below is an example of how to print out a clock for San Diego.
 * Use the ClockUtilities class to find the time zone of each city, then use
 * Calendar.getInstance to return a Calendar object to get the current time for
 * that city. Example:
 *   TimeZone timeZone = clockUtil.getTimeZoneFromCityName("San Diego, US");
 *   Calendar c = Calendar.getInstance(timeZone);
 *   System.out.println("Full date and time: " + calendar.getTime());
 * 
 * NOTE: The program may take a second or two to execute
 * 
 * Calendar class:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
 */

public class WorldClocks implements ActionListener {
	ClockUtilities clockUtil;
	Timer timer;
	TimeZone timeZone;

	JFrame frame;
	JPanel panel;
	ArrayList<JTextArea> textAreas = new ArrayList<JTextArea>();
	JButton button;

	ArrayList<String> city = new ArrayList<String>();
	String dateStr;
	String timeStr;
	boolean run = true;

	HashMap<String, TimeZone> cities = new HashMap<String, TimeZone>();

	public WorldClocks() {

		clockUtil = new ClockUtilities();

		// The format for the city must be: city, country (all caps)

		// Sample starter program

		frame = new JFrame();
		panel = new JPanel();
		button = new JButton();
		JTextArea textArea = new JTextArea();
		textAreas.add(textArea);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(100, 100);
		frame.add(panel);
		panel.add(button);
		panel.add(textAreas.get(0));
		button.addActionListener(this);
		button.setText("Add City");

		// This Timer object is set to call the actionPerformed() method every
		// 1000 milliseconds
		timer = new Timer(1000, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(button) || run == true) {
			clockUtil = new ClockUtilities();

			JTextArea textArea = new JTextArea();
			textAreas.add(textArea);
			String cityg = JOptionPane.showInputDialog("Enter City and Country (city, country (all caps))");
			city.add(cityg);
			TimeZone timeZone = clockUtil.getTimeZoneFromCityName(city.get(city.size()-1));

			cities.put(city.get(city.size()-1), timeZone);
			
			for (int o = 0; o < city.size(); o++) {
			Calendar calendar = Calendar.getInstance(cities.get(city.get(o)));
			String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
			String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
			 	dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " "
					+ calendar.get(Calendar.YEAR);

			panel.add(textAreas.get(o));
			textAreas.get(o).setText(city.get(o) + "\n" + dateStr);

			System.out.println(dateStr);
			frame.pack();
			
			}
			run = false;
		}

		for (int i = 0; i < cities.size(); i++) {
			Calendar c = Calendar.getInstance(cities.get(city.get(i)));
			String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":"
					+ c.get(Calendar.SECOND);
			String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":"
					+ c.get(Calendar.SECOND) + "]";
			timeStr = militaryTime + twelveHourTime;

			System.out.println(timeStr);
			textAreas.get(i).setText(city + "\n" + dateStr + "\n" + timeStr);
			frame.pack();
		}

	}
}
