package com.company.design_patterns.prototype;

public class Line {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy() {
        return new Line(new Point(this.start), new Point(this.end));
    }

    @Override
    public String toString() {
        return "Line goes " +
                "from (" + start +
                "), to (" + end + ")";
    }
}