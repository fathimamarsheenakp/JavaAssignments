package MatrimoneyApp;

public class OverAgeException extends Exception{
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "You are too old, can't get marry at this age!";
	}
}
