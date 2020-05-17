package com.company.design_patterns.adapter;

public interface Rectangle {
    int getWidth();
    int getHeight();

    default int getArea()
    {
        return getWidth() * getHeight();
    }
}
