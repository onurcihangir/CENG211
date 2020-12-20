package exceptions;

@SuppressWarnings("serial")
public class CodeFormatIncorrectException extends Exception {
	
	private String message;
	
	public CodeFormatIncorrectException() {
		super("Cargo code format is not appropriate!!");
	}
	
	public CodeFormatIncorrectException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}


}
