/*
 * Name: 		Joe Duffin
 * Student No:	13738019
 * Date: 		29th Jan 2014
 * Practical:	1
 * Filename:	Practical1.java
 * 
 * Notes:
 * This file assumes that it is in the default package (src/) along with ListMap.java, Map.java and Entry.java.
 * Other java files are then imported from dsa.core and dsa.impl
 */


import dsa.core.*;
import dsa.impl.*;

public class Practical1 {
	
	/**
	 * Main implements the Tasks required for Practical 1
	 */
	public static void main(String args[]) {
		ListMap<String, String> myMap = new ListMap<String, String>();

		System.out.println("Printing State of Map after each operation");
		// Task 1 (and 2): entries are inserted, and removed, the state of the map is then printed
		myMap.put("ie", "Ireland");
		printMap(myMap);

		myMap.put("uk", "United Kingdom");
		printMap(myMap);

		myMap.put("us", "USA");
		printMap(myMap);

		myMap.put("de", "Germany");
		printMap(myMap);

		myMap.put("fr", "France");
		printMap(myMap);

		myMap.remove("uk");
		printMap(myMap);

		//This amends the original value associated with key "us"
		myMap.put("us", "United States of America");
		printMap(myMap);

		myMap.put("es", "Spain");
		printMap(myMap);

		myMap.put("uk", "United Kingdom");
		printMap(myMap);
		
		// A value is retrieved from the map using a key,
		System.out.println("\nGetting the value stored with key \"us\":");
		System.out.println(myMap.get("us"));

		
		// Task 3: Printing the Map by a list of lexicographically sorted keys

		// The list of sorted keys is created
		List<String> sortedKeys = sortedKeys(myMap);

		// If an empty map was passed to sortedKeys(), sortedKeys would be null
		if (sortedKeys != null) {
		// Both the sorted list of keys, and values associated with the keys are printed (separately)
		System.out.println("\nSorted List of keys:");
		printSortedKeys(sortedKeys);
		
		System.out.println("\nEntries when sorted by key:");
		printEntriesBySortedKeys(sortedKeys, myMap);
		} else {
			System.out.println("Your Map is EMPTY!");

		}

	}
	
	/**
	 * Uses a list of keys to print values of a map.
	 * 
	 * @param sortedKeys - A list of keys to use to find values
	 * @param myMap - The map to 'look up' with the keys
	 */
	private static void printEntriesBySortedKeys(List<String> sortedKeys, ListMap<String, String> myMap) {
		//The iterator "it" is used to iterate through and print the entries of the map
		Iterator<String> it = sortedKeys.iterator();
		while (it.hasNext()) {
			System.out.println(myMap.get(it.next()));
		}
		
	}

	/**
	 * Prints a List
	 * 
	 * @param sortedKeys - the list to be printed
	 */
	private static void printSortedKeys(List<String> sortedKeys) {
		//Again with the iterator, but this time its the elements of a List,
		Iterator<String> it = sortedKeys.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	/**
	 * Prints a formatted map on one line, relying on the toString method of the entries
	 *
	 * @param map - The map to be printed
	 */
	public static void printMap(Map<String, String> map) {
		// Using the toString method implicitly and an iterator the entries are printed,
		Iterator<Entry<String, String>> it = map.entries();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println();
	}
	
	/**
	 * This method lexicographically builds a list of keys of a map.
	 * 
	 * @param map - The map to extract the keys from
	 * @return - A list of keys in lexicographical order is returned
	 */
	public static List<String> sortedKeys(Map<String, String> map) {
		List<String> sortedKeys = new LinkedList<String>();
		Iterator<String> it = map.keys();
		Position<String> p;
		String bar = ""; // a temp value

		if (it.hasNext()) { //If the iterator allows, the first key is inserted into the list
			sortedKeys.insertFirst(it.next());
		} else {
			return null; //returns null if map is empty
		}
		
		while (it.hasNext()) {
			
			bar = it.next(); // A key is grabbed and stored
			p = sortedKeys.first(); // The position of the start of the sorted keys list is grabbed and stored
			
			while (p != null && bar.compareTo((String) p.element()) > 0) {
				//the list of sorted keys is scanned to find where "bar" needs to be inserted
				p = sortedKeys.next(p);
			}
			
			//"bar" is inserted in the correct position
			if (p == null) {
				sortedKeys.insertLast(bar);
			} else {
				sortedKeys.insertBefore(p, bar);
			}
			
		}
		
		return sortedKeys; //yeah,
	}
}