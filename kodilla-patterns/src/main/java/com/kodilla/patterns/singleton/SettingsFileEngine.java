package com.kodilla.patterns.singleton;

class SettingsFileEngine {
    private static SettingsFileEngine settingsFileEngineInstance = null;
    private String fileName = "";

    private SettingsFileEngine(){}

    static SettingsFileEngine getInstance() {
        if (settingsFileEngineInstance == null) {
            settingsFileEngineInstance = new SettingsFileEngine();
        }
        return settingsFileEngineInstance;
    }

    String getFileName() {
        return fileName;
    }

    void open(final String fileName) {
        this.fileName = fileName;
        System.out.println("Opening the settings file");
    }

    void close() {
        this.fileName = "";
        System.out.println("Closing the settings file");
    }

    boolean loadSettings() {
        System.out.println("Loading settings from file");
        return true;
    }

    boolean saveSettings() {
        System.out.println("Saving settings to file");
        return true;
    }
}
