package com.company.solid_principles.dependency_inversion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Relationships implements RelationshipBrowser {
    private List<Triplet<String, Relationship, Person>> relationships = new ArrayList<>();

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relationships.stream()
                .filter(r -> r.getValue0().equals(name) && r.getValue1().equals(Relationship.CHILD))
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }

    public void addParentAndChild(Person parent, Person child) {
        relationships.add(new Triplet<>(parent.getName(), Relationship.CHILD, child));
        relationships.add(new Triplet<>(child.getName(), Relationship.PARENT, parent));
    }
}
