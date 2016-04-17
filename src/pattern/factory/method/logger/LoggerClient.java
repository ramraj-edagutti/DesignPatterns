package pattern.factory.method.logger;

public class LoggerClient {
	
	public static void main(String[] args) {
		AbstractLoggerFactory loggerFactory = new TextLoggerFactory();
		Logger logger = loggerFactory.getLogger();
		logger.log("Print message ");
		
		logger = new XMLLoggerFactory().getLogger();
		logger.log("Print message ");
	}

}
