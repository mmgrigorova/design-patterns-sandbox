package com.company.design_patterns.builder;

public class Field {
    private final String name;
    private final String type;

    public Field(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("  public %s %s;\n", type, name);
    }
}
