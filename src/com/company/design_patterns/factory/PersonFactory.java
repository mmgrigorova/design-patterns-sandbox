package com.company.design_patterns.factory;

public class PersonFactory {
    private static int count = 0;

    public static PersonInst createPerson(String name) {
        PersonInst p = new PersonInst(count, name);
        count++;
        return p;
    }
}