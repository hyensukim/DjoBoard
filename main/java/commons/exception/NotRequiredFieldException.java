package commons.exception;

// 필수요소 없는 경우 예외 발생
public class NotRequiredFieldException extends RuntimeException  {
	public NotRequiredFieldException(String message) {
		super(message);
	}
}
