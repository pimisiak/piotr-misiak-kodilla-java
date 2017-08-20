package com.kodilla.exception.test;

class SecondChallenge {
    String probablyWillThrowException(final double x, final double y) throws Exception {
        if (x >= 2 || x < 1 || y == 1.5) {
            throw new Exception();
        }
        return "Done!";
    }
}
