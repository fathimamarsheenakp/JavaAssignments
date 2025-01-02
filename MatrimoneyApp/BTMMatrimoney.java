package MatrimoneyApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BTMMatrimoney {
	void initiateRegistration() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name, age and gender");
		try {
			MatrimoneyUser user = new MatrimoneyUser(sc.next(), sc.nextInt(), sc.next());
			try {
				user.acceptData();
			} catch (Exception e) {
				System.out.println("You are not allowed to register.");
			}
		} catch (InputMismatchException e) {
			System.out.println("InputMismatchException");
		}
	}
}
