package com.company.design_patterns.singleton;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class Tests {
    @Test
    public void isSingletonTest(){
        SingletonDatabase db = SingletonDatabase.getInstance();
        SingletonDatabase db2 = SingletonDatabase.getInstance();
        assertSame(db, db2);
    }

    @Test
    public void dependentPopulationTest() {
        DummyDatabase db = new DummyDatabase();
        ConfigurableRecordFinder finder = new ConfigurableRecordFinder(db);
        assertEquals(4000, finder.getTotalPopulation(
                Arrays.asList("alpha", "gamma")
        ));
    }
}
