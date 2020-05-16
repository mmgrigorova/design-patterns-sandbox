package com.company.solid_principles.open_close_principle;

import com.company.solid_principles.open_close_principle.enums.Color;
import com.company.solid_principles.open_close_principle.enums.Size;

public class Product {
    private final Color color;
    private final Size size;
    private final String name;

    public Product(String name, Color color, Size size) {
        this.color = color;
        this.size = size;
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "A " + name + " with color " + color + " and size " + size;
    }
}
