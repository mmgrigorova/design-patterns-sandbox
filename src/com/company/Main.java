package com.company;

import com.company.design_patterns.builder.CodeBuilder;
import com.company.design_patterns.factory.PersonFactory;
import com.company.design_patterns.factory.PersonInst;
import com.company.design_patterns.prototype.Line;
import com.company.design_patterns.prototype.Point;
import com.company.solid_principles.dependency_inversion.Person;
import com.company.solid_principles.dependency_inversion.Relationships;
import com.company.solid_principles.dependency_inversion.Research;
import com.company.solid_principles.liskov_substitution_principle.Demo;
import com.company.solid_principles.liskov_substitution_principle.Rectangle;
import com.company.solid_principles.liskov_substitution_principle.RectangleFactory;
import com.company.solid_principles.liskov_substitution_principle.Square;
import com.company.solid_principles.open_close_principle.Filter;
import com.company.solid_principles.open_close_principle.Product;
import com.company.solid_principles.open_close_principle.enums.Color;
import com.company.solid_principles.open_close_principle.enums.Size;
import com.company.solid_principles.open_close_principle.specifications.AndSpecification;
import com.company.solid_principles.open_close_principle.specifications.ColorSpecification;
import com.company.solid_principles.open_close_principle.specifications.SizeSpecification;
import com.company.solid_principles.single_responsibility_principle.Journal;
import com.company.solid_principles.single_responsibility_principle.Persistence;
import com.sun.org.apache.xml.internal.serializer.SerializationHandler;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
        Prototype Pattern - perform deep copies of object
        * */
        System.out.println();
        System.out.println("--- The Prototype Pattern ---");
        Line line = new Line(new Point(3,4), new Point(5, 6));
        Line line2 = line.deepCopy();
        line2.start = new Point(7, 8);

        System.out.println(line);
        System.out.println(line2);

         /*
        Factory Pattern - the single purpose of a factory is to create objects
        * */
        System.out.println();
        System.out.println("--- The Factory Pattern ---");
        PersonInst p0 = PersonFactory.createPerson("John");
        System.out.println(p0);
        PersonInst p1 = PersonFactory.createPerson("Margaret");
        System.out.println(p1);
        /*
        Builder Pattern
        * */
        System.out.println();
        System.out.println("--- The Builder Pattern ---");
        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");

        System.out.println(cb);

        /*
        05. Dependency Inversion
        A. High-level modules should not depend on low-level modules.
        Both should depend on abstractions.

        B. Abstractions should not depend on details.
        Details should depend on abstractions
         */
        System.out.println();
        System.out.println("--- Dependency Inversion ---");
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        // low-level module
        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);

        /*
        04. Interface Segregation
        Do not create more methods to implement than what is needed. Do not force classes
        to implement methods they don't need
        */
        System.out.println();
        System.out.println("--- Interface Segregation - no printable example ---");
        /*
        03. Liskov Substitution Principle
        You should be able to substitute a derived class for a base class
        In our case we have a Rectangle and a Square.
        We have incorrect behavior through inheritance
        We can use the Factory design pattern in this situation and get rid of the Square class altogether.
        The only difference with the rectangle is that the sides have the same width.
        */
        System.out.println();
        System.out.println("--- Liskov Substitution Principle ---");
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
        System.out.println();
        System.out.println("--- Open-close principle ---");

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
        System.out.println();
        System.out.println("--- Single responsibility principle ---");

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
