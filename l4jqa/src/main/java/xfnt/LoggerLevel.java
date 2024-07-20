package xfnt;

public enum LoggerLevel {
    STEP(0, "STEP"),
    INFO(1, "INFO"),
    DEBUG(2, "DEBUG");

    private final String name;
    private final int priority;

    LoggerLevel(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    public static LoggerLevel fromName(String name) {
        for (LoggerLevel level : LoggerLevel.values()) {
            if (level.getName().equalsIgnoreCase(name)) {
                return level;
            }
        }
        throw new IllegalArgumentException("No enum constant with name " + name);
    }
}
