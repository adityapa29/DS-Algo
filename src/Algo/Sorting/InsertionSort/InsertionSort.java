package Algo.Sorting.InsertionSort;

import java.util.Arrays;

public class InsertionSort {

	private static void insertion_sort(int[] arr,int n)
	{
		int key=1;
		for(; key<n; key++) {
			for(int j=key; j>0; j--) {
				if(arr[j-1] > arr[j]) {
					int t = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = t;
				} else break;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		int[] input = {10,5,3,7,2,8,6,4,1};
		int n = input.length;
		insertion_sort(input,n);
	}

}
