/*
 * This was a test for progam for a microsoft internship, written in under the hour given
 * This task given was to write a program which takes n dates in the form "4th May 1922" and outputs the date as "1922-05-04"
 * There is no need to validate the input
 * Here the main specifies the string, but in the actual submission, the input was user entered.
 */

import java.io.*;
import java.util.*;

public class Test2DateReformat {

	public static void main(String[] args) throws Exception {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> dates = new ArrayList<String>();
		String[] oldBits = new String[3];
		String[] newBits = new String[3];


		// how many dates?
		int n = 0;
        
        while (n < 1 || n > 10000) {
           n = Integer.parseInt(br.readLine());
        }

		// get the dates
		for (int i = 0; i < n; i++) {
			dates.add(br.readLine());
		}

		// split the dates into vits
		for (int i = 0; i < dates.size(); i++) {
			oldBits = dates.get(i).split(" ");
			
			// the year is bought to the front
			newBits[0] = oldBits[2];
			
			//a switch converts from the string to the number
			switch (oldBits[1]) {
			case "Jan":
				newBits[1] = ("0" + 1);
				break;
			case "Feb":
				newBits[1] = ("0" + 2);
				break;
			case "Mar":
				newBits[1] = ("0" + 3);
				break;
			case "Apr":
				newBits[1] = ("0" + 4);
				break;
			case "May":
				newBits[1] = ("0" + 5);
				break;
			case "Jun":
				newBits[1] = ("0" + 6);
				break;
			case "Jul":
				newBits[1] = ("0" + 7);
				break;
			case "Aug":
				newBits[1] = ("0" + 8);
				break;
			case "Sep":
				newBits[1] = ("0" + 9);
				break;
			case "Oct":
				newBits[1] = ("" + 10);
				break;
			case "Nov":
				newBits[1] = ("" + 11);
				break;
			case "Dec":
				newBits[1] = ("" + 12);
				break;
			default:
				System.out.println("invalid input");
				throw new Exception();

			}
			
			//either a single or double digit is extracted..
			if (oldBits[0].length() == 3) {
				newBits[2] = ("0" + oldBits[0].substring(0, 1));
			} else {
				newBits[2] =  oldBits[0].substring(0, 2);
			}
			
			System.out.println(newBits[0] + "-" + newBits[1] + "-" +  newBits[2]);
            

		}
        
    br.close();
    System.exit(0);
    }
}
		