package com.kodilla.patterns.builder.checkers;

final class FigureFactory {
    static final String PAWN = "PAWN";
    static final String QUEEN = "QUEEN";

    static Figure makeFigure(final String figureType, final String color) {
        switch (figureType) {
            case PAWN:
                return new Pawn(color);
            case QUEEN:
                return new Queen(color);
            default:
                throw new IllegalStateException("Type of figure should be pawn or queen");
        }
    }
}
