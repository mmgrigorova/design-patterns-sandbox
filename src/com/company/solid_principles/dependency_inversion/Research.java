package com.company.solid_principles.dependency_inversion;

import java.util.List;

public class Research {
    public Research(RelationshipBrowser browser) {
        List<Person> children = browser.findAllChildrenOf("John");
        children.forEach(c -> System.out.println(
                "John has a child called " + c.getName()
        ));
    }
}
