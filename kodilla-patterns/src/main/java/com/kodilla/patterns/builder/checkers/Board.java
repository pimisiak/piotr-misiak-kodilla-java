package com.kodilla.patterns.builder.checkers;

class Board {
    static final int MIN_INDEX = 0;
    static final int MAX_INDEX = 9;
    final Figure[][] board = new Figure[10][];

    Board() {
        for (int n = 0; n < 10; n++) {
            board[n] = new Figure[10];
        }
    }

    Figure getFigure(final int x, final int y) {
        return board[x][y];
    }

    void setFigure(final Figure figure, final int x, final int y) {
        board[x][y] = figure;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        for (int n = MIN_INDEX; n <= MAX_INDEX; n++) {
            result.append("|");
            for (int k = MIN_INDEX; k <= MAX_INDEX; k++) {
                if (board[n][k] == null) {
                    result.append("  ");
                } else {
                    result.append((board[n][k]).getColor().equals(Figure.BLACK) ? "b" : "w");
                    result.append((board[n][k]) instanceof Pawn ? "P" : "Q");
                }
                result.append("|");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
