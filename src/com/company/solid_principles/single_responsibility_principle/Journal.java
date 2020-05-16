package com.company.solid_principles.single_responsibility_principle;

import java.util.ArrayList;
import java.util.List;

public class Journal {
    private List<String> entries = new ArrayList<>();
    private static int count = 0;

    public Journal() {
    }

    public void add(String entry){
        entries.add(entry);
        count++;
    }

    @Override
    public String toString() {
        return "" + count + " journal entries: " + System.lineSeparator() +
                String.join(System.lineSeparator(), entries);
    }
}
