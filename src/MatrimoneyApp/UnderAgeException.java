package MatrimoneyApp;

public class UnderAgeException extends Exception {
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Kid, you are not allowed to get marry!";
	}
}
