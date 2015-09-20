package toolkit;

/**
 * @description Generic exception used to signify a failure. Use this exception
 *              in your test or Helper whenever a test fails, test class should
 *              automatically catch this exception
 * @author amrit kumar
 */

public class TestWebinarException extends RuntimeException {

	public TestWebinarException() {
		super();
	}

	public TestWebinarException(String error) {
		super(error);
	}

}
