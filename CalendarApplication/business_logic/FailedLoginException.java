package business_logic;

public class FailedLoginException extends Exception {
	private static final long serialVersionUID = 1L;

	public FailedLoginException(String message) {
		super(message);
	}
}
