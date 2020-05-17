package com.company.design_patterns.adapter;

public class SquareToRectangleAdapter implements Rectangle {
    private final Square square;

    public SquareToRectangleAdapter(Square square) {
        this.square = square;
    }

    @Override
    public int getWidth() {
        return square.side;
    }

    @Override
    public int getHeight() {
        return this.getWidth();
    }
}
