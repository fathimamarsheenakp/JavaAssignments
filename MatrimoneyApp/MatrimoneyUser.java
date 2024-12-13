package MatrimoneyApp;

public class MatrimoneyUser {

	String name;
	int age;
	String gender;
	
	public MatrimoneyUser(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public void acceptData() throws Exception {
		if (age >= 21 && age <= 50) {
			System.out.println("You will get married soon:)");
		} else if (age < 21) {
			UnderAgeException uae = new UnderAgeException();
			System.out.println(uae.getMessage());
			throw uae;
		} else {
			OverAgeException oae = new OverAgeException();
			System.out.println(oae.getMessage());
			throw oae;
		}
	}
	
}
