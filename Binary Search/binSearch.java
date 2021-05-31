/**
 * The class below performs a binary search of an array.
 * To do this successfully, that array has to be sorted so
 * that the binary search can perform a divide and conquer
 * 
 * The linear search has a Big O runtime of O(1/2n)
 * 
 * @version April 1, 2020
 * */

public class binSearch {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		int val = 10;
		System.out.println(searchArr(arr, val));

	}
	
	public static int searchArr(int[] a, int b){
		int start = 0;
		int end = a.length-1;
		int middle = (start + end) / 2;
		
		while (a[middle] != b && start <= end) {
			
			if (b < a[middle]) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}

			middle = (start + end) / 2;
		}
		
		if (a[middle] == b)
			return middle;
		else
			return -1;

		//return (int) (a[(int) middle] == b ? middle : -1);
		
	}

}
