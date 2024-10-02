public class Main {
    public static void main(String[] args) {
        OldLogger oldLogger = new OldLogger();
        NewLogger newLogger = new NewLogger();
        LoggerAdapter loggerAdapter = new LoggerAdapter(newLogger);

        oldLogger.logMessage("This is an old log");
        loggerAdapter.logMessage("This is a new log");
    }
}
