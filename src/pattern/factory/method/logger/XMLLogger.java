package pattern.factory.method.logger;

public class XMLLogger implements Logger {

	@Override
	public void log(String message) {
		System.out.println("Print into xml logger");
		System.err.println(message);
	}

}
