package com.kodilla.patterns.singleton;

class Logger {
    private static Logger loggerInstance = null;
    private String lastLog = "";

    private Logger() {}

    static Logger getInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger();
        }
        return loggerInstance;
    }

    void log(final String log) {
        lastLog = log;
        System.out.println("Log: [" + log + "]");
    }

    String getLastLog() {
        return lastLog;
    }
}