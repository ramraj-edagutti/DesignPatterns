package pattern.factory.method.logger;

public class TextLogger implements Logger {

	@Override
	public void log(String message) {
		System.out.println("Print into text logger");
		System.err.println(message);
	}

}
