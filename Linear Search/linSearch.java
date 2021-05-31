/**
 * The class below performs a linear search of an array.
 * This array can be sorted or unsorted.
 * 
 * The linear search has a Big O runtime of O(n)
 * 
 * @version April 1, 2020
 * */

public class linSearch {

	public static void main(String[] args) {
		int[] intArr = {1, 2, 3, 4, 5, 6, 7};
		int val = 7;
		System.out.println(searchArr(intArr, val));
	}
	
	public static int searchArr(int[] a, int b) {
		int index = 0;
		
		for (int i = 0; i < a.length; i++) {
			if (b == a[i]) index = i;
			else index = -1;
		}
		return index;
		
	}

}
