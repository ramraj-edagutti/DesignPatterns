package pattern.factory.method.logger;

public class XMLLoggerFactory extends AbstractLoggerFactory {

	@Override
	public Logger createLogger() {
		return new XMLLogger();
	}

}
