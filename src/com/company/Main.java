package com.company;

import com.company.solid.single_responsibility_principle.Journal;
import com.company.solid.single_responsibility_principle.Persistence;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        /*
         *   Single responsibility principle demo
         */
        Journal journal = new Journal();
        journal.add("I went hiking yesterday");
        journal.add("I ate soup today");

        Persistence p = new Persistence();
        try {
            p.saveToFile(journal, "srp-test", true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
