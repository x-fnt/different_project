package xfnt;

import static xfnt.TextColor.*;

public class ConsoleLogger implements ILogger {
    private LoggerLevel loggerLevel;

    public ConsoleLogger(LoggerLevel loggerLevel) {
        this.loggerLevel = loggerLevel;
    }

    private void log(LoggerLevel level, String message) {
        if (level.getPriority() <= loggerLevel.getPriority()) {
            switch (level) {
                case STEP -> System.out.println(String.format("%s[%s] %s%s", ANSI_GREEN.getAnsiCode(), level, message, ANSI_RESET.getAnsiCode()));
                case INFO -> System.out.println(String.format("%s[%s] %s%s", ANSI_BLUE.getAnsiCode(), level, message, ANSI_RESET.getAnsiCode()));
                case DEBUG -> System.out.println(String.format("%s[%s] %s%s", ANSI_RED.getAnsiCode(), level, message, ANSI_RESET.getAnsiCode()));
            }
        }
    }

    @Override
    public void step(String msg) {
        log(LoggerLevel.STEP, msg);
    }

    @Override
    public void info(String msg) {
        log(LoggerLevel.INFO, msg);
    }

    @Override
    public void debug(String msg) {
        log(LoggerLevel.DEBUG, msg);
    }

    public void setLoggerLevel(LoggerLevel loggerLevel) {
        this.loggerLevel = loggerLevel;
    }
}
