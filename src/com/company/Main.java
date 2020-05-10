package com.company;

import com.company.solid.open_close_principle.specifications.AndSpecification;
import com.company.solid.open_close_principle.specifications.ColorSpecification;
import com.company.solid.open_close_principle.Filter;
import com.company.solid.open_close_principle.Product;
import com.company.solid.open_close_principle.enums.Color;
import com.company.solid.open_close_principle.enums.Size;
import com.company.solid.open_close_principle.specifications.SizeSpecification;
import com.company.solid.single_responsibility_principle.Journal;
import com.company.solid.single_responsibility_principle.Persistence;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /* 02. Open-close principle
           Opened for extension, closed for modification
           This example uses the Specification pattern which uses generic Specification<T> and Filter<T> interfaces
           that are open for extension
           If more we need to combine criteria, we can create AndSpecification<T> interfaces.
           */
        Product apple = new Product("apple", Color.RED, Size.SMALL);
        Product book = new Product("book", Color.GREEN, Size.SMALL);
        Product house = new Product("house", Color.BLUE, Size.HUGE);
        List<Product> products = Arrays.asList(apple, book, house);

        Filter filter = new Filter();
        filter.filter(products, new ColorSpecification(Color.RED)).forEach(System.out::println);
        filter.filter(products, new SizeSpecification(Size.HUGE)).forEach(System.out::println);

        filter.filter(products, new AndSpecification<>(new ColorSpecification(Color.GREEN), new SizeSpecification(Size.SMALL)))
                .forEach(System.out::println);

        /*
           01. Single responsibility principle demo
           A Journal class handles only the entries, there is a separate class handling persistence.
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
