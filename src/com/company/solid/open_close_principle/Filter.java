package com.company.solid.open_close_principle;

import com.company.solid.open_close_principle.specifications.Specification;

import java.util.List;
import java.util.stream.Stream;

public class Filter implements Filterable<Product>{
    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream()
                .filter(spec::isSatisfied);
    }
}
