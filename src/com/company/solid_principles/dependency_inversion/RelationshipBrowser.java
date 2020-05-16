package com.company.solid_principles.dependency_inversion;

import java.util.List;

public interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}
