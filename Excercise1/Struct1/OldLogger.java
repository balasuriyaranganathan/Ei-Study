class OldLogger {
    public void logMessage(String message) {
        System.out.println("Old logger: " + message);
    }
}

class NewLogger {
    public void writeLog(String message) {
        System.out.println("New logger: " + message);
    }
}

class LoggerAdapter extends OldLogger {
    private NewLogger newLogger;

    public LoggerAdapter(NewLogger newLogger) {
        this.newLogger = newLogger;
    }

    @Override
    public void logMessage(String message) {
        newLogger.writeLog(message);
    }
}