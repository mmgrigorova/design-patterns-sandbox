package com.company.solid.open_close_principle.specifications;

public interface Specification<T> {
    boolean isSatisfied(T item);
}
