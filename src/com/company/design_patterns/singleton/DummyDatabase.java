package com.company.design_patterns.singleton;

import java.util.Dictionary;
import java.util.Hashtable;

public class DummyDatabase implements Database {
    private Dictionary<String, Integer> data = new Hashtable<>();

    public DummyDatabase() {
        data.put("alpha", 1000);
        data.put("beta", 2000);
        data.put("gamma", 3000);
    }

    @Override
    public int getPopulation(String name) {
        return data.get(name);
    }
}
