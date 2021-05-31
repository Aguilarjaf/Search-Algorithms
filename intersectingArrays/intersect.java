package intersectingArrays;

import java.util.ArrayList;
import java.util.List;

public class intersect {
	
	public static void main(String[] args) {
		int[] arrayOne = {1, 3, 4, 5, 7, 8, 9, 10, 11};
		int[] arrayTwo = {0, 0, 0, 0, 3, 0, 0, 10};
		
		System.out.println(intersectArrray(arrayOne, arrayTwo));
	}

	
	public static String intersectArrray(int[] a, int[] b) {
		List<Integer> results = new ArrayList<>();
		int i = 0;
		int j = 0;
		
		while(i < a.length && j < b.length) {
			
			if (a[i] < b[j]) {
				i++;
			} else if (a[i] == b[j]) {
				results.add(a[i]);
				j++;
			} else {
				j++;
			}
		}
		
		return results.toString();
		
	}
}
