/**
 * The class below performs a naive string search.
 * It does this by seeing how many times a substring
 * exists in a string.
 * 
 * The naive string search has a Big O runtime of O(n^2)
 * 
 * @version April 1, 2020
 * */

public class naiveSearch {

	public static void main(String[] args) {
		String longString = "lorie loled";
		String shortString = "lo";
		
		System.out.println(navSearch(longString, shortString));

	}
	
	public static int navSearch(String longStr, String shortStr) {
		int count = 0;
		
		for(int i = 0; i < longStr.length(); i++) {
			for (int j = 0; j < shortStr.length(); j++) {
				if(shortStr.charAt(j) != longStr.charAt(i+j)) break;
				if (j == shortStr.length() - 1) count++;
			}
		}
		
		return count;
	}

}
