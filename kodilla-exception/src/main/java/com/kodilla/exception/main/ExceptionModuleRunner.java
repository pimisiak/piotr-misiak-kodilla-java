package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;

public class ExceptionModuleRunner {
    public static void main(final String[] args) {
        FileReader fileReader = new FileReader();
        fileReader.readFile();
    }
}
