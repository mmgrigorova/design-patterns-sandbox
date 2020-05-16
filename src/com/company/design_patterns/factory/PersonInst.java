package com.company.design_patterns.factory;

public class PersonInst {
    private final int id;
    private final String name;

    protected PersonInst(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person " + id + ", with name " + name;
    }
}

