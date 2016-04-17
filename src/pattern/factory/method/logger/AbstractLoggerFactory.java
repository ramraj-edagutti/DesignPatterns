package pattern.factory.method.logger;

public abstract class AbstractLoggerFactory {

	//the factory method
	public abstract Logger createLogger();

	public Logger getLogger() {
		//depending on the subclass, we'll get a particular logger.
		Logger logger = createLogger();

		//could do other operations on the logger here

		return logger;
	}

}
