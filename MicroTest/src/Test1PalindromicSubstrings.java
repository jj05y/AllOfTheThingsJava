/*
 * This was a test for progam for a microsoft internship, written in under the hour given
 * This task given was to write a function that returns the number of distinct substrings in a given string,
 * Here the main specifies the string, but in the actual submission, the input was user entered.
 */


import java.util.ArrayList;

public class Test1PalindromicSubstrings {


	static int palindrome(String str) {

		String tempString;
		ArrayList<String> subStrings = new ArrayList<String>();
		boolean unique = true;

		for (int start = 0; start < str.length(); start++) {
			for (int finish = start + 1; finish <= str.length(); finish++) {
				unique = true;
				tempString = str.substring(start, finish);
				if (test(tempString)) {
					if (subStrings.size() == 0) {
						subStrings.add(tempString);
					} else {
						for (int i = 0; i < subStrings.size(); i++) {
							if (subStrings.get(i).compareTo(tempString) == 0) {
								unique = false;
							}
						}
						if (unique) {
							subStrings.add(tempString);
						}
					}

				}

			}
		}

		return subStrings.size();

	}

	static boolean test(String str) {
		boolean isPal = true; 

		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1)) {
				isPal = false;
			}
		}
		return isPal;
	}

	public static void main(String[] args)  {
		
		String _str = "aabaa";

		System.out.println(palindrome(_str));
	}
}