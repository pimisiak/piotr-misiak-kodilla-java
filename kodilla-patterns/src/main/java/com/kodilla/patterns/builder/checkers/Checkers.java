package com.kodilla.patterns.builder.checkers;

class Checkers {
    private final Board board;
    private final String playerOne;
    private final String playerTwo;

    private Checkers(final Builder builder) {
        this.board = builder.board;
        this.playerOne = builder.playerOne;
        this.playerTwo = builder.playerTwo;
    }

    Board getBoard() {
        return board;
    }

    String getPlayerOne() {
        return playerOne;
    }

    String getPlayerTwo() {
        return playerTwo;
    }

    static class Builder {
        private Board board = new Board();
        private String playerOne = "";
        private String playerTwo = "";

        Builder playerOne(final String playerOne) {
            this.playerOne = playerOne;
            return this;
        }

        Builder playerTwo(final String playerTwo) {
            this.playerTwo = playerTwo;
            return this;
        }

        Builder figure(final String figureType, final String figureColor, final int x, final int y) {
            if (x > Board.MAX_INDEX || x < Board.MIN_INDEX || y > Board.MAX_INDEX || y < Board.MIN_INDEX) {
                throw new IllegalStateException(String.format("x and y should be in range between %d and %d", Board.MIN_INDEX, Board.MAX_INDEX));
            }
            if (board.getFigure(x, y) != null) {
                throw new IllegalStateException(String.format("Position %d,%d is already occupied", x, y));
            }
            board.setFigure(FigureFactory.makeFigure(figureType, figureColor), x, y);
            return this;
        }

        Checkers build() {
            if (playerOne.length() == 0) {
                throw new IllegalStateException("There is no player One specified!");
            }
            if (playerTwo.length() == 0) {
                throw new IllegalStateException("There is no player Two specified");
            }
            boolean white = false;
            boolean black = false;
            for (int x = Board.MIN_INDEX; x <= Board.MAX_INDEX; x++) {
                for (int y = Board.MIN_INDEX; y <= Board.MAX_INDEX; y++) {
                    final Figure figure = board.getFigure(x, y);
                    if (figure != null) {
                        if (figure.getColor().equals(Figure.BLACK)) {
                            black = true;
                        } else {
                            white = true;
                        }
                    }
                }
            }
            if (!(black && white)) {
                throw new IllegalStateException("There are no figures of both colors on the board!");
            }
            return new Checkers(this);
        }
    }
}
