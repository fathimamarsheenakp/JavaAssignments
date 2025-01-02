package SearchingSortingApp;

import java.util.Scanner;

public class SearchingSortingApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the array length: ");
		int[] arr = new int[scanner.nextInt()];
		
		System.out.println("Enter array elements: ");
		for (int i = 0; i <= arr.length - 1; i++) {
			arr[i] = scanner.nextInt();
		}
		
		SearchingSortingAlgos algos = new SearchingSortingAlgos();
		algos.chooseSearchOrSort(arr);
	}
}
