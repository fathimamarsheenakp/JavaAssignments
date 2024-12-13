package SearchingSortingApp;

import java.util.Scanner;

public class SearchingSortingAlgos {
	static Scanner scanner = new Scanner(System.in);
	
	public void chooseSearchOrSort(int[] arr) {
		while (true) {
			System.out.println("=================================================================");
			System.out.println("Choose search or sort: \n 1. Press 1 for searching \n 2. Press 2 for sorting \n 3. Press 3 to exit");
			int ch = scanner.nextInt();
			
			switch (ch) {
			case 1 :
				System.out.println("Choose Linear search or Binary Search \n a. Linear Search \n b. Binary Search");
				char ch1 = scanner.next().charAt(0);
				System.out.println();
				
				switch (ch1) {
				case 'a' :
					linearSearch(arr, getKey());
					System.out.println();
					break;
				case 'b': 
					int[] sortedArr = chooseSorting(arr);
					display(sortedArr);
					System.out.println();
					binarySearch(sortedArr, getKey());
					System.out.println();
					break;
					
				default: 
					linearSearch(arr, getKey());
					System.out.println();
					break;
				}
				break;
			case 2 :
				int[] sortedArr = chooseSorting(arr);
				display(sortedArr);
				System.out.println();
				break;
			default: 
				System.out.println("                       Thank You!");
				System.exit(0);
			}
		}
	}
	
	public static int[] chooseSorting(int[] arr) {
		System.out.println("Choose algorithm for sorting: \n b. Bubble Sort \n s. Selection Sort \n i. Insertion Sort");
		int ch2 = scanner.next().charAt(0);
		switch (ch2) {
		case 'b':
			bubbleSort(arr);
			System.out.println();
			break;
		case 's':
			selectionSort(arr);
			System.out.println();
			break;
		case 'i':
			insertionSort(arr);
			System.out.println();
			break;
		default :
			bubbleSort(arr);
			System.out.println();
		}
		return arr;
	}
	
	public static int getKey() {
		System.out.println("Enter a key to search: ");
		int key = scanner.nextInt();
		return key;
	}
	
	public static void linearSearch(int[] arr, int key) {
		for (int i = 0; i <= arr.length - 1; i++) {
			if (arr[i] == key) {
				System.out.println("Key " + key + " found at index " + i + ".");
				return;
			}
		}
		System.out.println("Key " + key + " not found.");
	}
	
	public static void binarySearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length - 1;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			
			if (arr[mid] == key) {
				System.out.println("Key " + key + " found at index " + mid + ".");
				return;
			} else if (arr[mid] > key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println("Key " + key + " not found.");
	}
	
	public static int[] bubbleSort(int[] arr) {
		for (int i = 0; i <= arr.length - 2; i++) {
			for (int j = 0; j <= arr.length - 2 - i; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	
	public static int[] selectionSort(int[] arr) {
		
		for (int i = 0; i <= arr.length - 2; i++) {
			int min = arr[i];
			int pos = i;
			
			for (int j = i+1; j <= arr.length - 1; j++) {
				if (arr[j] < min) {
					min = arr[j];
					pos = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[pos];
			arr[pos] = temp;
			
		}
		return arr;
		
	}
	
	public static int[] insertionSort(int[] arr) {
		
		for (int i = 1; i <= arr.length - 1; i++) {
			int item = arr[i];
			int j = i - 1;
			
			while (j >= 0 && arr[j] > item) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = item;
		}
		return arr;
		
	}
	
	public static void display(int[] arr) {
		System.out.print("After sorting: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
} 
