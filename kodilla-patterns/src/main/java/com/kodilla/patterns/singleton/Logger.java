package com.kodilla.patterns.singleton;

enum Logger {
    INSTANCE;
    private String lastLog = "";

    void log(final String log) {
        lastLog = log;
        System.out.println("Log: [" + log + "]");
    }

    String getLastLog() {
        return lastLog;
    }
}