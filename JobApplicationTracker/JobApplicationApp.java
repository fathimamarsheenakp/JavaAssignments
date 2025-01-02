package JobApplicationTracker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class JobApplicationApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the company name: ");
		String company = sc.nextLine();
		
		System.out.println("Enter the application date (eg: 25th Oct)");
		String date = sc.nextLine();
		
		String entry = "Applied to " + company + " on " + date + "\n";
		
		BufferedWriter writer = null;
		
		try {
			
			writer = new BufferedWriter(new FileWriter("C:\\Users\\fathi\\OneDrive\\Desktop\\Kodnest\\Java\\File\\applications.txt", true));
			writer.write(entry);
			System.out.println("Your application has been logged.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
