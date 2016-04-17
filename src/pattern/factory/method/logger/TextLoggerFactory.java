package pattern.factory.method.logger;

public class TextLoggerFactory extends AbstractLoggerFactory {

	@Override
	public Logger createLogger() {
		return new TextLogger();
	}

}
