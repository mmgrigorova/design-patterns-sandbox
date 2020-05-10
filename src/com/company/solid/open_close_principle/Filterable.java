package com.company.solid.open_close_principle;

import com.company.solid.open_close_principle.specifications.Specification;

import java.util.List;
import java.util.stream.Stream;

public interface Filterable<T> {
    Stream<T> filter(List<T> items, Specification<T> spec);
}
