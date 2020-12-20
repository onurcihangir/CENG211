package exceptions;

@SuppressWarnings("serial")
public class IDNotCorrectException extends Exception {
	
	private String message = "Sender ID does not consist of 11 digits!!";
	
	public IDNotCorrectException() {
		super("Sender ID does not consist of 11 digits!!");
	}
	
	public IDNotCorrectException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
