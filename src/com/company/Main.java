package com.company;

import com.company.solid.liskov_substitution_principle.Demo;
import com.company.solid.liskov_substitution_principle.Rectangle;
import com.company.solid.liskov_substitution_principle.RectangleFactory;
import com.company.solid.liskov_substitution_principle.Square;
import com.company.solid.open_close_principle.Filter;
import com.company.solid.open_close_principle.Product;
import com.company.solid.open_close_principle.enums.Color;
import com.company.solid.open_close_principle.enums.Size;
import com.company.solid.open_close_principle.specifications.AndSpecification;
import com.company.solid.open_close_principle.specifications.ColorSpecification;
import com.company.solid.open_close_principle.specifications.SizeSpecification;
import com.company.solid.single_responsibility_principle.Journal;
import com.company.solid.single_responsibility_principle.Persistence;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
        03. Liskov Substitution Principle
        You should be able to substitute a derived class for a base class
        In our case we have a Rectangle and a Square.
        We have incorrect behavior through inheritance
        We can use the Factory design pattern in this situation and get rid of the Square class altogether.
        The only difference with the rectangle is that the sides have the same width.
        */
        Rectangle rc = new Rectangle(2,3);
        Demo.useIt(rc);

        //Wrong: Here we can have unexpected results.
        Rectangle sq = new Square();
        sq.setHeight(5);
        Demo.useIt(sq);

        //Correct: The Factory
        Rectangle square = RectangleFactory.newSquare(5);
        Demo.useIt(square);

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
