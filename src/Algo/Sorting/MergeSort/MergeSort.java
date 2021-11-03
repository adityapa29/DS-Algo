package Algo.Sorting.MergeSort;

import java.util.Arrays;

public class MergeSort {
	
	private static void merge_sort(int[] arr,int left,int right,int[] temp) {
		if(left < right)
		{
			int mid = (left+right)/2;
			merge_sort(arr,left,mid,temp);
			merge_sort(arr,mid+1,right,temp);
			merge(arr,left,mid,right,temp);
		}
	}
	
	private static void merge(int[] arr,int left,int mid,int right,int[] temp) {
		int i = left;
		int j = mid+1;
		int k = left;
		
		while(i<=mid && j<=right) {
			if(arr[i] <= arr[j]) {
				temp[k] = arr[i++];
			} else {
				temp[k] = arr[j++];
			}
			k++;
		}
		
		if(i <= mid) {
			while(i <= mid) {
				temp[k++] = arr[i++];
			}
		}else {
			while(j <= right) {
				temp[k++] = arr[j++];
			}
		}
		
		for(int c=left; c<=right; c++)
		{
			arr[c] = temp[c];
		}

	}
	
	public static void main(String[] args) {
		int[] arr = {121,54,23,87,26,48,76,21,13,1,6,9,43,77,88};
		int[] temp = new int[arr.length];
		merge_sort(arr,0,arr.length-1,temp);
		System.out.println(Arrays.toString(temp));
	}

}
