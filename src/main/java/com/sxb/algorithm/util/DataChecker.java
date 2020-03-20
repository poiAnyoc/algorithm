package com.sxb.algorithm.util;

import java.util.Arrays;
import java.util.Random;

public class DataChecker {
	
	static int[] generateRandomArray() {
		Random r = new Random();

		int[] arr = new int[100];

		for (int i = 0; i < arr.length; i++){
			arr[i] = r.nextInt(100);
		}

		return arr;
	}
	
	static void testCheck() {
		boolean same = true;
		for(int times = 0; times < 1000; times++) {
			int[] arr = generateRandomArray();
			int[] arr2 = new int[arr.length];
			System.arraycopy(arr, 0, arr2, 0, arr.length);
			
			Arrays.sort(arr);
			//SelectionSort.sort(arr2);
//			BubbleSort.testSort2(arr2);
			//InsertionSort.sort(arr2);
			//ShellSort.sort(arr2);
			//MergeSort.sort(arr2, 0, arr2.length-1);
//			QuickSort.sort(arr2, 0, arr2.length-1);
			
			
			for (int i = 0; i < arr2.length; i++) {
				if(arr[i] != arr2[i]) {
					same = false;
				}
			}
		}
		System.out.println(same ? "right" : "wrong");
		
	}

	public static void checkArray(Integer[] array){
		Integer[] copyArray = new Integer[array.length];
		System.arraycopy(array, 0, copyArray, 0, array.length);
		boolean same = true;

		Arrays.sort(copyArray);
		for (int i = 0; i < array.length; i++) {
			if(!array[i].equals(copyArray[i])) {
				same = false;
			}
		}

		System.out.println(same ? "right" : "wrong");
	}

	public static void main(String[] args) {
//		testCheck();
	}
}
