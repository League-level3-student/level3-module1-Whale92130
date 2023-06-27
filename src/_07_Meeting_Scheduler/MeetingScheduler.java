package _07_Meeting_Scheduler;

import java.util.ArrayList;
import java.util.HashMap;

public class MeetingScheduler {
	/*
	 * Your task is to code a method to find a meeting time for two people given
	 * their schedules.
	 * 
	 * Code the method below so that it returns a Schedule object that contains all
	 * the times during the week that are in BOTH people's schedules. The Schedule
	 * class is included in this package.
	 * 
	 * 
	 * System.out.println();
	 * 
	 * Example: person1 availability - Monday at 9, Tuesday at 14, and Friday 10
	 * person2 availability - Tuesday at 14, Friday 8, and Monday at 9 The returned
	 * HashMap should contain: Tuesday 14 and Monday 9
	 * 
	 * The returned Schedule object represents the times both people are available
	 * for a meeting.
	 * 
	 * Time availability is always at the top of the hour, so 9:30 is not valid Time
	 * availability always represents 1 hour Assume both schedules are in the same
	 * time zones
	 */
	public static Schedule getMutualAvailability(Schedule person1, Schedule person2) {
		HashMap<String, ArrayList<Integer>> sche1 = person1.getSchedule();
		HashMap<String, ArrayList<Integer>> sche2 = person2.getSchedule();
		
		Schedule timeThatWorks = new Schedule();

		String[] days = new String[7];
		days[0] = "Monday";
		days[1] = "Tuesday";
		days[2] = "Wednesday";
		days[3] = "Thursday";
		days[4] = "Friday";
		days[5] = "Saturday";
		days[6] = "Sunday";

		for (int q = 0; q < days.length; q++) {
			ArrayList<Integer> timesFor1 = new ArrayList<Integer>();
			ArrayList<Integer> timesFor2 = new ArrayList<Integer>();
			timesFor1.addAll(sche1.get(days[q]));
			timesFor2.addAll(sche2.get(days[q]));
		
			for (int i = 0; i < timesFor1.size(); i++) {
				for (int o = 0; o < timesFor2.size(); o++) {
					if (timesFor1.get(i) == timesFor2.get(o)) {
						timeThatWorks.addAvailability(days[q], timesFor1.get(i));
					}
				}
			}
			
		}

		return timeThatWorks;
	}
}
