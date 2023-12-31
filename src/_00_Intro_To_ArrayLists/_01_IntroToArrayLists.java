package _00_Intro_To_ArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
    public static void main(String[] args) {
        // 1. Create an array list of Strings
        //    Don't forget to import the ArrayList class
    	ArrayList<String> things = new ArrayList<String>();
        // 2. Add five Strings to your list
    	things.add("banana");
    	things.add("mouse");
    	things.add("PC");
    	things.add("String e");
    	things.add("ArrayList");
        // 3. Print all the Strings using a standard for-loop
    	for (int i = 0; i < things.size(); i++) {
    		System.out.println(things.get(i));
    	}
    	System.out.println("\n");
        // 4. Print all the Strings using a for-each loop
    	for(String i : things){
    		System.out.println(i + "");
    	}
    	System.out.println("\n");
        // 5. Print only the even numbered elements in the list.
    	for (int i = 0; i < things.size(); i++) {
    		if (i%2 == 0) {
    		System.out.println(things.get(i));
    		}
    	}
    	System.out.println("\n");
        // 6. Print all the Strings in reverse order.
    	for (int i = things.size()-1; i >= 0; i--) {
    		System.out.println(things.get(i));
    	}
    	System.out.println("\n");
        // 7. Print only the Strings that have the letter 'e' in them.
    	for (int i = 0; i < things.size(); i++) {
    		if(things.get(i).contains("e") == true) {
    			System.out.println(things.get(i));
    		}
    	}
    	System.out.println("\n");
    }
}
