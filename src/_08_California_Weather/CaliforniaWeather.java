package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();

	void start() {

		frame.add(panel);
		panel.add(button1);
		button1.addActionListener(this);
		panel.add(button2);
		button2.addActionListener(this);
		panel.add(button3);
		button3.addActionListener(this);
		panel.add(button4);
		button4.addActionListener(this);

		button1.setText("Search by City");
		button2.setText("Search by Current Conditions");
		button3.setText("Search by Max Temperature");
		button4.setText("Search by Minimum Temperature");

		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// All city keys have the first letter capitalized of each word

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// button1
		if (arg0.getSource().equals(button1)) {
			String cityName = JOptionPane.showInputDialog("Type City Name");
			WeatherData datum = weatherData.get(cityName);

			if (datum == null) {
				JOptionPane.showMessageDialog(null, "Unable to find weather data for: " + cityName);
			} else {
				JOptionPane.showMessageDialog(null, cityName + " is " + datum.weatherSummary + " with a temperature of "
						+ datum.temperatureF + " F");
			}
		}

		// button 2
		if (arg0.getSource().equals(button2)) {
			String conditions = JOptionPane.showInputDialog("Type Current City Conditions");
			WeatherData datum = weatherData.get(conditions);
			System.out.println(datum);
			if (datum == null) {
				JOptionPane.showMessageDialog(null, "Unable to find city data for: " + conditions);
			} else {
				JOptionPane.showMessageDialog(null, datum);
			}
		}

		// button 3
		if (arg0.getSource().equals(button3)) {

		}

		// button 4
		if (arg0.getSource().equals(button4)) {

		}

	}
}
