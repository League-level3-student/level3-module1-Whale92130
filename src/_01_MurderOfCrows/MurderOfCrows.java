package _01_MurderOfCrows;

import java.util.ArrayList;
import java.util.Random;

public class MurderOfCrows {

	ArrayList<Crow> theMurder = new ArrayList<Crow>();

	public static void main(String[] args) {
		MurderOfCrows murderOfCrows = new MurderOfCrows();
		murderOfCrows.initializeCrows();
		murderOfCrows.findTheDiamond();
	}

	private void findTheDiamond() {
		// 1. One of the Crows has eaten the diamond. You need to search
		// through the stomach of each Crow, then print the name of the
		// guilty Crow.
		ArrayList<String> contents = new ArrayList<String>();
		int dead = 0;
		int crowNum = 0;
		for (int i = 0; i < theMurder.size(); i++) {
			contents = theMurder.get(i).getStomachContents();
			for (int o = 0; o < contents.size(); o++) {
				if (contents.get(o).equals("diamond")) {
					crowNum = i+1;
					System.out.println(theMurder.get(i).getName() + "(" + crowNum + ")" + " ate the diamond");

				}
				else {
					
				}

			}
			
		}
		// 2. How many innocent crows had to die before the diamond was found?
		if (crowNum-1 == 1) {
			System.out.println(crowNum-1 + " innocent crow died to find the diamond");
		}
		else {
		System.out.println(crowNum-1 + " innocent crows died to find the diamond");
		}
	}

	private void initializeCrows() {
		theMurder.add(new Crow("Rok"));
		theMurder.add(new Crow("Merle"));
		theMurder.add(new Crow("Poe"));
		theMurder.add(new Crow("Grenwyn"));
		theMurder.add(new Crow("Crawford"));
		hideTheDiamond();
	}

	private void hideTheDiamond() {
		int randomness = new Random().nextInt(theMurder.size());
		theMurder.get(randomness).getStomachContents().add("diamond");
	}
}

class Crow {
	private String name;
	private ArrayList<String> stomachContents = new ArrayList<String>();

	public Crow(String name) {
		this.name = name;
		fillCrowsStomach();
	}

	private void fillCrowsStomach() {
		for (int i = 0; i < 10; i++)
			this.stomachContents.add(getRandomCrowFood());
	}

	private String getRandomCrowFood() {
		int randomness = new Random().nextInt(4);
		if (randomness == 0)
			return "carrion";
		else if (randomness == 1)
			return "snail";
		else if (randomness == 2)
			return "acorn";
		else if (randomness == 3)
			return "spider";
		else
			return "grub";
	}

	public String getName() {
		return name;
	}

	public ArrayList<String> getStomachContents() {
		return stomachContents;
	}
}
