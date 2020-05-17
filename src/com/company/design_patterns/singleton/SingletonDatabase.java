package com.company.design_patterns.singleton;

import com.google.common.collect.Iterables;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class SingletonDatabase implements Database {
    private Dictionary<String, Integer> capitals = new Hashtable<>();
    private static SingletonDatabase INSTANCE;

    private SingletonDatabase() {
        System.out.println("Initializing database");

        try {
            File file = new File(
                    String.valueOf(FileSystems.getDefault().
                            getPath("./")
                            .toAbsolutePath().getParent())
            );
            Path fullPath = Paths.get(file.getPath(), "capitals.txt");
            List<String> lines = Files.readAllLines(fullPath);

            Iterables.partition(lines, 2)
                    .forEach(entry -> capitals.put(
                            entry.get(0).trim(),
                            Integer.parseInt(entry.get(1))
                    ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Lazy Singleton initialization
    public static SingletonDatabase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonDatabase();
        }

        return INSTANCE;
    }

    @Override
    public int getPopulation(String name) {
        return capitals.get(name);
    }
}
