package com.company.solid_principles.open_close_principle.specifications;

public interface Specification<T> {
    boolean isSatisfied(T item);
}
