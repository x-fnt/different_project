package xfnt;

public class LoggerFactory {
    private static ILogger currentLogger;

    public static ILogger createLogger() {
        currentLogger = new ConsoleLogger(LoggerLevel.STEP);
        return currentLogger;
    }

    public static ILogger getLogger() {
        return currentLogger;
    }

    public static ILogger getLogger(LoggerLevel loggerLevel) {
        currentLogger = new ConsoleLogger(loggerLevel);
        return currentLogger;
    }

    public static void changeLoggerLevel(LoggerLevel loggerLevel) {
        currentLogger = new ConsoleLogger(loggerLevel);
    }

    public static void step(String message) {
        currentLogger.step(message);
    }

    public static void info(String message) {
        currentLogger.info(message);
    }

    public static void debug(String message) {
        currentLogger.debug(message);
    }
}
